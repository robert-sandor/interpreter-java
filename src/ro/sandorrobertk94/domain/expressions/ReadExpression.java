package ro.sandorrobertk94.domain.expressions;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import ro.sandorrobertk94.domain.adts.IDictionary;
import ro.sandorrobertk94.domain.adts.IHeap;
import ro.sandorrobertk94.exceptions.domain.DomainException;
import ro.sandorrobertk94.exceptions.domain.InputException;
import ro.sandorrobertk94.view.gui.AllStepViewController;
import ro.sandorrobertk94.view.gui.InputProgramViewController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Optional;

/**
 * Created by robert on 12/6/15.
 */
public class ReadExpression implements IExpression {
    public ReadExpression() {
    }

    @Override
    public Integer evaluate(IDictionary<String, Integer> symbolTable, IHeap<Integer> heap) throws DomainException {
        // READ FROM CONSOLE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString;
        try {
            inputString = br.readLine();
        } catch (IOException e) {
            throw new InputException();
        }

        // READ FROM GUI
//        TextInputDialog textInputDialog = new TextInputDialog();
//        textInputDialog.setContentText("Input an integer : ");
//        Optional<String> result = textInputDialog.showAndWait();
//
//        String inputString;
//        if (result.isPresent()) {
//            inputString = result.get();
//        } else {
//            throw new InputException();
//        }

        return Integer.parseInt(inputString);
    }

    @Override
    public String toString() {
        return " read() ";
    }
}
