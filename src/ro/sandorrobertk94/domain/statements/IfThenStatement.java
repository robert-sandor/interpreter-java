package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class IfThenStatement implements IStatement {
    private IExpression expression;
    private IStatement statement;

    public IfThenStatement(IExpression expression, IStatement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    public IExpression getExpression() {
        return expression;
    }

    public IStatement getStatement() {
        return statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        state.getExecutionStack().push(new IfStatement(expression, statement, new SkipStatement()));
        return null;
    }

    @Override
    public String toString() {
        return " if ( " + expression.toString() + " ) then ( " + statement.toString() + " ) ";
    }
}
