import org.apache.commons.math3.linear.*;

public class ModeloRegresion {
    private RealVector beta;

    public RealVector getBeta() {
        return beta;
    }

    private double coeficienteCorrelacion(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
        }

        double numerador = (n * sumXY) - (sumX * sumY);
        double denominador = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        return numerador / denominador;
    }

    public double mse(RealMatrix X, RealVector Y, RealVector beta) {
        RealVector Y_pred = X.operate(beta);
        double sumaE2 = 0.0;
        for (int i = 0; i < Y.getDimension(); i++) {
            double error = Y_pred.getEntry(i) - Y.getEntry(i);
            sumaE2 += error * error;
        }
        return sumaE2 / Y.getDimension();
    }

    public void calcularPolinomio(DataSet dataSet, int grado) {
        double[] x_1 = dataSet.getX_1();
        double[] y = dataSet.getY();
        int n = x_1.length;

        double[][] x = new double[n][grado + 1];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j <= grado; j++) {
                x[i][j] = Math.pow(x_1[i], j);
            }
        }

        RealMatrix X = MatrixUtils.createRealMatrix(x);
        RealVector Y = new ArrayRealVector(y);

        RealMatrix XT = X.transpose();
        RealMatrix XTX = XT.multiply(X);
        RealMatrix inversaXTX = new LUDecomposition(XTX).getSolver().getInverse();

        beta = inversaXTX.multiply(XT).operate(Y);

        // mostrarMatriz(inversaXTX);
        // mostrarVectorY(Y);
        // mostrarVectorBeta(beta);
    }

    private void mostrarMatriz(RealMatrix matriz) {
        System.out.println("\nMatriz X:");
        for (int i = 0; i < matriz.getRowDimension(); i++) {
            for (int j = 0; j < matriz.getColumnDimension(); j++) {
                System.out.printf("%.2f\t", matriz.getEntry(i, j));
            }
            System.out.println();
        }
    }

    private void mostrarVectorY(RealVector beta) {
        for (int i = 0; i < beta.getDimension(); i++) {
            System.out.printf("Y%d = %.4f%n", i, beta.getEntry(i));
        }
    }

    private void mostrarVectorBeta(RealVector beta) {
        for (int i = 0; i < beta.getDimension(); i++) {
            System.out.printf("β%d = %.4f%n", i, beta.getEntry(i));
        }
    }
}