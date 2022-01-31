public class Division implements Operable {

    //la división entre 0 mostrará por pantalla "infinity"
    @Override
    public double operar(double n1, double n2) {
        return (double) n1 / n2;
    }

}
