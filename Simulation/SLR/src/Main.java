import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        Sumatorias sumatorias = new Sumatorias();
        RegresionLinealSimple regresionLinealSimple = new RegresionLinealSimple();
        Predicciones pred = new Predicciones(regresionLinealSimple);
        sumatorias.sumatorias(dataSet, regresionLinealSimple);
        System.out.println("---- SLR ----");
        System.out.println("Coeficientes");
        PrintStream var10000 = System.out;
        Object[] var10002 = new Object[]{regresionLinealSimple.getB0()};
        var10000.println("β0: " + String.format("%.2f", var10002));
        var10000 = System.out;
        var10002 = new Object[]{regresionLinealSimple.getB1()};
        var10000.println("β1: " + String.format("%.2f", var10002) + "\n");
        var10000 = System.out;
        String var10001 = String.format("%.2f", regresionLinealSimple.getB0());
        var10000.println("Sales = " + var10001 + " + " + String.format("%.2f", regresionLinealSimple.getB1()) + " advertising \n");
        System.out.println("Ecuacion de regresion");

        for(int i = 0; i < dataSet.getX().length; ++i) {
            int xi = dataSet.getX()[i];
            double resultado = regresionLinealSimple.getB0() + regresionLinealSimple.B1 * (double)xi;
            var10000 = System.out;
            var10001 = String.format("%.2f", regresionLinealSimple.getB0());
            var10000.println("ŷ = " + var10001 + " + " + String.format("%.2f", regresionLinealSimple.getB1()) + " * (" + xi + ") = " + resultado);
        }

        System.out.println("");
        int[] valoresParaPredecir = dataSet.getPrediccion();
        double[] resultados = pred.predicciones(valoresParaPredecir);
        System.out.println("Predicciones de Sales");

        for(int i = 0; i < valoresParaPredecir.length; ++i) {
            var10000 = System.out;
            var10001 = String.format("%.2f", regresionLinealSimple.getB0());
            var10000.println("ŷ = " + var10001 + " + " + String.format("%.2f", regresionLinealSimple.getB1()) + " * (" + valoresParaPredecir[i] + ") = " + String.format("%.2f", resultados[i]));
        }

    }
}
