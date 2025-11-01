import org.apache.commons.math3.linear.RealVector;

public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        ModeloRegresion modeloRegresion = new ModeloRegresion();
        Prediccion prediccion = new Prediccion();
        int grado = 5;

        System.out.println("---- PLR ----");

        modeloRegresion.calcularPolinomio(dataSet, grado);
        RealVector beta = modeloRegresion.getBeta();

        System.out.println("Coeficientes de la regresion polinomial de grado " + grado);
        for(int i = 0; i < beta.getDimension(); i++) {
            System.out.printf("β%d = %.4f\n", i, beta.getEntry(i));
        }

        System.out.println("\nEcuacion polinomial:");
        StringBuilder ecuacion = new StringBuilder("ŷ = ");
        for (int i = 0; i < beta.getDimension(); i++) {
            if (i == 0) {
                ecuacion.append(String.format("%.4f", beta.getEntry(i)));
            } else {
                ecuacion.append(String.format(" + %.4fx", beta.getEntry(i)));
                if (i > 1) ecuacion.append("^").append(i);
            }
        }
        System.out.println(ecuacion.toString());

        double[] resultado = prediccion.calcularPrediccion(dataSet, beta);
        double[] xPred = dataSet.getPrediccionesDureza();

        System.out.println("\nPredicciones:");
        for (int i = 0; i < resultado.length; i++) {
            StringBuilder formula = new StringBuilder();
            formula.append(String.format("ŷ = %.2f", beta.getEntry(0)));

            for (int j = 1; j < beta.getDimension(); j++) {
                formula.append(String.format(" + %.2f(%.1f)", beta.getEntry(j), xPred[i]));
                if (j > 1) formula.append("^").append(j);
            }

            formula.append(String.format(" = %.2f", resultado[i]));
            System.out.println(formula.toString());
        }

    }
}