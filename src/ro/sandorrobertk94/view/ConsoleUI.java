package ro.sandorrobertk94.view;

import ro.sandorrobertk94.controller.Controller;
import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.adts.*;
import ro.sandorrobertk94.domain.expressions.*;
import ro.sandorrobertk94.domain.statements.*;
import ro.sandorrobertk94.exceptions.controller.ControllerException;
import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.repository.InvalidProgramIndexException;
import ro.sandorrobertk94.exceptions.repository.RepositoryException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Robert on 12/15/2015.
 */
public class ConsoleUI {
    private Controller controller;

    public ConsoleUI(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        while (true) {
            printMainMenu();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;
            System.out.print(" -> ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println("Invalid Option!");
            }

            switch (option) {
                case 1:
                    inputProgram();
                    break;
                case 2:
                    listPrograms();
                    break;
                case 3:
                    setCurrentProgram();
                    break;
                case 4:
                    setOutputFile();
                    break;
                case 5:
                    oneStep();
                    break;
                case 6:
                    allStep();
                    break;
                case 7:
                    return;
                default: {
                    System.err.println("Invalid input! Try again!");
                }
            }
        }
    }

    private void allStep() {
        try {
            controller.allStep(controller.getRepository().getCurrentProgram());
        } catch (ControllerException e) {
            System.err.println("Failed to execute all steps!");
        }
    }

    private void oneStep() {
        try {
            controller.oneStep(controller.getRepository().getCurrentProgram());
        } catch (ControllerException e) {
            System.err.println("Failed to execute step! ExeStack may be empty!");
        }
    }

    private void setOutputFile() {
        while (true) {
            System.out.print("1 : Console\n2 : File\n -> ");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;
            try {
                option = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println("Invalid option!");
            }

            switch (option) {
                case 1:
                    controller.setWriteToFile(false);
                    return;
                case 2:
                    System.out.print("Enter file name : ");
                    try {
                        String filePath = br.readLine();
                        controller.setWriteToFile(true);
                        controller.setLogFilePath(filePath);
                    } catch (IOException e) {
                        System.err.println("Invalid option!");
                    }
                    return;
                default: {
                    System.err.println("Invalid input! Try again!");
                }
            }
        }
    }

    private void setCurrentProgram() {
        System.out.print("ID between 0 and " +
                controller.getRepository().getPrograms().size() + " : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = 0;
        try {
            option = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println("Invalid index!");
        }

        try {
            controller.getRepository().setCurrentProgramIndex(option);
        } catch (InvalidProgramIndexException e) {
            System.err.println("Invalid index!");
        }
    }

    private void listPrograms() {
        System.out.println(controller.getRepository().getPrograms().toString());
    }

    private void inputProgram() {
        IStatement statement;

        int id = controller.getRepository().getPrograms().size();

        statement = inputStatement();
        IStack<IStatement> stack = new LibStack<>();

        try {
            stack.push(statement);
        } catch (ArrayOverflowException e) {
            System.err.println("Cannot push statement to stack!");
        }

        ProgramState state = new ProgramState(id, stack,
                new LibDictionary<String, Integer>(), new LibList<String>(),
                new LibHeap<Integer>(), statement);

        try {
            controller.getRepository().add(state);
        } catch (RepositoryException e) {
            System.err.println("Cannot add program state to repository!");
        }

        System.out.println("Program added with ID : " + id);
    }

    private IStatement inputStatement() {
        while (true) {
            printStatementMenu();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;
            System.out.print(" -> ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println("Invalid option!");
            }

            switch (option) {
                case 1:
                    return inputCompoundStatement();
                case 2:
                    return inputAssignmentStatement();
                case 3:
                    return inputIfStatement();
                case 4:
                    return inputIfThenStatement();
                case 5:
                    return inputWhileStatement();
                case 6:
                    return inputPrintStatement();
                case 7:
                    return inputNewStatement();
                case 8:
                    return inputWriteHeapStatement();
                case 9:
                    return inputSkipStatement();
                default: {
                    System.err.println("Invalid input! Try again!");
                }
            }
        }
    }

    private IStatement inputSkipStatement() {
        return new SkipStatement();
    }

    private IStatement inputWriteHeapStatement() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("\tInput varname -> ");
                String varname = br.readLine();
                System.out.println("\tInput expression -> ");
                IExpression expression = inputExpression();
                return new WriteHeapStatement(varname, expression);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IStatement inputNewStatement() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("\tInput varname -> ");
                String varname = br.readLine();
                System.out.println("\tInput expression -> ");
                IExpression expression = inputExpression();
                return new NewStatement(varname, expression);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IStatement inputPrintStatement() {
        System.out.println("\tInput expression -> ");
        IExpression expression = inputExpression();
        return new PrintStatement(expression);
    }

    private IStatement inputWhileStatement() {
        System.out.println("\tInput condition -> ");
        IExpression expression = inputExpression();
        System.out.println("\tInput statement -> ");
        IStatement statement = inputStatement();
        return new WhileStatement(expression, statement);
    }

    private IStatement inputIfThenStatement() {
        System.out.println("\tInput condition -> ");
        IExpression expression = inputExpression();
        System.out.println("\tInput then branch -> ");
        IStatement statement = inputStatement();
        return new IfThenStatement(expression, statement);
    }

    private IStatement inputIfStatement() {
        System.out.println("\tInput condition -> ");
        IExpression expression = inputExpression();
        System.out.println("\tInput then branch -> ");
        IStatement thenStatement = inputStatement();
        System.out.println("\tInput else branch -> ");
        IStatement elseStatement = inputStatement();
        return new IfStatement(expression, thenStatement, elseStatement);
    }

    private IStatement inputAssignmentStatement() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("\tInput varname -> ");
                String varname = br.readLine();
                System.out.println("\tInput expression -> ");
                IExpression expression = inputExpression();
                return new AssignmentStatement(varname, expression);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IStatement inputCompoundStatement() {
        System.out.println("\tInput left branch -> ");
        IStatement leftStatement = inputStatement();
        System.out.println("\tInput right branch -> ");
        IStatement rightStatement = inputStatement();
        return new CompoundStatement(leftStatement, rightStatement);
    }

    private IExpression inputExpression() {
        while (true) {
            printExpressionMenu();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int option = 0;
            System.out.print(" -> ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.err.println("Invalid option!");
            }

            switch (option) {
                case 1:
                    return inputConstantExpression();
                case 2:
                    return inputArithmeticExpression();
                case 3:
                    return inputVariableExpression();
                case 4:
                    return inputBooleanExpression();
                case 5:
                    return inputNotExpression();
                case 6:
                    return inputReadExpression();
                case 7:
                    return inputReadHeapExpression();
                default: {
                    System.err.println("Invalid input! Try again!");
                }
            }
        }
    }

    private IExpression inputReadHeapExpression() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("\tInput varname -> ");
                String varname = br.readLine();
                return new ReadHeapExpression(varname);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IExpression inputReadExpression() {
        return new ReadExpression();
    }

    private IExpression inputNotExpression() {
        System.out.println("\tInput expression -> ");
        IExpression expression = inputExpression();
        return new NotExpression(expression);
    }

    private IExpression inputBooleanExpression() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("\tInput left expression -> ");
                IExpression leftExpression = inputExpression();

                System.out.print("\tInput operand ( < <= == != > >= && || ) -> ");
                String op = br.readLine();
                BooleanExpression.Operator oper;
                switch (op) {
                    case "<": oper = BooleanExpression.Operator.LESS; break;
                    case "<=": oper = BooleanExpression.Operator.LESS_OR_EQUAL; break;
                    case "==": oper = BooleanExpression.Operator.EQUAL; break;
                    case "!=": oper = BooleanExpression.Operator.NOT_EQUAL; break;
                    case ">": oper = BooleanExpression.Operator.GREATER; break;
                    case ">=": oper = BooleanExpression.Operator.GREATER_OR_EQUAL; break;
                    case "&&": oper = BooleanExpression.Operator.AND; break;
                    case "||": oper = BooleanExpression.Operator.OR; break;
                    default : {
                        throw new IOException();
                    }
                }

                System.out.println("\tInput right expression -> ");
                IExpression rightExpression = inputExpression();
                return new BooleanExpression(oper, leftExpression, rightExpression);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IExpression inputArithmeticExpression() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("\tInput left expression -> ");
                IExpression leftExpression = inputExpression();

                System.out.print("\tInput operand ( + - * / ) -> ");
                String op = br.readLine();
                ArithmeticExpression.Operator oper;
                switch (op) {
                    case "+": oper = ArithmeticExpression.Operator.ADD; break;
                    case "-": oper = ArithmeticExpression.Operator.SUB; break;
                    case "*": oper = ArithmeticExpression.Operator.MUL; break;
                    case "/": oper = ArithmeticExpression.Operator.DIV; break;
                    default : {
                        throw new IOException();
                    }
                }

                System.out.println("\tInput right expression -> ");
                IExpression rightExpression = inputExpression();
                return new ArithmeticExpression(oper, leftExpression, rightExpression);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IExpression inputVariableExpression() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("\tInput varname -> ");
                String varname = br.readLine();
                return new VariableExpression(varname);
            } catch (IOException e) {
                System.err.print("Invalid variable name! Try again!");
            }
        }
    }

    private IExpression inputConstantExpression() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                Integer value = Integer.parseInt(br.readLine());
                return new ConstantExpression(value);
            } catch (IOException e) {
                System.err.print("Invalid constant! Try again!");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Input program");
        System.out.println("2. List programs");
        System.out.println("3. Set current program : " +
                controller.getRepository().getCurrentProgramIndex());
        System.out.println("4. Set output file : " +
                (!controller.isWriteToFile() ? "Console" : controller.getLogFilePath()));
        System.out.println("5. One Step");
        System.out.println("6. All Step");
        System.out.println("7. Exit");
    }

    private void printStatementMenu() {
        System.out.println("======-- Statements --======");
        System.out.println("1. leftStatement ; rightStatement");
        System.out.println("2. varname = expression");
        System.out.println("3. if (condition) then (thenStatement) else (elseStatement)");
        System.out.println("4. if (condition) then (thenStatement)");
        System.out.println("5. while (condition) do (statement)");
        System.out.println("6. print (expression)");
        System.out.println("7. new varname = expression");
        System.out.println("8. write_heap varname = expression");
        System.out.println("9. skip");
    }

    private void printExpressionMenu() {
        System.out.println("=====-- Expressions --=====");
        System.out.println("1. const");
        System.out.println("2. arithmetic");
        System.out.println("3. varname");
        System.out.println("4. boolean");
        System.out.println("5. not(expression)");
        System.out.println("6. read()");
        System.out.println("7. read_heap(varname)");
    }
}
