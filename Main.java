import java_cup.runtime.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.ArrayList;
import lib3652.util.Result;
import lib3652.util.TokenException;
import lib3652.util.MainHelper;

public class Main {

    public static void usage() {
	String[] usageMsg = new String[]{
	    String.format("Usage: <javaexec> %s [file ...]", 
                      Main.class.getName()),
	    "",
	    "The sequence of filenames provided afterwards is optional.  Each",
	    "will be read and traversed in the order given.  If a '-' is",
	    "specified, input will be read from stdin.  If no files are given,",
	    "input willl be read from stdin."
	};
	for (String line : usageMsg) {
	    System.out.println(line);
	}
    }

    public static <S, T> void main(String args[]) {
	int n = args.length;
	// default to Evaluator class as visitor
	String visitorClassName = Evaluator.class.getName();
	ArrayList<String> filenames = new ArrayList<>();
	
	// Parse command line arguments
	for (int i = 0; i  < n; i++) {
	    String arg = args[i];
	    if (arg.equals("-h") || arg.equals("--help")) {
		usage();
		System.exit(0);
	    } else if (arg.equals("-v")) {
		visitorClassName = args[i+1];
		i += 1;
	    } else {
		filenames.add(arg);
	    }
	}

	// Now try to create an instance of the visitor
	try {
	    Class<? extends Visitor<S, T>> visitorClass =
	      (Class<? extends Visitor<S, T>>) Class.forName(visitorClassName);
	    Constructor<? extends Visitor<S, T>> cons =
		visitorClass.getDeclaredConstructor();
	    Visitor visitor =  cons.newInstance();
	    ArithWalker walker = new ArithWalker(visitor);
	    MainHelper.walkFiles(walker, filenames);
	} catch (ClassNotFoundException cnfe) {
	    System.err.println(cnfe.getMessage());
	    cnfe.printStackTrace();
	    System.exit(1);
	} catch (InvocationTargetException | NoSuchMethodException e) {
	    System.err.println(e.getMessage());
	    e.printStackTrace();
	    System.exit(1);
	} catch (InstantiationException ie) {
	    System.err.println(ie.getMessage());
	    ie.printStackTrace();
	    System.exit(1);
	} catch (IllegalAccessException iae) {
	    System.err.println(iae.getMessage());
	    iae.printStackTrace();
	    System.exit(1);
	}
    }
    
}
