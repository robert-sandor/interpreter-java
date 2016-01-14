package ro.sandorrobertk94.view.gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import ro.sandorrobertk94.controller.Controller;
import ro.sandorrobertk94.exceptions.controller.ControllerException;

/**
 * Created by robert on 15/01/16.
 */
public class AllStepViewController extends AnchorPane {

    private static Controller controller;

    public TextArea textArea;

    public void allStepAction(ActionEvent actionEvent) throws InterruptedException, ControllerException {
        AllStepViewController.controller.allStep();
        textArea.setText(AllStepViewController.controller.getRepository().getPrograms().toString());
    }

    public void backAction(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void setController(Controller controller) throws InterruptedException {
        AllStepViewController.controller = controller;
    }
}
