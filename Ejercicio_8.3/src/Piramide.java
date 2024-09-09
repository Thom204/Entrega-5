
public class Piramide extends FiguraGeometrica {
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }

    @Override
    public double calcularVolumen() {
        return Math.round(((1.0 / 3.0) * base * base * altura)*100.0)/100.0;
    }

    @Override
    public double calcularSuperficie() {
        return Math.round((base * base + 2 * base * apotema)*100.0)/100.0;
    }
}
