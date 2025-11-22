import java.util.ArrayList;
import lib3652.util.VisitException;


public class ExpIf extends Exp {
    private Exp predicate;
    private Exp consequent;
    private ArrayList<ConditionalClause> elifClauses;
    private Exp alternative;  
    
    public ExpIf(Exp predicate, Exp consequent, 
                 ArrayList<ConditionalClause> elifClauses, 
                 Exp alternative) {
        super("if");
        this.predicate = predicate;
        this.consequent = consequent;
        this.elifClauses = elifClauses;
        this.alternative = alternative;
    }
    
    public Exp getPredicate() { 
        return predicate; 
    }
    
    public Exp getConsequent() { 
        return consequent; 
    }
    
    public ArrayList<ConditionalClause> getElifClauses() { 
        return elifClauses; 
    }
    
    public Exp getAlternative() { 
        return alternative; 
    }
    
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpIf(this, arg);
    }
    
    public String toString() {
        return "if ... end";
    }
}