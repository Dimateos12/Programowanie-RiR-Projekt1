public class Punkt_2D {
    private double x;
    private double y;

    //Tworzenie punktu - Konstruktor
    public Punkt_2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Dystans z punktu do punktu
    public double distanceFrom(Punkt_2D point) {
        return Math.sqrt(Math.pow((point.getX() - this.x), 2) + Math.pow((point.getY() - this.y), 2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}