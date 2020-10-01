package Controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    public TextArea resultTextArea;

    @FXML
    private Label resultLabel;

    @FXML
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9
            ,buttonPlus, buttonMinus, buttonEquals, buttonSqRt, buttonSquared, buttonPlusMinus, buttonMultiplied, buttonDivided
            ,buttonDot, buttonClear, buttonPercent;

    private String currentText;

    //Eventhandler number buttons
    // Switch statement?

    @FXML
    public void handleNumberButtons(Event event) {
        currentText = resultTextArea.getText();
        if(resultTextArea.getText().equals("0")) {
            resultTextArea.setText("");
            currentText = resultTextArea.getText();
        }
        Button buttonClicked = (Button) event.getSource();

        System.out.println(buttonClicked.getText());
        int numberClicked = Integer.parseInt(buttonClicked.getText());
        if(numberClicked > (-1) && numberClicked < 10) {
            resultTextArea.appendText(buttonClicked.getText());
            System.out.println(buttonClicked.getText() + " was clicked!");
        } else {
            System.out.println("Not a number clicked");
        }

    }

    @FXML
    public void operations(Event event) {
        if(resultTextArea.equals("") || resultTextArea == null) {
            resultLabel.setText("Please enter a number first.");
        } else {

        }
    }

}
