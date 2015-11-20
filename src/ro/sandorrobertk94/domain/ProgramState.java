package ro.sandorrobertk94.domain;

import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.util.*;

/**
 * Created by robert on 11/20/15.
 */
public class ProgramState {
    IStack<IStatement> executionStack;
    IDictionary<String, Integer> symbolTable;
    IList<String> output;
    IStatement originalProgram;

    public ProgramState(IStatement program) {
        this.originalProgram = program;
        this.executionStack = new LibraryStack();
        this.symbolTable = new LibraryDictionary();
        this.output = new LibraryList();
        try {
            this.executionStack.push(originalProgram);
        } catch (ArrayOverflowException ignored) {
        }
    }

    public IStack<IStatement> getExecutionStack() {
        return executionStack;
    }

    public IDictionary<String, Integer> getSymbolTable() {
        return symbolTable;
    }

    public IList<String> getOutput() {
        return output;
    }

    public IStatement getOriginalProgram() {
        return originalProgram;
    }

    @Override
    public String toString() {
        String output = "Program :\n" + this.originalProgram.toString() + "\n";
        output += "ExecutionStack :\n" + this.executionStack.toString() + "\n";
        output += "SymbolTable :\n" + this.symbolTable.toString() + "\n";
        output += "Output :\n" + this.output.toString() + "\n";
        return output;
    }
}
