import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class CalculadoraView extends JFrame {

    // Caja para mostrar el texto
    JTextField textField;

    // Botones numéricos
    JButton button0, button1, button2, button3, button4;
    JButton button5, button6, button7, button8, button9;
    // Boton punto
    JButton buttonDot;
    // Botones de operandos
    JButton buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonPerc, buttonEqual;
    // Botones de reseteo
    JButton buttonC, buttonCE;
    // Lista de todos los botones (para posible utilidad en el código)
    List<JButton> buttonList = new ArrayList<JButton>();

    GroupLayout layout;

    public CalculadoraView() {

        this.setTitle("calculando...");
        // Crear los componentes
        initComponents();
        // Inicializar lista de botones
        initButtonList();

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // Creando el layout
        createGroupLayout();

        pack(); // agrupa los botones para el display
        button0.setMinimumSize(new Dimension(buttonCE.getWidth()*2+7, buttonCE.getHeight()));//cambia el tamaño del botton 0
        setLocationRelativeTo(null); // centra la ventana en el medio de la panyalla
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // no se permite que la ventana cambie de tamaño
        setVisible(true); // se habilita la visibilidad de la ventana
    }

    private void initButtonList() {
        //buttonList.add(button0);
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);

        buttonList.add(buttonDot);

        buttonList.add(buttonPlus);
        buttonList.add(buttonMinus);
        buttonList.add(buttonMult);
        buttonList.add(buttonDiv);
        buttonList.add(buttonPerc);
        buttonList.add(buttonEqual);

        buttonList.add(buttonC);
        buttonList.add(buttonCE);
    }

    private void initComponents() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(0, 30)); // Cambiando tamaño de la altura de la caja de texto
        textField.setEditable(false); // la caja de texto no es editable
        textField.setHorizontalAlignment(JTextField.RIGHT);// Los números se alinean a la derecha

        button0 = new JButton("0");

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonDot = new JButton(".");

        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMult = new JButton("*");
        buttonDiv = new JButton("/");
        buttonPerc = new JButton("%");
        buttonEqual = new JButton("=");

        buttonC = new JButton("C");
        buttonCE = new JButton("CE");

        button0.setMinimumSize(
                new Dimension((int) buttonCE.getSize().getWidth() * 2, (int) buttonCE.getSize().getHeight()));
        // System.out.println("este es el"buttonCE.getSize().getWidth()*2);
        
        
        // (int)buttonCE.getSize().getHeight());
    }

    private void createGroupLayout() {
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(textField)
                .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(button1)
                                                        .addComponent(button4)
                                                        .addComponent(button7))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(button2)
                                                        .addComponent(button5)
                                                        .addComponent(button8)))
                                        .addComponent(button0))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button3)
                                        .addComponent(button6)
                                        .addComponent(button9)
                                        .addComponent(buttonDot))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonPlus)
                                        .addComponent(buttonMult)
                                        .addComponent(buttonPerc)
                                        .addComponent(buttonC))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonMinus)
                                        .addComponent(buttonDiv)
                                        .addComponent(buttonEqual)
                                        .addComponent(buttonCE))));

        // Todos los botones tienen el mismo tamaño que el mayor boton, en este caso el
        // boton CE
        for (JButton jButton : buttonList) {
            layout.linkSize(jButton, buttonCE);
        }

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(textField)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3)
                        .addComponent(buttonPlus)
                        .addComponent(buttonMinus))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button4)
                        .addComponent(button5)
                        .addComponent(button6)
                        .addComponent(buttonMult)
                        .addComponent(buttonDiv))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button7)
                        .addComponent(button8)
                        .addComponent(button9)
                        .addComponent(buttonPerc)
                        .addComponent(buttonEqual))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button0)
                        .addComponent(buttonDot)
                        .addComponent(buttonC)
                        .addComponent(buttonCE)));
    }

    public JTextField getTextfield() {
        return textField;
    }

    public JButton getButton0() {
        return button0;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton5() {
        return button5;
    }

    public JButton getButton6() {
        return button6;
    }

    public JButton getButton7() {
        return button7;
    }

    public JButton getButton8() {
        return button8;
    }

    public JButton getButton9() {
        return button9;
    }

    public JButton getButtonC() {
        return buttonC;
    }

    public JButton getButtonCE() {
        return buttonCE;
    }

    public JButton getButtonDot() {
        return buttonDot;
    }

    public JButton getButtonPlus() {
        return buttonPlus;
    }

    public JButton getButtonEqual() {
        return buttonEqual;
    }

    public JButton getButtonDiv() {
        return buttonDiv;
    }

    public JButton getButtonMinus() {
        return buttonMinus;
    }

    public JButton getButtonMult() {
        return buttonMult;
    }

    public JButton getButtonPerc() {
        return buttonPerc;
    }

    public void setTextField(int number) {
        if (textField.getText().equals("0")) {
            textField.setText(Integer.toString(number));
        } else
            textField.setText(textField.getText() + Integer.toString(number));
    }

    public void setResult(double number) {
        if (number % 1 == 0) // Si el resultado no tiene decimales se muestra un número entero
            textField.setText(Integer.toString((int) number));
        else
            textField.setText(Double.toString(number));
    }

    public void resetTextField(int number) {
        textField.setText(Integer.toString(number));
    }

    public void setDotOnTextField() {
        if (!textField.getText().contains(".")) {
            textField.setText(textField.getText() + ".");
        }
    }

    public void deleteOperand() {
        if (!textField.getText().equals("0")) {
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            if (textField.getText().length() == 0)
                textField.setText("0");
        }
    }
}
