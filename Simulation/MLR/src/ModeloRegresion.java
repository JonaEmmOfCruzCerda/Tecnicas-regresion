import org.apache.commons.math3.*;
import org.apache.commons.math3.linear.*;

public class ModeloRegresion {
    private RealVector beta;

    public RealVector getBeta() {
        return beta;
    }

    public void calcularCoeficientes(DataSet dataSet) {
        int n = dataSet.getX_1().length;

        double[][] x = new double[n][3];
        for(int i = 0; i < n; i++) {
            x[i][0] = 1;
            x[i][1] = dataSet.getX_1()[i];
            x[i][2] = dataSet.getX_2()[i];
        }

        RealMatrix X = MatrixUtils.createRealMatrix(x);
        RealVector Y = new ArrayRealVector(dataSet.getY());

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
