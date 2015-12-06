package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IList;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class ReadHeapExpression implements IExpression {
    private String varname;

    public ReadHeapExpression(String varname) {
        this.varname = varname;
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable, IList<Integer> heap) throws DomainException {
        Integer address = symbolTable.get(varname);
        return heap.get(address);
    }

    @Override
    public String toString() {
        return " read_heap ( " + varname + " ) ";
    }
}
