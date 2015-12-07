package ro.sandorrobertk94.controller;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.adts.IStack;
import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.controller.ControllerException;
import ro.sandorrobertk94.repository.IRepository;

/**
 * Created by robert on 12/7/15.
 */
public class Controller {
    private IRepository repository;
    private String logFilePath;
    private boolean writeToFile;

    public Controller(IRepository repository) {
        this.repository = repository;
        logFilePath = null;
        writeToFile = false;
    }

    ProgramState oneStep(ProgramState state) throws ControllerException {
        IStack<IStatement> stack = state.getExecutionStack();
        IStatement currentStatement = stack.pop();

        if (writeToFile && logFilePath != null) {
            repository.saveStateToFile(state, logFilePath);
        } else {
            System.out.println(state.toString());
        }

        return currentStatement.execute(state);
    }

    void allStep(ProgramState state) throws ControllerException {
        while (!state.getExecutionStack().isEmpty()) {
            oneStep(state);
        }
    }
}
