package ro.sandorrobertk94.view.gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import ro.sandorrobertk94.controller.Controller;
import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.adts.LibDictionary;
import ro.sandorrobertk94.domain.adts.LibHeap;
import ro.sandorrobertk94.domain.adts.LibList;
import ro.sandorrobertk94.domain.adts.LibStack;
import ro.sandorrobertk94.domain.expressions.*;
import ro.sandorrobertk94.domain.statements.*;
import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InputProgramViewController extends AnchorPane {
    private static Controller controller;
    public TextArea textArea;

    public void newAction(ActionEvent actionEvent) throws IOException, ArrayOverflowException {
        IStatement stmt = newStatement("First");
//        IStatement stmt = new CompoundStatement(
//                new AssignmentStatement("v", new ConstantExpression(10)),
//                new CompoundStatement(
//                        new NewStatement("a", new ConstantExpression(22)),
//                        new CompoundStatement(
//                                new ForkStatement(
//                                        new CompoundStatement(
//                                                new WriteHeapStatement("a", new ConstantExpression(30)),
//                                                new CompoundStatement(
//                                                        new AssignmentStatement("v", new ConstantExpression(32)),
//                                                        new CompoundStatement(
//                                                                new PrintStatement(new VariableExpression("v")),
//                                                                new PrintStatement(new ReadHeapExpression("a"))
//                                                        )
//                                                )
//                                        )
//                                ),
//                                new CompoundStatement(
//                                        new PrintStatement(new VariableExpression("v")),
//                                        new PrintStatement(new ReadHeapExpression("a"))
//                                )
//                        )
//                )
//        );
        List<ProgramState> programs = new ArrayList<>();
        programs.add(new ProgramState(1, new LibStack<>(), new LibDictionary<>(), new LibList<>(), new LibHeap<>(), stmt));
        controller.getRepository().setPrograms(programs);
        textArea.setText(stmt.toString());
    }

    private String newString(String content) throws IOException {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setContentText(content);
        Optional<String> result = textInputDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        throw new IOException();
    }

    private IExpression newExpression(String content) throws IOException {
        String[] expressionsStirngs = {"Arithmetic Expression", "Constant Expression",
                "Variable Expression", "Boolean Expression", "Not Expression",
                "Read Value", "Read Heap"};

        ChoiceDialog<String> expresionDialog = new ChoiceDialog<>(expressionsStirngs[0], expressionsStirngs);
        expresionDialog.setContentText(content);
        Optional<String> result = expresionDialog.showAndWait();
        if (result.isPresent()) {
            String choice = result.get();
            if (choice.equals(expressionsStirngs[0])) {
                String operator = newString("Enter operator (+, -, *): ");
                ArithmeticExpression.Operator oper;
                switch (operator) {
                    case "+":
                        oper = ArithmeticExpression.Operator.ADD;
                        break;
                    case "-":
                        oper = ArithmeticExpression.Operator.SUB;
                        break;
                    case "*":
                        oper = ArithmeticExpression.Operator.MUL;
                        break;
                    case "/":
                        oper = ArithmeticExpression.Operator.DIV;
                        break;
                    default: {
                        throw new IOException();
                    }
                }
                IExpression left = newExpression("Left Expression: ");
                IExpression right = newExpression("Right Expression: ");
                return new ArithmeticExpression(oper, left, right);
            }
            if (choice.equals(expressionsStirngs[1])) {
                Integer value = Integer.valueOf(newString("Enter constant value: "));
                return new ConstantExpression(value);
            }
            if (choice.equals(expressionsStirngs[2])) {
                String name = newString("Name: ");
                return new VariableExpression(name);
            }
            if (choice.equals(expressionsStirngs[3])) {
                String operator = newString("Enter operator (&&, ||): ");
                BooleanExpression.Operator oper;
                switch (operator) {
                    case "<":
                        oper = BooleanExpression.Operator.LESS;
                        break;
                    case "<=":
                        oper = BooleanExpression.Operator.LESS_OR_EQUAL;
                        break;
                    case "==":
                        oper = BooleanExpression.Operator.EQUAL;
                        break;
                    case "!=":
                        oper = BooleanExpression.Operator.NOT_EQUAL;
                        break;
                    case ">":
                        oper = BooleanExpression.Operator.GREATER;
                        break;
                    case ">=":
                        oper = BooleanExpression.Operator.GREATER_OR_EQUAL;
                        break;
                    case "&&":
                        oper = BooleanExpression.Operator.AND;
                        break;
                    case "||":
                        oper = BooleanExpression.Operator.OR;
                        break;
                    default: {
                        throw new IOException();
                    }
                }
                IExpression left = newExpression("Left Expression: ");
                IExpression right = newExpression("Right Expression: ");
                return new BooleanExpression(oper, left, right);
            }
            if (choice.equals(expressionsStirngs[4])) {
                IExpression right = newExpression("Expression: ");
                return new NotExpression(right);
            }
            if (choice.equals(expressionsStirngs[5])) {
                return new ReadExpression();
            }
            if (choice.equals(expressionsStirngs[6])) {
                String name = newString("Name: ");
                return new ReadHeapExpression(name);
            }
        }
        throw new IOException();
    }

    private IStatement newStatement(String content) throws IOException {
        String[] statementsStrings = {"Compound Statement", "Assign Statement", "Print Statement",
                "If Statement", "While Statement", "IfThen Statement", "Switch Statement", "Skip Statement",
                "New Statement", "Write Heap", "Fork"};
        ChoiceDialog<String> stmtDialog = new ChoiceDialog<>(statementsStrings[0], statementsStrings);
        stmtDialog.setContentText(content);
        Optional<String> result = stmtDialog.showAndWait();
        if (result.isPresent()) {
            String choice = result.get();
            if (choice.equals(statementsStrings[0])) {
                IStatement first = newStatement("First Statement:");
                IStatement second = newStatement("Second Statement:");
                return new CompoundStatement(first, second);
            }
            if (choice.equals(statementsStrings[1])) {
                String name = newString("Name: ");
                IExpression value = newExpression("Assigned value: ");
                return new AssignmentStatement(name, value);
            }
            if (choice.equals(statementsStrings[2])) {
                IExpression expression = newExpression("Expression: ");
                return new PrintStatement(expression);
            }
            if (choice.equals(statementsStrings[3])) {
                IExpression condition = newExpression("Condition: ");
                IStatement thenStatement = newStatement("Then branch: ");
                IStatement elseStatement = newStatement("Else branch: ");
                return new IfStatement(condition, thenStatement, elseStatement);
            }
            if (choice.equals(statementsStrings[4])) {
                IExpression condition = newExpression("Condition: ");
                IStatement body = newStatement("Body: ");
                return new WhileStatement(condition, body);
            }
            if (choice.equals(statementsStrings[5])) {
                IExpression condition = newExpression("Condition: ");
                IStatement thenStatement = newStatement("Then branch: ");
                return new IfThenStatement(condition, thenStatement);
            }
            if (choice.equals(statementsStrings[6])) {
                String varname = newString("Variable to switch : ");
                IExpression case1Expression = newExpression("Case 1 Expression:");
                IStatement case1Statement = newStatement("Case 1 Statement:");
                IExpression case2Expression = newExpression("Case 2 Expression:");
                IStatement case2Statement = newStatement("Case 2 Statement:");
                IStatement defaultStatement = newStatement("Default Statement:");
                return new SwitchStatement(varname, case1Expression, case2Expression, case1Statement, case2Statement, defaultStatement);
            }
            if (choice.equals(statementsStrings[7])) {
                return new SkipStatement();
            }
            if (choice.equals(statementsStrings[8])) {
                String name = newString("Name: ");
                IExpression expression = newExpression("Expression: ");
                return new NewStatement(name, expression);
            }
            if (choice.equals(statementsStrings[9])) {
                String name = newString("Name: ");
                IExpression expression = newExpression("Expression: ");
                return new WriteHeapStatement(name, expression);
            }
            if (choice.equals(statementsStrings[10])) {
                return new ForkStatement(newStatement("Statement: "));
            }
        }
        throw new IOException();
    }

    public void backAction(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void setController(Controller controller) {
        InputProgramViewController.controller = controller;
    }
}
