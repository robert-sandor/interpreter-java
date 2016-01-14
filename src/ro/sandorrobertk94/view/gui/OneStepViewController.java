package ro.sandorrobertk94.view.gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import ro.sandorrobertk94.controller.Controller;

/**
 * Created by robert on 15/01/16.
 */
public class OneStepViewController extends AnchorPane {

    private static Controller controller;

    public TextArea textArea;

    public void oneStepAction(ActionEvent actionEvent) throws InterruptedException {
        OneStepViewController.controller.oneStepForAllPrograms(OneStepViewController.controller.getRepository().getPrograms());
        textArea.setText(OneStepViewController.controller.getRepository().getPrograms().toString());
    }

    public void backAction(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void setController(Controller controller) throws InterruptedException {
        OneStepViewController.controller = controller;
    }
}
