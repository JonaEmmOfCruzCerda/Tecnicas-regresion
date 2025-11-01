public class RegresionLinealSimple {
    public double B0 = (double)0.0F;
    public double B1 = (double)0.0F;

    public void formula(int n, double EX, double EY, double EXY, double Ex2, double EX_2) {
        this.B0 = (EY * Ex2 - EX * EXY) / ((double)n * Ex2 - EX_2);
        this.B1 = ((double)n * EXY - EX * EY) / ((double)n * Ex2 - EX_2);
    }

    public double getB0() {
        return this.B0;
    }

    public double getB1() {
        return this.B1;
    }
}