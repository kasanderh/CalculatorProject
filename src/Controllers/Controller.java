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
//        String inputNumber1 = "";
//        String inputNumber2 = "";
        if (start) {
            if (calculation.getNumber1() == 0) {
                int inputNumber1 = Integer.parseInt(buttonClicked.getText());
                System.out.println("Input number 1 is now: " + inputNumber1);
                calculation.setNumber1(inputNumber1);
                outputResult(buttonClicked.getText());
                // or setOutput(String.valueOf(inputNumber1));
                // code for num1
                // num2 is not relevant here
            } else {
                // here the numberedEntered is not the first digit.
                int currentNumber = calculation.getNumber1();
                System.out.println("Old number 1: " + currentNumber);
                int enteredInt = Integer.parseInt(buttonClicked.getText());
                //int newNumber = currentNumber + Integer.parseInt(buttonClicked.getText());
                String newNumber = currentNumber + buttonClicked.getText();
                System.out.println("New Number1: " +newNumber);
                int intNewNumber = Integer.parseInt(newNumber);
                calculation.setNumber1(intNewNumber);
                outputResult(newNumber);
            }

        } else {
            // not start, so operator != "";, and num1 is selected
            if (calculation.getNumber2() == 0) {
                int inputNumber2 = Integer.parseInt(buttonClicked.getText());
                System.out.println("Input number 2 is now: " + inputNumber2);
                calculation.setNumber2(inputNumber2);
                outputResult(getCurrentOutput() + buttonClicked.getText());
//                String inputNumber2 = buttonClicked.getText();
//                System.out.println("Input number 2 is now: " + inputNumber2);
//                // test: Sout "Number2 is now:" + num2
//                calculation.setNumber2(Integer.parseInt(inputNumber2));
//                outputResult(inputNumber2);
                // or setOutput(String.valueOf(inputNumber2));

            } else {
                // here the numberedEntered is not the first digit.
                int currentNumber = calculation.getNumber2();
                System.out.println("Old number 2: " + currentNumber);
                String newNumber = currentNumber + buttonClicked.getText();
                System.out.println("New Number2: " + newNumber);
                int intNewNumber = Integer.parseInt(newNumber);
                calculation.setNumber2(intNewNumber);
                String newOutput = getCurrentOutput() + buttonClicked.getText();
                outputResult(newOutput);
//                int currentNumber2 = (int) calculation.getNumber2();
//                int newNumber2 = currentNumber2 + Integer.parseInt(buttonClicked.getText());
//                int enteredDouble2 = Integer.parseInt(buttonClicked.getText());
//                calculation.setNumber2(currentNumber2 + enteredDouble2);
//                outputResult(Integer.toString(newNumber2));
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





