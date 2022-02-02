//Modelo de la calculadora. Almacena datos de la calculadora y evalúa operaciones.
public class CalculadoraModel {
    private double actualNumber;//Primer operando, es decir, el previo a presionar un operador.
    private String operator;//Operador con el que se evalúa la operación.
    private boolean operatorPressed;//Comprueba si se acaba de presionar un operador.
    private boolean isPercentage;//Comprueba si el operando presionado es porcentaje.
    private double memoryNumber;//Número que se almacena en memoria.

    //Los valores iniciales de la calculadora son 0
    public CalculadoraModel() {
        this.actualNumber = 0;
        this.memoryNumber = 0;
        this.operatorPressed = false;
        this.isPercentage = false;
    }

    //Getters y setters
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

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean getOperatorPressed() {
        return this.operatorPressed;
    }

    public void setOperatorPressed(boolean bool) {
        this.operatorPressed = bool;
    }

    //Evalúa una operación dependiendo del operador almacenado en memoria.
    public double evaluate(double o1, double o2) {
        if (isPercentage) {
            o2 = new Porcentaje().operar(o1, o2);
            this.isPercentage = false;
        }
        switch (operator) {
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

    //Evalúa una operación contra la memoria.
    //char operation: caracter relativo a la operación que se quiere realizar
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
}
