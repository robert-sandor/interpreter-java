package ro.sandorrobertk94;

import ro.sandorrobertk94.controller.Controller;
import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.domain.adts.*;
import ro.sandorrobertk94.domain.expressions.ConstantExpression;
import ro.sandorrobertk94.domain.expressions.ReadHeapExpression;
import ro.sandorrobertk94.domain.statements.*;
import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.repository.RepositoryException;
import ro.sandorrobertk94.repository.IRepository;
import ro.sandorrobertk94.repository.Repository;
import ro.sandorrobertk94.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        // new v = 10; wh v = 7; print(v)
        IStatement statement = new CompoundStatement(
                new NewStatement(
                        "v",
                        new ConstantExpression(10)
                ),
                new CompoundStatement(
                        new WriteHeapStatement(
                                "v",
                                new ConstantExpression(7)
                        ),
                        new PrintStatement(
                                new ReadHeapExpression("v")
                        )
                )
        );
        IStack<IStatement> stack = new LibStack<>();
        try {
            stack.push(statement);
        } catch (ArrayOverflowException ignored) {}
        ProgramState state = new ProgramState(0, stack,
                new LibDictionary<String, Integer>(), new LibList<String>(),
                new LibHeap<Integer>(), statement);

        IRepository repository = new Repository();

        try {
            repository.add(state);
            repository.setCurrentProgramIndex(0);
        } catch (RepositoryException ignored) {}

        Controller controller = new Controller(repository);
        ConsoleUI consoleUI = new ConsoleUI(controller);
        consoleUI.run();
    }
}
