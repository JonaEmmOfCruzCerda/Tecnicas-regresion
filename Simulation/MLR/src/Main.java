import org.apache.commons.math3.linear.RealVector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        ModeloRegresion modelo = new ModeloRegresion();
        Predicciones predicciones = new Predicciones();

        System.out.println("---- MLR ----");

        modelo.calcularCoeficientes(dataSet);
        RealVector beta = modelo.getBeta();

        System.out.println("Coeficientes de regresion");
        System.out.printf("β0 = %.2f\n", beta.getEntry(0));
        System.out.printf("β1 = %.2f\n", beta.getEntry(1));
        System.out.printf("β2 = %.2f\n", beta.getEntry(2));

        System.out.println("\nEcuacion: ŷ = " + String.format("%.2f + %.2fx1 + %.2fx2", beta.getEntry(0), beta.getEntry(1), beta.getEntry(2)));

        double[] resultado = predicciones.calcularPredicciones(dataSet, beta);
        double[] x_1 = dataSet.getPrediccionesDureza();
        double[] x_2 = dataSet.getPrediccionesFlexibilidad();

        System.out.println("\nPredicciones:");
        for(int i = 0; i < resultado.length; i++) {
            System.out.printf("ŷ = %.2f + %.2f (%.1f) + %.2f (%.1f) = %.2f\n", beta.getEntry(0), beta.getEntry(1), x_1[i], beta.getEntry(2), x_2[i], resultado[i]);
        }
    }
}