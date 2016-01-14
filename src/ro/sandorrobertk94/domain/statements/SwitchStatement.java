package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.expressions.ArithmeticExpression;
import ro.sandorrobertk94.domain.expressions.IExpression;
import ro.sandorrobertk94.domain.expressions.VariableExpression;
import ro.sandorrobertk94.exceptions.domain.DomainException;

/**
 * Created by robert on 12/6/15.
 */
public class SwitchStatement implements IStatement {
    private String varname;
    private IExpression expression1;
    private IExpression expression2;
    private IStatement statement1;
    private IStatement statement2;
    private IStatement defaultStatement;

    public SwitchStatement(String varname, IExpression expression1, IExpression expression2, IStatement statement1,
                           IStatement statement2, IStatement defaultStatement) {
        this.varname = varname;
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.statement1 = statement1;
        this.statement2 = statement2;
        this.defaultStatement = defaultStatement;
    }

    public String getVarname() {
        return varname;
    }

    public IExpression getExpression1() {
        return expression1;
    }

    public IExpression getExpression2() {
        return expression2;
    }

    public IStatement getStatement1() {
        return statement1;
    }

    public IStatement getStatement2() {
        return statement2;
    }

    public IStatement getDefaultStatement() {
        return defaultStatement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        state.getExecutionStack().push(
                new IfStatement(
                        new ArithmeticExpression(
                                ArithmeticExpression.Operator.SUB,
                                new VariableExpression(varname),
                                expression1),
                        new IfStatement(
                                new ArithmeticExpression(
                                        ArithmeticExpression.Operator.SUB,
                                        new VariableExpression(varname),
                                        expression2),
                                defaultStatement,
                                statement1
                        ),
                        statement2
                ));
        return null;
    }

    @Override
    public String toString() {
        return " switch ( " + varname + " ) case ( " + expression1.toString() + " ) : ( " + statement1.toString() +
                " ) case ( " + expression2.toString() + " ) : ( " + statement2.toString() + " ) default : ( " +
                defaultStatement.toString() + " ) ";
    }
}
