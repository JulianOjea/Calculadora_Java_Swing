
public class CalculadoraController {
    private CalculadoraModel model;
    private CalculadoraView view;

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    public void initView() {
        view.getTextfield().setText(Integer.toString((int) model.getNumber()));
    }

    public void initController() {
        view.getButton0().addActionListener(e -> updateTextField(0));
        view.getButton1().addActionListener(e -> updateTextField(1));
        view.getButton2().addActionListener(e -> updateTextField(2));
        view.getButton3().addActionListener(e -> updateTextField(3));
        view.getButton4().addActionListener(e -> updateTextField(4));
        view.getButton5().addActionListener(e -> updateTextField(5));
        view.getButton6().addActionListener(e -> updateTextField(6));
        view.getButton7().addActionListener(e -> updateTextField(7));
        view.getButton8().addActionListener(e -> updateTextField(8));
        view.getButton9().addActionListener(e -> updateTextField(9));
    }

    private void updateTextField(int number) {
        view.setTextField(number);
    }
}
