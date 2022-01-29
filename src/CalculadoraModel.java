public class CalculadoraModel {
    private double memoryNumber;
    private Operable operand;
    private boolean operandPressed;

    public CalculadoraModel() {
        this.memoryNumber = 0;
        this.operandPressed = false;
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
        switch (operand) {
            case "+":
                this.operand = new Suma();
                break;
        }
        System.out.println("HOLAAAAA444");
        System.out.println("esta es la clase" + this.operand.getClass());
        System.out.println("HOLAAAAA33333");
    }

    public double evaluate(double o1, double o2){
        System.out.println("HOLAAAAA1111");
        Suma s = (Suma)this.operand;
        //System.out.println("esta es la clase" + s.getClass();
        System.out.println("HOLAAAAA2222");
        return this.operand.Operar(o1, o2);
    }

    public boolean getOperandPressed() {
        return this.operandPressed;
    }

    public void setOperandPressed(boolean bool) {
        this.operandPressed = bool;
    }
}
