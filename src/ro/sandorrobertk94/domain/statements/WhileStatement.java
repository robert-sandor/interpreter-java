package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class WhileStatement implements IStatement {
    private IExpression expression;
    private IStatement statement;

    public WhileStatement(IExpression expression, IStatement statement) {
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
    public void execute(ProgramState state) throws DomainException {
        Integer value = expression.evaluate(state.getSymbolTable());
        if (value != 0) {
            state.getExecutionStack().push(this);
            state.getExecutionStack().push(statement);
        }
    }

    @Override
    public String toString() {
        return " while ( " + expression.toString() + " ) do ( " + statement.toString() + " ) ";
    }
}
