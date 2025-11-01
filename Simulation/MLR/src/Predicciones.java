import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Predicciones {
    public double[] calcularPredicciones(DataSet dataSet, RealVector beta) {
        double[] x_1 = dataSet.getPrediccionesDureza();
        double[] x_2 = dataSet.getPrediccionesFlexibilidad();
        double[] resultado = new double[x_1.length];

        for(int i = 0; i < x_1.length; i++) {
            resultado[i] = beta.getEntry(0) + beta.getEntry(1) * x_1[i] + beta.getEntry(2) * x_2[i];
        }

        return resultado;
    }
}
