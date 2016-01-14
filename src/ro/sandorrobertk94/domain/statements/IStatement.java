package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.domain.DomainException;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public interface IStatement extends Serializable {
    ProgramState execute(ProgramState state) throws DomainException;

    String toString();
}
