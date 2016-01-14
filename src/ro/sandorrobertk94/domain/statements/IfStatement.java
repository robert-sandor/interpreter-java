package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class IfStatement implements IStatement {
    private IExpression expression;
    private IStatement thenStatement;
    private IStatement elseStatement;

    public IfStatement(IExpression expression, IStatement thenStatement, IStatement elseStatement) {
        this.expression = expression;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public IExpression getExpression() {
        return expression;
    }

    public IStatement getThenStatement() {
        return thenStatement;
    }

    public IStatement getElseStatement() {
        return elseStatement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        Integer value = expression.evaluate(state.getSymbolTable(), state.getHeap());
        if (value != 0) {
            state.getExecutionStack().push(thenStatement);
        } else {
            state.getExecutionStack().push(elseStatement);
        }
        return null;
    }

    @Override
    public String toString() {
        return " if ( " + expression.toString() + " ) then ( " + thenStatement.toString() + " ) else ( " +
                elseStatement.toString() + " ) ";
    }
}
