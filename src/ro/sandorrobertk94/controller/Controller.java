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

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public boolean isWriteToFile() {
        return writeToFile;
    }

    public void setWriteToFile(boolean writeToFile) {
        this.writeToFile = writeToFile;
    }

    public IRepository getRepository() {
        return repository;
    }

    public ProgramState oneStep(ProgramState state) throws ControllerException {
        IStack<IStatement> stack = state.getExecutionStack();
        IStatement currentStatement = stack.pop();
        currentStatement.execute(state);

        if (writeToFile && logFilePath != null) {
            repository.saveStateToFile(state, logFilePath);
        } else {
            System.out.println(state.toString());
        }

        return state;
    }

    public void allStep(ProgramState state) throws ControllerException {
        while (!state.getExecutionStack().isEmpty()) {
            oneStep(state);
        }
    }
}
