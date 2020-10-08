package Main;

public class Calculation {

    private int number1;
    private int number2;
    private String operator;

    public Calculation(int number1, int number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }


    public double calculation(int num1, int num2, String operator) {
        System.out.println("Calculating with num1 = " + num1 + " and num2 = " + num2 + " and operator: " +operator);
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "X":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "√":
                return Math.sqrt(num1);
            case "%":
                return num1 % num2;
            case "+/-":
                return num1 * (-1);
            case "x²":
                return num1 * num1;
            default:
                System.out.println("Error");
                return 0;
        }

    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
