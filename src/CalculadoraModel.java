public class CalculadoraModel {
    private double memoryNumber;
    private String operand;
    private boolean operandPressed;
    private boolean isPercentage;

    public CalculadoraModel() {
        this.memoryNumber = 0;
        this.operandPressed = false;
        this.isPercentage = false;
    }

    public boolean isPercentage(){
        return isPercentage;
    }

    public void setIsPercentage(boolean bool){
        this.isPercentage = bool;
    }

    public void setMemoryNumber(double number) {
        this.memoryNumber = number;
        
    }

    public double getMemoryNumber() {
        return memoryNumber;
    }

    public void saveOnMemory(String textField) {
        this.memoryNumber = Double.parseDouble(textField);
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public double evaluate(double o1, double o2){
        if (isPercentage){
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

    public boolean getOperandPressed() {
        return this.operandPressed;
    }

    public void setOperandPressed(boolean bool) {
        this.operandPressed = bool;
    }
}
