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


//    @FXML
//    public void handleNumberButtons(Event event) {
//        Button buttonClicked = (Button) event.getSource();
////        double numberClicked = Double.parseDouble(buttonClicked.getText());
//        int numberClicked = Integer.parseInt(buttonClicked.getText());
//        if(start) {
//            String inputNumbers = "";
//            if(calculation.getOperator().equals("")) {
//                if(calculation.getNumber1() == 0) {
//                    inputNumbers = inputNumbers + buttonClicked.getText();
//                                        System.out.println("Num1 is currently: " + "nada" + " and new number: " + inputNumbers);
//                    calculation.setNumber1((double)Double.parseDouble(inputNumbers));
//                    resultTextArea.setText(String.valueOf(inputNumbers));
//                } else {
//                    double currentNumbers = calculation.getNumber1();
//                    inputNumbers = inputNumbers + buttonClicked.getText();
//                    String newNumbers = currentNumbers + inputNumbers;
//                    System.out.println("Num1 is currently: " + currentNumbers + " and new number: " + inputNumbers + " and together: " + newNumbers);
//                    calculation.setNumber1((double) Double.parseDouble(newNumbers));
//                    resultTextArea.setText(String.valueOf(newNumbers));
//                }
//            }
////            System.out.println("Number 1: " + numberClicked + " was selected!");
////            start = false;
//        } else {
//            calculation.setNumber2(numberClicked);
//            System.out.println("Number 2: " + numberClicked + " was selected!");
//            resultTextArea.appendText(String.valueOf(numberClicked));
//        }
//    }

    @FXML
    public void handleNumberButtons(Event event) {
        Button buttonClicked = (Button) event.getSource();
        int numberClicked = Integer.parseInt(buttonClicked.getText());
        String inputNumber1 = "";
        String inputNumber2 = "";
        if (start) {
            if (calculation.getNumber1() == 0) {
                inputNumber1 = buttonClicked.getText();
                System.out.println("Input number 1 is now: " + inputNumber1);
                // test: Sout "Number1 is now:" + num1
                calculation.setNumber1(Double.parseDouble(inputNumber1));
                outputResult(inputNumber1);
                // or setOutput(String.valueOf(inputNumber1));
                // code for num1
                // num2 is not relevant here
            } else {
                // here the numberedEntered is not the first digit.
                int currentNumber = (int) calculation.getNumber1();
                System.out.println("Current number1: " + currentNumber);
                Double enteredDouble = Double.parseDouble(buttonClicked.getText());
                //int newNumber = currentNumber + Integer.parseInt(buttonClicked.getText());
                String newNumber = currentNumber + buttonClicked.getText();
                System.out.println("New Number1: " +newNumber);
                calculation.setNumber1(currentNumber + enteredDouble);
                outputResult(newNumber);
            }

        } else {
            // not start, so operator != "";, and num1 is selected
            if (calculation.getNumber2() == 0) {
                inputNumber2 = buttonClicked.getText();
                System.out.println("Input number 2 is now: " + inputNumber2);
                // test: Sout "Number2 is now:" + num2
                calculation.setNumber2(Double.parseDouble(inputNumber2));
                outputResult(inputNumber2);
                // or setOutput(String.valueOf(inputNumber2));

            } else {
                // here the numberedEntered is not the first digit.
                int currentNumber2 = (int) calculation.getNumber2();
                int newNumber2 = currentNumber2 + Integer.parseInt(buttonClicked.getText());
                Double enteredDouble2 = Double.parseDouble(buttonClicked.getText());
                calculation.setNumber2(currentNumber2 + enteredDouble2);
                outputResult(Integer.toString(newNumber2));
                                //code for num2
            }
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
            calculation.setOperator("");
        } else {
            System.out.println("Operator set to: " +operator);
            calculation.setOperator(operator);
            start = false;
        }
    }

    @FXML
    public void clearWindow(Event event) {
        resultTextArea.setText("");
        calculation.setNumber1(0);
        calculation.setNumber2(0);
        calculation.setOperator(null);
        start = true;
    }

    @FXML
    public void outputResult(String string) {
        if (resultTextArea.getText().equals("0")) {
            resultTextArea.setText(string);
        }
        resultTextArea.setText(resultTextArea.getText() + string);
    }

}





