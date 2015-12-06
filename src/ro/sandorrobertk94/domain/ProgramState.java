package ro.sandorrobertk94.domain;

import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IList;
import ro.sandorrobertk94.domain.adts.IStack;
import ro.sandorrobertk94.domain.statements.IStatement;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public class ProgramState implements Serializable {
    private Integer id;
    private IStack<IStatement> executionStack;
    private IDictionary<String, Integer> symbolTable;
    private IList<String> output;
    private IDictionary<String, Integer> heap;
    private IStatement originalProgram;

    public ProgramState(Integer id, IStack<IStatement> executionStack, IDictionary<String, Integer> symbolTable,
                        IList<String> output, IDictionary<String, Integer> heap, IStatement originalProgram) {
        this.id = id;
        this.executionStack = executionStack;
        this.symbolTable = symbolTable;
        this.output = output;
        this.heap = heap;
        this.originalProgram = originalProgram;
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

    public IDictionary<String, Integer> getHeap() {
        return heap;
    }

    public IStatement getOriginalProgram() {
        return originalProgram;
    }

    @Override
    public String toString() {
        String o = "ID : " + id.toString() + "\n";
        o += originalProgram.toString() + "\n\n";
        o += "ExecutionStack {" + executionStack.toString() + "}\n";
        o += "SymbolTable {" + symbolTable.toString() + "}\n";
        o += "Heap {" + heap.toString() + "}\n";
        o += "Output {" + output.toString() + "}\n";
        return o;
    }
}
