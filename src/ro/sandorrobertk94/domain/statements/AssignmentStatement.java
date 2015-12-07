package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class AssignmentStatement implements IStatement {
    private String variableName;
    private IExpression expression;

    public AssignmentStatement(String variableName, IExpression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    public String getVariableName() {
        return variableName;
    }

    public IExpression getExpression() {
        return expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        state.getSymbolTable().put(variableName, expression.evaluate(state.getSymbolTable(),
                state.getHeap()));
        return state;
    }

    @Override
    public String toString() {
        return variableName + " = " + expression.toString();
    }
}
