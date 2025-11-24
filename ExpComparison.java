import lib3652.util.VisitException;

public class ExpComparison extends Exp {
    private Cmp comparator;
    
    public ExpComparison(Cmp cmp, Exp left, Exp right) {
        super(cmp.toString(), left, right);
        this.comparator = cmp;
    }
    
    public Cmp getComparator() { 
        return comparator; 
    }
    
    public Exp getLeft() { 
        return getSubTree(0); 
    }
    
    public Exp getRight() { 
        return getSubTree(1); 
    }
    
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpComparison(this, arg);
    }
    
    public String toString() {
        return "(" + getLeft().toString() + " " + 
               comparator.toString() + " " + 
               getRight().toString() + ")";
    }
}