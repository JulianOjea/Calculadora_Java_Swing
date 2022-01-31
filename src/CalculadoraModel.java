public class CalculadoraModel {
    private double actualNumber;
    private String operand;
    private boolean operandPressed;
    private boolean isPercentage;
    private double memoryNumber;

    public CalculadoraModel() {
        this.actualNumber = 0;
        this.memoryNumber = 0;
        this.operandPressed = false;
        this.isPercentage = false;
    }

    public double getMemoryNumber() {
        return memoryNumber;
    }

    public void setMemoryNumber(double memoryNumber) {
        this.memoryNumber = memoryNumber;
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public void setIsPercentage(boolean bool) {
        this.isPercentage = bool;
    }

    public void setActualNumber(double number) {
        this.actualNumber = number;

    }

    public double getActualNumber() {
        return actualNumber;
    }

    public void saveOnMemory(String textField) {
        this.actualNumber = Double.parseDouble(textField);
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public double evaluate(double o1, double o2) {
        if (isPercentage) {
            o2 = new Porcentaje().operar(o1, o2);
            this.isPercentage = false;
        }
        switch (operand) {
            case "+":
                return new Suma().operar(o1, o2); 
            case "-":
                return new Resta().operar(o1, o2);
            case "*":
                return new Multiplicacion().operar(o1, o2);
            case "/":
                return new Division().operar(o1, o2);
            default:
                break;
        }
        return 0;
    }

    public double evaluateWithMemory(double o1, double o2, char operation) {
        switch (operation) {
            case '+':
                return new Suma().operar(o1, o2);
            case '-':
                return new Resta().operar(o2, o1);
            default:
                break;
        }
        return 0;
    }

    public boolean getOperandPressed() {
        return this.operandPressed;
    }

    public void setOperandPressed(boolean bool) {
        this.operandPressed = bool;
    }
}
