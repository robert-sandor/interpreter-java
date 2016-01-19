package ro.sandorrobertk94.domain.statements;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IStack;
import ro.sandorrobertk94.domain.adts.LibDictionary;
import ro.sandorrobertk94.domain.adts.LibStack;
import ro.sandorrobertk94.exceptions.domain.DivisionByZeroException;
import ro.sandorrobertk94.exceptions.domain.DomainException;

import java.io.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by robert on 10/01/16.
 */
public class ForkStatement implements IStatement {
    private IStatement statement;

    public ForkStatement(IStatement statement) {
        this.statement = statement;
    }

    public IStatement getStatement() {
        return statement;
    }

    public void setStatement(IStatement statement) {
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws DomainException {
        IStack<IStatement> stack = new LibStack<>();

        try (
                OutputStream outputStream = new FileOutputStream("temp.bin");
                OutputStream buffer = new BufferedOutputStream(outputStream);
                ObjectOutput output = new ObjectOutputStream(buffer)
                ) {
            output.writeObject(state.getSymbolTable());
        } catch (IOException e) {
            e.printStackTrace();
        }

        IDictionary<String, Integer> symbolTable;
        try (
                InputStream file = new FileInputStream("temp.bin");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer)
        ) {
            symbolTable = (LibDictionary<String, Integer>) input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new DivisionByZeroException();
        }

        return new ProgramState(
                state.getId() * 10,
                stack,
                symbolTable,
                state.getOutput(),
                state.getHeap(),
                statement
        );
    }

    @Override
    public String toString() {
        return " fork ( " + statement.toString() + " ) ";
    }
}
