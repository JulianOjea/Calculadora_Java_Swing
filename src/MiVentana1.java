import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiVentana1 extends JFrame {
	//Declaramos los componentes de la ventana
	JLabel etiqueta;
	JTextField cajadeTexto;
	JButton boton;

	//Programamos constructor
	public MiVentana1() {
		
		//Para settear lugar y tamaño de la ventana:
		/*--------------------------------------*/
		Toolkit tl = Toolkit.getDefaultToolkit();
		Dimension tam = tl.getScreenSize();
		int alturaPantalla = tam.height;
		int anchoPantalla = tam.width;
		setSize(anchoPantalla/3 , alturaPantalla/3);
		setLocation(anchoPantalla/4,alturaPantalla/4);
		/*--------------------------------------*/

		/*------------ICONO ventana------------------*/
		Image imagen = tl.getImage("src/moon.png");
		setIconImage(imagen);
		/*------------ICONO ventana------------------*/
		
		//Poner un título
		this.setTitle("Conversor dólares/euros");
		
		//Terminar el programa al darle al botón de cierre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Crear los componentes
		initialiceComponents();
		//Establecer layoutmanager
		this.setLayout(new FlowLayout());
		//Agregarlos al panel de contenido
		add(etiqueta);
		add(cajadeTexto);
		getContentPane().add(boton);
		
		/*------------Colocando componentes con setBounds------------------*/
		this.setLayout(null);
		etiqueta.setBounds(100, 50, 250, 50);
		cajadeTexto.setBounds(100 , 100 , 200 , 25);
		boton.setBounds(100, 140, 150, 30);
		/*------------Colocando componentes con setBounds------------------*/
		setVisible(true);
	}
	
	private void initialiceComponents() {
		etiqueta = new JLabel("Introduce cantidad en euros");
		cajadeTexto = new JTextField(40);
		boton = new JButton("Convertir a dólares");

	}
}
