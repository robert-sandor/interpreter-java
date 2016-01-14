package ro.sandorrobertk94.view.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ro.sandorrobertk94.controller.Controller;
import ro.sandorrobertk94.exceptions.repository.SerializationException;

import java.io.IOException;
import java.net.URL;

/**
 * Created by robert on 14/01/16.
 */
public class MainMenuController extends AnchorPane {

    private Controller controller;

    @FXML
    public CheckBox checkLog;

    public void insertProgramAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        URL location = InputProgramViewController.class.getResource("InputProgramView.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load(location.openStream());

        InputProgramViewController inputProgramViewController = new InputProgramViewController();
        inputProgramViewController.setController(controller);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void oneStepAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        Stage primaryStage = new Stage();
        URL location = InputProgramViewController.class.getResource("OneStepView.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load(location.openStream());

        OneStepViewController inputProgramViewController = new OneStepViewController();
        inputProgramViewController.setController(controller);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void allStepAction(ActionEvent actionEvent) throws InterruptedException, IOException {
        Stage primaryStage = new Stage();
        URL location = InputProgramViewController.class.getResource("AllStepView.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load(location.openStream());

        AllStepViewController inputProgramViewController = new AllStepViewController();
        inputProgramViewController.setController(controller);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void serializeAction(ActionEvent actionEvent) throws SerializationException {
        controller.serializePrograms();
    }

    public void deserializeAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        Stage primaryStage = new Stage();
        URL location = InputProgramViewController.class.getResource("DeserializeView.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load(location.openStream());

        DeserializeViewController inputProgramViewController = new DeserializeViewController();
        inputProgramViewController.setController(controller);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void checkLogAction(ActionEvent actionEvent) {
        controller.setWriteToFile(checkLog.isSelected());
    }

    public void setController(Controller controller) {
        this.controller = controller;
        checkLog.setSelected(controller.isWriteToFile());
    }
}
