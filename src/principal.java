import javax.swing.SwingUtilities;

public class principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraModel m = new CalculadoraModel();
                CalculadoraView v = new CalculadoraView();
                CalculadoraController c = new CalculadoraController(m, v);
                c.initController();
            }
        });
    }
}
