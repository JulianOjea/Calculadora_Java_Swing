public class Suma  implements Operable {

    @Override
    public double operar(double n1, double n2) {
        return n1 + n2 ;
    }

    @Override
    public String toString() {
        return "+";
    }
}