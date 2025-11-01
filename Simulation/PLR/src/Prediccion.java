import org.apache.commons.math3.linear.RealVector;

public class Prediccion {
    public double[] calcularPrediccion(DataSet dataSet, RealVector beta) {
        double[] x_1 = dataSet.getPrediccionesDureza();
        double[] resultado = new double[x_1.length];

        for(int i = 0; i < x_1.length; i++) {
            double y = 0;
            for(int j = 0; j < beta.getDimension(); j++) {
                y += beta.getEntry(j) * Math.pow(x_1[i], j);
            }
            resultado[i] = y;
        }
        return resultado;
    }
}