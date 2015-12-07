package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class PrintStatement implements IStatement {
    private IExpression expression;

    public PrintStatement(IExpression expression) {
        this.expression = expression;
    }

    public IExpression getExpression() {
        return expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        state.getOutput().add(expression.evaluate(state.getSymbolTable(), state.getHeap()).toString());
        return state;
    }

    @Override
    public String toString() {
        return " print( " + expression.toString() + " ) ";
    }
}
