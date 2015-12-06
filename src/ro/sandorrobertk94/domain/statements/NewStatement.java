package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class NewStatement implements IStatement {
    private String varname;
    private IExpression expression;

    public NewStatement(String varname, IExpression expression) {
        this.varname = varname;
        this.expression = expression;
    }

    @Override
    public void execute(ProgramState state) throws DomainException {
        state.getHeap().add(expression.evaluate(state.getSymbolTable()));
        state.getSymbolTable().put(varname, state.getHeap().size() - 1);
    }

    @Override
    public String toString() {
        return " new ( " + varname + " , " + expression.toString() + " ) ";
    }
}
