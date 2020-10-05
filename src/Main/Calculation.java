package Main;

public class Calculation {

    private double number1;
    private double number2;
    private String operator;

    public Calculation(double number1, double number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }


    public double calculation(double num1, double num2, String operator) {
        Double selectedNumber1 = num1;
        Double selectedNumber2 = num2;
        System.out.println("Calculating with num1 = " + num1 + " and num2 = " + num2 + " and operator: " +operator);
        if (operator.equals("+")) {
            return selectedNumber1 + selectedNumber2;
        } else if(operator.equals("-")) {
            return selectedNumber1 - selectedNumber2;
        } else if(operator.equals("X")) {
            return selectedNumber1 * selectedNumber2;
        } else if(operator.equals("/")) {
            return selectedNumber1 / selectedNumber2;
        } else if(operator.equals("√")) {
            return Math.sqrt(selectedNumber1);
        } else if(operator.equals("%")) {
            return selectedNumber1 % selectedNumber2;
        } else if(operator.equals("+/-")) {
            return selectedNumber1 * (-1);
        } else if(operator.equals("x²")) {
            return selectedNumber1*selectedNumber1;
        } else {
            System.out.println("Error");
            return 0;
        }

    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
