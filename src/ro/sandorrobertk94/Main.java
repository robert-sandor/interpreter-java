package ro.sandorrobertk94;

public class Main {
    public static void main(String[] args) throws InterruptedException {


//        IStatement statement = new CompoundStatement (
//                new AssignmentStatement ("v", new ConstantExpression (10)),
//                new CompoundStatement (
//                        new NewStatement ("a", new ConstantExpression (22)),
//                        new CompoundStatement (
//                                new ForkStatement (
//                                        new CompoundStatement (
//                                                new WriteHeapStatement ("a", new ConstantExpression (30)),
//                                                new CompoundStatement (
//                                                        new AssignmentStatement ("v", new ConstantExpression (32)),
//                                                        new CompoundStatement (
//                                                                new PrintStatement (new VariableExpression ("v")),
//                                                                new PrintStatement (new ReadHeapExpression ("a"))
//                                                        )
//                                                )
//                                        )
//                                ),
//                                new CompoundStatement (
//                                        new PrintStatement (new VariableExpression("v")),
//                                        new PrintStatement (new ReadHeapExpression ("a"))
//                                )
//                        )
//                )
//        );
//
//        IStack<IStatement> stack = new LibStack<>();
//        try {
//            stack.push(statement);
//        } catch (ArrayOverflowException ignored) {
//        }
//        ProgramState state = new ProgramState(1, stack,
//                new LibDictionary<>(), new LibList<>(),
//                new LibHeap<>(), statement);
//
//        IRepository repository = new Repository(state);
//
//        Controller controller = new Controller(repository);
//        controller.setLogFilePath("log.txt");
//        ConsoleUI consoleUI = new ConsoleUI(controller);
//        consoleUI.run();
//        return;
    }
}
