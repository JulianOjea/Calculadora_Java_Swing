import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

//Vista de la calculadora. Utilizada para generar y gestionar el layout de la calculadora.
public class CalculadoraView extends JFrame {

    //Se utliza Group Layout como contenedor para estructurar los botones
    GroupLayout layout;
    // Caja para mostrar el texto
    JTextField textField;
    // Caja para mostrar el texto de memoria
    JTextField memoryTextField;
    // Botones numéricos
    JButton button0, button1, button2, button3, button4;
    JButton button5, button6, button7, button8, button9;
    // Boton punto
    JButton buttonDot;
    // Botones de operadores
    JButton buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonPerc, buttonEqual;
    // Botones de reseteo
    JButton buttonC, buttonCE;
    // Lista de todos los botones (para posible utilidad en el código)
    List<JButton> buttonList = new ArrayList<JButton>();
    // botones de memoria
    JButton buttonMS, buttonMR, buttonMPlus, buttonMMinus, buttonMC;

    public CalculadoraView() {
        this.setTitle("Calculadora");
        Toolkit tl = Toolkit.getDefaultToolkit();
        Image imagen = tl.getImage("src/calculadora_icon.png");
        setIconImage(imagen);

        // Crear los componentes
        initComponents();
        // Inicializar lista de botones
        initButtonList();

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // Creando el layout
        createGroupLayout();

        setLocationRelativeTo(null); // centra la ventana en el medio de la panyalla
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // no se permite que la ventana cambie de tamaño
        setVisible(true); // se habilita la visibilidad de la ventana
    }

    //Función auxiliar que inicializa una lista con todos los botones de la calculadora.
    //A excepción de los botones que no tienen el mismo tamaño que el CE.
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

        buttonList.add(buttonMMinus);
        buttonList.add(buttonMPlus);
    }

    //Inicializa todos los componentes de la calculadora
    private void initComponents() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(0, 30)); // Cambiando tamaño de la altura de la caja de texto
        textField.setEditable(false); // la caja de texto no es editable
        textField.setHorizontalAlignment(JTextField.RIGHT);// Los números se alinean a la derecha

        memoryTextField = new JTextField();
        //Mismos ajustes
        memoryTextField.setPreferredSize(new Dimension(0, 30));
        memoryTextField.setEditable(false);
        memoryTextField.setHorizontalAlignment(JTextField.RIGHT);

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

        buttonMPlus = new JButton("M+");
        buttonMMinus = new JButton("M-");
        buttonMR = new JButton("MR");
        buttonMS = new JButton("MS");
        buttonMC = new JButton("MC");
    }

    //Utilizada para crear el Layout
    private void createGroupLayout() {
        //Grupo horizontal
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                                        .addComponent(buttonCE))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(memoryTextField)
                        .addComponent(buttonMS)
                        .addComponent(buttonMR)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonMPlus)
                                .addComponent(buttonMMinus))
                        .addComponent(buttonMC)));
        //Grupo vertical
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addGroup(layout.createSequentialGroup()
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
                                .addComponent(buttonCE)))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(memoryTextField)
                        .addComponent(buttonMS)
                        .addComponent(buttonMR)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonMPlus)
                                .addComponent(buttonMMinus))
                        .addComponent(buttonMC)));
        
        //Ajustes finales del layout
        //Setteo de distancia entre bottones
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Todos los botones tienen el mismo tamaño que el mayor boton, en este caso el
        // boton CE
        for (JButton jButton : buttonList) {
            layout.linkSize(jButton, buttonCE);
        }

        pack(); // agrupa los botones para el display

        // cambia el tamaño de los botones 0, MR, MS y MC
        button0.setMinimumSize(new Dimension(buttonCE.getWidth() * 2 + 7, buttonCE.getHeight()));
        buttonMR.setMinimumSize(new Dimension(buttonCE.getWidth() * 2 + 7, buttonCE.getHeight()));
        buttonMS.setMinimumSize(new Dimension(buttonCE.getWidth() * 2 + 7, buttonCE.getHeight()));
        buttonMC.setMinimumSize(new Dimension(buttonCE.getWidth() * 2 + 7, buttonCE.getHeight()));
    }

    //Getters
    public JTextField getTextfield() {
        return textField;
    }

    public JTextField getMemoryTextField() {
        return memoryTextField;
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

    public JButton getButtonMC() {
        return buttonMC;
    }

    public JButton getButtonMMinus() {
        return buttonMMinus;
    }

    public JButton getButtonMPlus() {
        return buttonMPlus;
    }

    public JButton getButtonMR() {
        return buttonMR;
    }

    public JButton getButtonMS() {
        return buttonMS;
    }

    //Set de la caja de texto con los números introducidos en la calculadora.
    //Esta función no se utiliza para hacer set del un resultado de operación.
    //Los números se concatenan al final del contenido,
    //en el caso de que el número de la caja sea 0, se substituye.
    public void setTextField(int number) {
        if (textField.getText().equals("0")) {
            textField.setText(Integer.toString(number));
        } else
            textField.setText(textField.getText() + Integer.toString(number));
    }

    //Set de la caja de texto, en este caso, esta función se utiliza para settear un resultado.
    public void setResult(double number) {
        if (number % 1 == 0) // Si el resultado no tiene decimales se muestra un número entero
            textField.setText(Integer.toString((int) number));
        else
            textField.setText(Double.toString(number));
    }

    //Set de la caja de texto de memoria.
    public void setMemoryTextField(double number) {
        if (number % 1 == 0) // Si el resultado no tiene decimales se muestra un número entero
            memoryTextField.setText(Integer.toString((int) number));
        else
            memoryTextField.setText(Double.toString(number));
    }

    //Resetea el número de la caja de texto a number.
    //Esta función es necesaria para resetear el número de la caja de texto tras presionar un operador.
    public void resetTextField(int number) {
        textField.setText(Integer.toString(number));
    }

    //Añade un punto tras el número de la caja de texto
    public void setDotOnTextField() {
        if (!textField.getText().contains(".")) {//Si ya hay un punto no se puede poner otro
            textField.setText(textField.getText() + ".");
        }
    }

    //Elimina un número de la caja de texto
    public void deleteLastNumber() {
        if (!textField.getText().equals("0")) {//Si hay solamente un 0 en la caja no se puede borrar más
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            if (textField.getText().length() == 0)//Cuando se eliminan todos los números se añade un 0 a la caja
                textField.setText("0");
        }
    }
}
