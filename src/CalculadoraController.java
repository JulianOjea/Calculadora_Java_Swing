
//Controlador de la calculadora. Comunica los datos entre la vista y el modelo.
public class CalculadoraController {
    private CalculadoraModel model;
    private CalculadoraView view;

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    // Inicializa la vista con los datos del modelo, en este caso, al inicio de la
    // calculadora
    // los datos son 0.
    // La caja de texto de memoria no es necesario inicializarla, se actualizará
    // cuando se vaya a utilizar.
    public void initView() {
        view.getTextfield().setText(Integer.toString((int) model.getActualNumber()));
    }

    // Inicializa el controlador, es decir, las acciones que realizará cada botón.
    public void initController() {
        // Acciones asociadas a botones de valor numérico
        view.getButton0().addActionListener(e -> updateNumberOnTextField(0));
        view.getButton1().addActionListener(e -> updateNumberOnTextField(1));
        view.getButton2().addActionListener(e -> updateNumberOnTextField(2));
        view.getButton3().addActionListener(e -> updateNumberOnTextField(3));
        view.getButton4().addActionListener(e -> updateNumberOnTextField(4));
        view.getButton5().addActionListener(e -> updateNumberOnTextField(5));
        view.getButton6().addActionListener(e -> updateNumberOnTextField(6));
        view.getButton7().addActionListener(e -> updateNumberOnTextField(7));
        view.getButton8().addActionListener(e -> updateNumberOnTextField(8));
        view.getButton9().addActionListener(e -> updateNumberOnTextField(9));

        // Acciones de borrado de caja de texto
        view.getButtonC().addActionListener(e -> resetTextField());
        view.getButtonCE().addActionListener(r -> deleteLastNumber());

        // Botón de punto
        view.getButtonDot().addActionListener(e -> updateDotOnTextField());

        // Acciones de operación
        view.getButtonPlus().addActionListener(e -> operate("+"));
        view.getButtonMinus().addActionListener(e -> operate("-"));
        view.getButtonMult().addActionListener(e -> operate("*"));
        view.getButtonDiv().addActionListener(e -> operate("/"));
        view.getButtonPerc().addActionListener(e -> operate("%"));
        view.getButtonEqual().addActionListener(e -> evaluate());

        // Acciones de memoria
        view.getButtonMS().addActionListener(e -> saveOnMemory());
        view.getButtonMR().addActionListener(e -> loadFromMemory());
        view.getButtonMPlus().addActionListener(e -> operateMemory('+'));
        view.getButtonMMinus().addActionListener(e -> operateMemory('-'));
        view.getButtonMC().addActionListener(e -> resetMemory());
    }

    private void resetMemory() {
        model.setMemoryNumber(0);
        view.setMemoryTextField(0);
    }

    // Opera el valor de la caja de texto contra la memoria y lo guarda en memoria.
    private void operateMemory(char c) {
        double result = model.evaluateWithMemory(
                Double.parseDouble(view.getTextfield().getText()),
                model.getMemoryNumber(),
                c);
        model.setMemoryNumber(result);
        view.setMemoryTextField(result);
    }

    // Carga en la caja de texto el valor de la memoria
    private void loadFromMemory() {
        double number = model.getMemoryNumber();
        view.setResult(number);
        model.setOperatorPressed(true);
    }

    // Guarda en la memoria el número que que está en la caja de texto y lo muestra
    // en la
    // caja de texto de la memoria.
    private void saveOnMemory() {
        double number = Double.parseDouble(view.getTextfield().getText());
        model.setMemoryNumber(number);
        view.setMemoryTextField(number);
        model.setOperatorPressed(true);
    }

    private void deleteLastNumber() {
        view.deleteLastNumber();
    }

    private void resetTextField() {
        view.resetTextField(0);
    }

    // Añade un número presionado en un botón a la calculadora
    private void updateNumberOnTextField(int number) {
        if (model.getOperatorPressed()) {// Si se acaba de presionar un operador
            // se resetea el número
            view.resetTextField(number);
            model.setOperatorPressed(false);
        } else {// Si no se acaba de presionar operador..
            view.setTextField(number);
        }
    }

    private void updateDotOnTextField() {
        view.setDotOnTextField();
    }

    // Prepara el modelo para realizar una operación, en el caso de presionar dos
    // operadores seguidos persiste el último operador presionado.
    // Ejemplo:
    // presionar 2
    // presionar +
    // presionar -
    // presionar 3
    // resultado = -1
    // No se ha implementado buffer de operaciones, sólo se evalúa una operación al
    // presionar "="
    private void operate(String operation) {
        if (operation.equals("%")) {// La operación % se trata aparte
            model.setIsPercentage(true);
        } else {
            model.saveOnMemory(view.getTextfield().getText());// Se guarda en memoria el número que hay
            // en la caja de texto
            model.setOperator(operation);// Se guarda en memoria el operador presionado
        }
        model.setOperatorPressed(true);// se acaba de presionar un operador, se cambia el flag
    }

    // Evalúa una operación con los datos almacenados en el modelo y el número de la
    // caja de texto
    // Error conocido: presionar consecutivamente el operador "=" puede dar
    // resultados erráticos dependiendo
    // la operación que se ha presionado anteriormente.
    private void evaluate() {
        double result;
        result = model.evaluate(model.getActualNumber(), Double.parseDouble(view.getTextfield().getText()));
        view.setResult(result);
        model.setActualNumber(result);
        model.setOperatorPressed(true); // como se acaba de presionar un operardor se settea a true
    }
}
