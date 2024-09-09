public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {

        return Math.round((Math.PI * Math.pow(radio, 2) * altura)*100.0)/100.0;
    }

    @Override
    public double calcularSuperficie() {

        return Math.round((2 * Math.PI * radio * (radio + altura))*100.0)/100.0;
    }
}
