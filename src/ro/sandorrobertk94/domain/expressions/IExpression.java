package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IHeap;
import ro.sandorrobertk94.exceptions.domain.DomainException;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public interface IExpression extends Serializable {
    Integer evaluate(IDictionary<String, Integer> symbolTable, IHeap<Integer> heap) throws DomainException;

    String toString();
}
