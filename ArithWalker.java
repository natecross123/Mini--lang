import lib3652.util.PersistentWalker;
import java.io.Reader;
import java_cup.runtime.lr_parser;

public class ArithWalker<S, T> extends PersistentWalker<S, T> {

    public ArithWalker(Visitor<S, T> visitor) {
	super(visitor);
    }

    @Override
    public lr_parser mkParser(Reader input) {
	return new ArithParser(new Lexer(input));
    }

}
