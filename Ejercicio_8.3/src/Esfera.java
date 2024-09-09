
public class Esfera extends FiguraGeometrica {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularVolumen() {

        return Math.round(((4.0 / 3.0) * Math.PI * Math.pow(radio, 3))*1000.0)/1000.0;
    }

    @Override
    public double calcularSuperficie() {

        return Math.round((4 * Math.PI * Math.pow(radio, 2))*100.0)/100.0;
    }
}
