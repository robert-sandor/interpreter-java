package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;
import ro.sandorrobertk94.exceptions.domain.IndexOutOfBoundsException;
import ro.sandorrobertk94.exceptions.domain.InvalidHeapAddressException;

/**
 * Created by robert on 12/6/15.
 */
public class WriteHeapStatement implements IStatement {
    private String varname;
    private IExpression expression;

    public WriteHeapStatement(String varname, IExpression expression) {
        this.varname = varname;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        Integer addr = state.getSymbolTable().get(varname);

        try {
            state.getHeap().update(addr, expression.evaluate(state.getSymbolTable(), state.getHeap()));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidHeapAddressException();
        }
        return state;
    }

    @Override
    public String toString() {
        return " write_heap ( " + varname + " , " + expression.toString() + " ) ";
    }
}
