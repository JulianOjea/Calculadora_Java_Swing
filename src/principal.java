import javax.swing.SwingUtilities;

public class principal {
	public static void main(String[] args) {
		System.out.println("hi");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CalculadoraLayout();
			}
		});
	}
}
