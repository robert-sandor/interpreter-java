package ro.sandorrobertk94.domain;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IHeap;
import ro.sandorrobertk94.domain.adts.IList;
import ro.sandorrobertk94.domain.adts.IStack;
import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.DomainException;
import ro.sandorrobertk94.exceptions.domain.EmptyStackException;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public class ProgramState implements Serializable {
    private Integer id;
    private IStack<IStatement> executionStack;
    private IDictionary<String, Integer> symbolTable;
    private IList<String> output;
    private IHeap<Integer> heap;
    private IStatement originalProgram;

    public ProgramState(Integer id, IStack<IStatement> executionStack, IDictionary<String, Integer> symbolTable,
                        IList<String> output, IHeap<Integer> heap, IStatement originalProgram) throws ArrayOverflowException {
        this.id = id;
        this.executionStack = executionStack;
        this.symbolTable = symbolTable;
        this.output = output;
        this.heap = heap;
        this.originalProgram = originalProgram;
        this.executionStack.push(originalProgram);
    }

    public Integer getId() {
        return id;
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

    public IHeap<Integer> getHeap() {
        return heap;
    }

    public IStatement getOriginalProgram() {
        return originalProgram;
    }

    public boolean isNotCompleted() {
        return !executionStack.isEmpty();
    }

    public ProgramState oneStep() throws DomainException {
        if (executionStack.isEmpty()) {
            throw new EmptyStackException();
        }

        IStatement currentStatement = executionStack.pop();
        return currentStatement.execute(this);
    }

    @Override
    public String toString() {
        String o = "=======================================================";
        o += "\nID : " + id.toString() + "\n";
        o += originalProgram.toString() + "\n\n";
        o += "ExecutionStack {\n" + executionStack.toString() + "}\n\n";
        o += "SymbolTable {\n" + symbolTable.toString() + "}\n\n";
        o += "Heap {\n" + heap.toString() + "}\n\n";
        o += "Output {\n" + output.toString() + "}\n\n";
        return o;
    }
}
