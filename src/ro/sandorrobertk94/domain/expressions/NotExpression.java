package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IHeap;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class NotExpression implements IExpression {
    IExpression expression;

    public NotExpression(IExpression expression) {
        this.expression = expression;
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable, IHeap<Integer> heap) throws DomainException {
        Integer val = expression.evaluate(symbolTable, heap);
        return (val == 0) ? 1 : 0;
    }

    @Override
    public String toString() {
        return " !( " + expression.toString() + " ) ";
    }
}
