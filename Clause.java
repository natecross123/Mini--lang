public class Clause {
    private Exp predicate;
    private Exp consequent;

    public Clause(Exp predicate, Exp consequent) {
        this.predicate = predicate;
        this.consequent = consequent;
    }

    public Exp getPredicate() {
        return predicate;
    }

    public Exp getConsequent() {
        return consequent;
    }
}