package org.alessio29.savagebot.r2.tree;

public class CarcosaRollExpression extends Expression {
    private final Expression diceCountArg;

    public CarcosaRollExpression(String text, Expression diceCountArg) {
        super(text);
        this.diceCountArg = diceCountArg;
    }

    public Expression getDiceCountArg() {
        return diceCountArg;
    }

    @Override
    public <V> V accept(Visitor<V> visitor) {
        return visitor.visitCarcosaRollExpression(this);
    }
}
