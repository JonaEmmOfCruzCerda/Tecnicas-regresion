public class DataSet {
    private double[] x_1 = {41.9, 43.4, 43.9, 44.5, 47.3, 47.5, 47.9, 50.2, 52.8, 53.2, 56.7, 57.0, 63.5, 65.3, 71.1, 77.0, 77.8};
    private double[] x_2 = {29.1, 29.3, 29.5, 29.7, 29.9, 30.3, 30.5, 30.7, 30.8, 30.9, 31.5, 31.7, 31.9, 32.0, 32.1, 32.5, 32.9};
    private double[] y = {251.3, 251.3, 248.3, 267.5, 273.0, 276.5, 270.3, 274.9, 285.0, 290.0, 297.0, 302.5, 304.5, 309.3, 321.7, 330.7, 349.0};

    public double[] prediccionesDureza = {80.5, 82.4, 88.9, 90.2, 93.9, 98.0, 100.1};
    public double[] prediccionesFlexibilidad = {40.5, 42.4, 48.9, 50.2, 53.9, 58.0, 60.1};

    public double[] getX_1() {
        return x_1;
    }

    public double[] getX_2() {
        return x_2;
    }

    public double[] getY() {
        return y;
    }

    public double[] getPrediccionesDureza() {
        return prediccionesDureza;
    }

    public double[] getPrediccionesFlexibilidad() {
        return prediccionesFlexibilidad;
    }
}