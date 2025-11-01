public class Sumatorias {
    public void sumatorias(DataSet dataSet, RegresionLinealSimple regresionLinealSimple) {
        int[] x = dataSet.getX();
        int[] y = dataSet.getY();
        int n = y.length;
        double EX = (double)0.0F;
        double EY = (double)0.0F;
        double EXY = (double)0.0F;
        double Ex2 = (double)0.0F;
        double EX_2 = (double)0.0F;

        for(int i = 0; i < n; ++i) {
            double xi = (double)x[i];
            double yi = (double)y[i];
            double xy = xi * yi;
            double x2 = xi * xi;
            EX += xi;
            EY += yi;
            EXY += xy;
            Ex2 += x2;
        }

        EX_2 += EX * EX;
        regresionLinealSimple.formula(n, EX, EY, EXY, Ex2, EX_2);
    }
}
