public class DataSet {
    private int[] x = new int[]{23, 26, 30, 34, 43, 48, 52, 57, 58};
    private int[] y = new int[]{651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
    private int[] valoresAPredecir = new int[]{25, 29, 36, 38, 40, 45, 50, 55};

    public int[] getX() {
        return this.x;
    }

    public int[] getY() {
        return this.y;
    }

    public int[] getPrediccion() {
        return this.valoresAPredecir;
    }
}
