package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class VariableExpression implements IExpression {
    private String varname;

    public VariableExpression(String varname) {
        this.varname = varname;
    }

    public String getVarname() {
        return varname;
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable) throws DomainException {
        return symbolTable.get(varname);
    }

    @Override
    public String toString() {
        return varname;
    }
}
