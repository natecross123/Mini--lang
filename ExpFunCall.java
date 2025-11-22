import java.util.ArrayList;

/**
 * IR Class to represent a function call
 */
public class ExpFunCall extends Exp {
    private String name;
    
    // Implement this class
 
   public ExpFunCall(String name, ArrayList<Exp> args) {
        super("call", args);
        this.name = name;
    }
    
    public String getName() { return name; }
    public ArrayList<Exp> getArgs() { return getSubTrees(); }
    
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpFunCall(this, arg);
    }
    
    public String toString() {
        return name + "(...)";
    }
    
}

