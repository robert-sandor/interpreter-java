package ro.sandorrobertk94.domain.expression;

import ro.sandorrobertk94.util.IDictionary;

import java.io.Serializable;

/**
 * Created by robert on 11/20/15.
 */
public interface IExpression extends Serializable {
    Integer eval(IDictionary<String, Integer> symbolTable);
    String toString();
}
