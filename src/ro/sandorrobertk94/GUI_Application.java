package ro.sandorrobertk94;/**
 * Created by robert on 14/01/16.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.sandorrobertk94.controller.Controller;
import ro.sandorrobertk94.repository.IRepository;
import ro.sandorrobertk94.repository.Repository;
import ro.sandorrobertk94.view.gui.MainMenuController;

import java.io.IOException;
import java.net.URL;

public class GUI_Application extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        IRepository repo = new Repository();
        Controller controller = new Controller(repo);
        controller.setLogFilePath("log.txt");

        primaryStage.setTitle("Toy Language 1.0");

        URL location = MainMenuController.class.getResource("MainMenu.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load(location.openStream());

        MainMenuController mainMenuController = fxmlLoader.getController();
        mainMenuController.setController(controller);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
