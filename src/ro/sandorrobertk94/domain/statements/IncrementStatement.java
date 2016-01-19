package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 16/01/16.
 */
public class IncrementStatement implements IStatement {
    private String varname;

    public IncrementStatement(String varname) {
        this.varname = varname;
    }

    public String getVarname() {
        return varname;
    }

    public void setVarname(String varname) {
        this.varname = varname;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        int old_value = state.getSymbolTable().get(varname);
        state.getSymbolTable().put(varname, old_value + 1);
        return null;
    }

    @Override
    public String toString() {
        return "inc ( " + varname + " )";
    }
}
