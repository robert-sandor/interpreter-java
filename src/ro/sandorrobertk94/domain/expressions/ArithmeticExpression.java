package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IList;
import ro.sandorrobertk94.exceptions.domain.DivisionByZeroException;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class ArithmeticExpression implements IExpression {
    public enum Operator {
        ADD, SUB, MUL, DIV
    }

    private Operator operator;
    private IExpression leftExpression;
    private IExpression rightExpression;

    public ArithmeticExpression(Operator operator, IExpression leftExpression, IExpression rightExpression) {
        this.operator = operator;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable, IList<Integer> heap) throws DomainException {
        Integer value = 0;
        switch (operator) {
            case ADD:
                value = leftExpression.evaluate(symbolTable, heap) + rightExpression.evaluate(symbolTable, heap);
                break;
            case SUB:
                value = leftExpression.evaluate(symbolTable, heap) - rightExpression.evaluate(symbolTable, heap);
                break;
            case MUL:
                value = leftExpression.evaluate(symbolTable, heap) * rightExpression.evaluate(symbolTable, heap);
                break;
            case DIV:
                Integer r = rightExpression.evaluate(symbolTable, heap);
                if (r == 0) {
                    throw new DivisionByZeroException();
                }
                value = leftExpression.evaluate(symbolTable, heap) / r;
                break;
        }
        return value;
    }

    @Override
    public String toString() {
        String op = "";
        switch (operator) {
            case ADD:
                op = " + ";
                break;
            case SUB:
                op = " - ";
                break;
            case MUL:
                op = " * ";
                break;
            case DIV:
                op = " / ";
                break;
        }
        return leftExpression.toString() + op + rightExpression.toString();
    }
}
