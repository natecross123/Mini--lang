import java.util.ArrayList;
import lib3652.util.ASTNode;
import lib3652.util.ASTVisitor;
import lib3652.util.VisitException;

/** A placeholder class to represent an arbitrary expression.  For
 * ArithExp, this class is really the top level ASTNode class, but by
 * including the ASTNode class as well, this code can be readily
 * generalised to larger languages that may have more sophisticated
 * forms than only algebraic expressions in it.
*/
public abstract class Exp extends ASTNode<Exp> {
    
    protected Exp(String name, Exp... subExps) {
	super(name, subExps);
    }

    protected Exp(String name, ArrayList<Exp> subExps) {
	super(name, subExps);
    }

    public abstract <S, T> T visit(Visitor<S, T> visitor, S state)
	throws VisitException;

    public <S, T> T visit(ASTVisitor<S, T> v, S state) throws VisitException {
	Visitor<S, T> av = (Visitor<S, T>) v;
	return visit(av, state);
    }

}
