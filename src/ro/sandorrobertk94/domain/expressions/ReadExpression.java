package ro.sandorrobertk94.domain.expressions;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.exceptions.domain.DomainException;
import ro.sandorrobertk94.exceptions.domain.InputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robert on 12/6/15.
 */
public class ReadExpression implements IExpression {
    public ReadExpression() {
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable) throws DomainException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer input;
        try {
            input = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new InputException();
        }
        return input;
    }

    @Override
    public String toString() {
        return " read() ";
    }
}
