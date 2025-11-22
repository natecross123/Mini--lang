import java.util.ArrayList;

/**
 * IR Class to represent a function definition
 */
public class StmtFunDefn extends Statement {
    private String name;
    private ArrayList<String> params;

    public StmtFunDefn(String name, ArrayList<String> params, Exp body) {
        super("funDef", body);
        this.name = name;
        this.params = params;
    }
     
    public String getName() { return name; }
    public ArrayList<String> getParams() { return params; }
    public Exp getBody() { return getSubTree(0); }
    
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitStmtFunDefn(this, arg);
    }
    
    public String toString() {
        return "fun " + name + "(" + String.join(", ", params) + ") = ...";
    }
}


