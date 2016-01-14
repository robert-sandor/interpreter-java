package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IStack;
import ro.sandorrobertk94.domain.adts.LibStack;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 10/01/16.
 */
public class ForkStatement implements IStatement {
    private IStatement statement;

    public ForkStatement(IStatement statement) {
        this.statement = statement;
    }

    public IStatement getStatement() {
        return statement;
    }

    public void setStatement(IStatement statement) {
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        IStack<IStatement> stack = new LibStack<>();
        stack.push(statement);

        // TODO this should be cloned, but meh
        IDictionary<String, Integer> symbolTable = state.getSymbolTable();

        return new ProgramState(
                state.getId() * 10,
                stack,
                symbolTable,
                state.getOutput(),
                state.getHeap(),
                statement
        );
    }

    @Override
    public String toString() {
        return " fork ( " + statement.toString() + " ) ";
    }
}
