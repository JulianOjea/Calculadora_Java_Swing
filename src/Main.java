import javax.swing.SwingUtilities;

//Se ha utilizado el patrón modelo-vista-controlador para implementar la calculadora.
//En el caso de modelar las operaciones se ha utilizado un patrón estrategia.
public class Main {
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
