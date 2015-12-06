package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IList;
import ro.sandorrobertk94.exceptions.domain.DomainException;

import java.util.Objects;

/**
 * Created by robert on 12/6/15.
 */
public class BooleanExpression implements IExpression {
    public enum Operator {
        LESS, LESS_OR_EQUAL, EQUAL, NOTEQUAL, GREATER, GREATER_OR_EQUAL, AND, OR
    }

    private Operator operator;
    private IExpression leftExpression;
    private IExpression rightExpression;

    public BooleanExpression(Operator operator, IExpression leftExpression, IExpression rightExpression) {
        this.operator = operator;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable, IList<Integer> heap) throws DomainException {
        Integer value = 0;
        Integer l = leftExpression.evaluate(symbolTable, heap);
        Integer r = rightExpression.evaluate(symbolTable, heap);
        switch (operator) {
            case LESS:
                value = (l < r) ? 1 : 0;
                break;
            case LESS_OR_EQUAL:
                value = (l <= r) ? 1 : 0;
                break;
            case EQUAL:
                value = (Objects.equals(l, r)) ? 1 : 0;
                break;
            case NOTEQUAL:
                value = (!Objects.equals(l, r)) ? 1 : 0;
                break;
            case GREATER:
                value = (l > r) ? 1 : 0;
                break;
            case GREATER_OR_EQUAL:
                value = (l >= r) ? 1 : 0;
                break;
            case AND:
                value = (l != 0 && r != 0) ? 1 : 0;
                break;
            case OR:
                value = (l != 0 || r != 0) ? 1 : 0;
                break;
        }
        return value;
    }

    @Override
    public String toString() {
        String op = "";
        switch (operator) {
            case LESS:
                op = " < ";
                break;
            case LESS_OR_EQUAL:
                op = " <= ";
                break;
            case EQUAL:
                op = " == ";
                break;
            case NOTEQUAL:
                op = " != ";
                break;
            case GREATER:
                op = " > ";
                break;
            case GREATER_OR_EQUAL:
                op = " >= ";
                break;
            case AND:
                op = " && ";
                break;
            case OR:
                op = " || ";
                break;
        }
        return leftExpression.toString() + op + rightExpression.toString();
    }
}
