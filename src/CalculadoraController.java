public class CalculadoraController {
    private CalculadoraModel model;
    private CalculadoraView view;

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    public void initView() {
        view.getTextfield().setText(Integer.toString((int) model.getActualNumber()));
    }

    public void initController() {
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

        view.getButtonC().addActionListener(e -> resetTextField());
        view.getButtonCE().addActionListener(r -> deleteLastOperand());

        view.getButtonDot().addActionListener(e -> updateDotOnTextField());

        view.getButtonPlus().addActionListener(e -> operate("+"));
        view.getButtonMinus().addActionListener(e -> operate("-"));
        view.getButtonMult().addActionListener(e -> operate("*"));
        view.getButtonDiv().addActionListener(e -> operate("/"));
        view.getButtonPerc().addActionListener(e -> operate("%"));

        view.getButtonEqual().addActionListener(e -> evaluate());

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

    private void operateMemory(char c) {
        double result = model.evaluateWithMemory(
                Double.parseDouble(view.getTextfield().getText()),
                model.getMemoryNumber(),
                c);
        System.out.println(result);
        model.setMemoryNumber(result);
        view.setMemoryTextField(result);
    }

    private void loadFromMemory() {
        double number = model.getMemoryNumber();
        view.setResult(number);
        model.setOperandPressed(true);
    }

    private void saveOnMemory() {
        double number = Double.parseDouble(view.getTextfield().getText());
        model.setMemoryNumber(number);
        view.setMemoryTextField(number);
        model.setOperandPressed(true);
    }

    private void deleteLastOperand() {
        view.deleteOperand();
    }

    private void resetTextField() {
        view.resetTextField(0);
    }

    private void updateNumberOnTextField(int number) {
        if (model.getOperandPressed()) {
            view.resetTextField(number);
            model.setOperandPressed(false);
        } else {
            view.setTextField(number);
        }

    }

    private void updateDotOnTextField() {
        view.setDotOnTextField();
    }

    private void operate(String operation) {
        if (operation.equals("%")) {
            model.setIsPercentage(true);
        } else {
            model.saveOnMemory(view.getTextfield().getText());
            model.setOperand(operation);
        }
        model.setOperandPressed(true);
    }

    private void evaluate() {
        double result;
        result = model.evaluate(model.getActualNumber(), Double.parseDouble(view.getTextfield().getText()));
        view.setResult(result);
        model.setActualNumber(result);
        model.setOperandPressed(true); // como se acaba de presionar un operando se settea a true
    }
}
