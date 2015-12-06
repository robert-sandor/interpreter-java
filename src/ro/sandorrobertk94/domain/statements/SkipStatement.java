package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class SkipStatement implements IStatement {
    public SkipStatement() {
    }

    @Override
    public void execute(ProgramState state) throws DomainException {

    }

    @Override
    public String toString() {
        return " skip ";
    }
}
