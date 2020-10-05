package Controllers;

import Main.Calculation;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


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

    private boolean start = true;
    private Calculation calculation = new Calculation(0,0,"");


    @FXML
    public void handleNumberButtons(Event event) {
        Button buttonClicked = (Button) event.getSource();
        double numberClicked = Double.parseDouble(buttonClicked.getText());
        if(start) {
            calculation.setNumber1(numberClicked);
            System.out.println("Number 1: " + numberClicked + " was selected!");
            resultTextArea.setText(String.valueOf(numberClicked));
            start = false;
        } else {
            calculation.setNumber2(numberClicked);
            System.out.println("Number 2: " + numberClicked + " was selected!");
            resultTextArea.appendText(String.valueOf(numberClicked));
        }
    }


    @FXML
    public void operations(Event event) {
        String operator = ((Button) event.getSource()).getText();
        resultTextArea.appendText(" " + operator + " ");
        if (operator.equals("=")) {
            System.out.println("Equals = was clicked");
//            String result = String.valueOf(calculation.calculation(calculation));
            String result = String.valueOf(calculation.calculation(calculation.getNumber1(), calculation.getNumber2(), calculation.getOperator()));
            resultTextArea.setText(result);
            start = true;
        } else {
            System.out.println("Operator set to: " +operator);
            calculation.setOperator(operator);
            start = false;
        }
    }

    @FXML
    public void clearWindow(Event event) {
        resultTextArea.setText("");
    }

}




