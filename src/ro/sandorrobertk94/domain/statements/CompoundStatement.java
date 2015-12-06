package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class CompoundStatement implements IStatement {
    private IStatement leftStatement;
    private IStatement rightStatement;

    public CompoundStatement(IStatement leftStatement, IStatement rightStatement) {
        this.leftStatement = leftStatement;
        this.rightStatement = rightStatement;
    }

    public IStatement getLeftStatement() {
        return leftStatement;
    }

    public IStatement getRightStatement() {
        return rightStatement;
    }

    @Override
    public void execute(ProgramState state) throws DomainException {
        state.getExecutionStack().push(rightStatement);
        state.getExecutionStack().push(leftStatement);
    }

    @Override
    public String toString() {
        return leftStatement.toString() + " ; " + rightStatement.toString();
    }
}
