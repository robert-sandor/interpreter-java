package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IHeap;
import ro.sandorrobertk94.domain.adts.IList;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class ConstantExpression implements IExpression {
    private Integer value;

    public ConstantExpression(Integer value) {
        this.value = value;
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable, IHeap<Integer> heap) throws DomainException {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
