public class Predicciones {
    private RegresionLinealSimple regresionLinealSimple;

    public Predicciones(RegresionLinealSimple regresionLinealSimple) {
        this.regresionLinealSimple = regresionLinealSimple;
    }

    public double prediccion(int x) {
        return this.regresionLinealSimple.getB0() + this.regresionLinealSimple.getB1() * (double)x;
    }

    public double[] predicciones(int[] valores) {
        double[] resultados = new double[valores.length];

        for(int i = 0; i < valores.length; ++i) {
            resultados[i] = this.prediccion(valores[i]);
        }

        return resultados;
    }
}
