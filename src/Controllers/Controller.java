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


    private boolean start = true;
    private Calculation calculation = new Calculation(0,0,"");


    @FXML
    public void handleNumberButtons(Event event) {
        Button buttonClicked = (Button) event.getSource();
        resultLabel.setText("");
        if (start) {
            // Code for num1.
            if (calculation.getNumber1() == 0) {
                int inputNumber1 = Integer.parseInt(buttonClicked.getText());
                System.out.println("Input number 1 is now: " + inputNumber1);
                calculation.setNumber1(inputNumber1);
                outputResult(buttonClicked.getText());
            } else {
                // Here the numberedEntered is not the first digit in num1.
                int currentNumber = calculation.getNumber1();
                System.out.println("Old number 1: " + currentNumber);
                int enteredInt = Integer.parseInt(buttonClicked.getText());
                String newNumber = currentNumber + buttonClicked.getText();
                System.out.println("New Number1: " +newNumber);
                int intNewNumber = Integer.parseInt(newNumber);
                calculation.setNumber1(intNewNumber);
                outputResult(newNumber);
            }

        } else {
            // Not start, so operator != "";, and num1 is selected. Code for num2
            if (calculation.getNumber2() == 0) {
                int inputNumber2 = Integer.parseInt(buttonClicked.getText());
                System.out.println("Input number 2 is now: " + inputNumber2);
                calculation.setNumber2(inputNumber2);
                outputResult(getCurrentOutput() + buttonClicked.getText());

            } else {
                // Here the numberedEntered is not the first digit in num2.
                int currentNumber = calculation.getNumber2();
                System.out.println("Old number 2: " + currentNumber);
                String newNumber = currentNumber + buttonClicked.getText();
                System.out.println("New Number2: " + newNumber);
                int intNewNumber = Integer.parseInt(newNumber);
                calculation.setNumber2(intNewNumber);
                String newOutput = getCurrentOutput() + buttonClicked.getText();
                outputResult(newOutput);

            }
        }
    }


    @FXML
    public void operations(Event event) {
        String operator = ((Button) event.getSource()).getText();
            if (operator.equals("=")) {
                System.out.println("Equals = was clicked");
                String result = String.valueOf(calculation.calculation(calculation.getNumber1(), calculation.getNumber2(), calculation.getOperator()));
                resultTextArea.setText(result);
                start = true;
                calculation.setOperator("");
//                try{
//                    calculation.setNumber1(Integer.parseInt(resultTextArea.getText()));
//                    calculation.setNumber2(0);
//                    System.out.println("New num1: "+calculation.getNumber1() + " and new num 2: " + calculation.getNumber2());
//                } catch (NumberFormatException e) {
//                    System.out.println("Error: " + e.getMessage());
//                }
            } else {
                if (calculation.getOperator().equals("")) {
                    resultTextArea.appendText(" " + operator + " ");
                    System.out.println("Operator set to: " + operator);
                    calculation.setOperator(operator);
                    start = false;
                } else if(calculation.getNumber2() == 0 ) {
                    String currentOutput = resultTextArea.getText();
                    if(currentOutput != null && currentOutput.length() > 0 ) {
                        System.out.println("New operator chosen.");
                        resultLabel.setText("New operator chosen.");
                        String newOutput = currentOutput.substring(0, currentOutput.length()-2);
                        resultTextArea.setText(newOutput +  ((Button) event.getSource()).getText() + " ");
                    } else {
                        resultLabel.setText("Cannot set new operator");
                    }

                } else {
                    System.out.println("Operator already chosen.");
                    resultLabel.setText("Operator already chosen");
                }
            }
    }
//            }
//        } else if (operator.equals("=")) {
//            System.out.println("Equals = was clicked");
//            String result = String.valueOf(calculation.calculation(calculation.getNumber1(), calculation.getNumber2(), calculation.getOperator()));
//            resultTextArea.setText(result);
//            resultLabel.setText("Result: ");
//            start = true;
//            calculation.setOperator("");
//
//        } else {
//            System.out.println("Operator already chosen.");
//            resultLabel.setText("Operator already chosen");
//        }


    @FXML
    public void clearWindow() {
        resultTextArea.setText("");
        resultLabel.setText("");
        calculation.setNumber1(0);
        calculation.setNumber2(0);
        calculation.setOperator("");
        System.out.println("Clear!");
        start = true;
    }

    @FXML
    public void outputResult(String string) {
        if (resultTextArea.getText().equals("0")) {
            resultTextArea.setText(string);
        }
        resultTextArea.setText("");
        resultTextArea.setText(resultTextArea.getText() + string);
    }

    @FXML
    public String getCurrentOutput() {
        if (resultTextArea.getText().equals("0")) {
            return "";
        }
        return resultTextArea.getText();
    }

}





