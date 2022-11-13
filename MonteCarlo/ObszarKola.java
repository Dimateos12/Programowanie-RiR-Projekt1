import java.util.concurrent.ThreadLocalRandom;

public class ObszarKola extends Thread{
    private final int TRIALS;
    private double result;
    private final double squareSide;
    private final Punkt_2D squareCenter;
    private final double circleRadius;
    private final double squareArea;

    public ObszarKola(int t, double squareSide, Punkt_2D squareCenter, double circRadius, double squareArea) {
        this.squareSide = squareSide;
        this.squareCenter = squareCenter;
        this.circleRadius = circRadius;
        this.squareArea = squareArea;
        this.TRIALS = t;
    }

    @Override
    public void run() {
        int insideCircle = 0;
        for (int i = 0; i < TRIALS; i++) {
            double x = ThreadLocalRandom.current().nextDouble(0, squareSide);
            double y = ThreadLocalRandom.current().nextDouble(0, squareSide);
            Punkt_2D randomPoint = new Punkt_2D(x, y);
            double distanceToCircleCenter = randomPoint.distanceFrom(squareCenter);
            if (distanceToCircleCenter <= circleRadius) {
                insideCircle += 1;
            }
        }

        double probabilityOfPointInCircle = (double)insideCircle / (double)TRIALS;
        this.result = probabilityOfPointInCircle * squareArea;
    }

    public double getResult() {
        return this.result;
    }
}