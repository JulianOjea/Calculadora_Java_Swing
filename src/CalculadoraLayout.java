import javax.swing.*;
import java.awt.GridLayout;

public class CalculadoraLayout extends JFrame{
    
    //Caja para mostrar el texto
    JTextField textField;

    //Botones numéricos
    JButton button0, button1, button2, button3, button4;
    JButton button5, button6, button7, button8, button9;

    public CalculadoraLayout(){

        setSize(600,600);
        this.setTitle("calculando...");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Crear los componentes
        initComponents();
        this.setLayout(new GridLayout(3,3));

        addComponents();
        setVisible(true);
    }


    private void initComponents() {
        textField = new JTextField(40);
        button0 = new JButton("0");
        button0.setSize(10, 10);
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
    }

    private void addComponents(){
        add(textField);
        add(button0);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
    }
}
