import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //ilosc watkow
        final int NUMBER_OF_TRIALS = 4;

        //Ilośc prób
        final int NUMBER_OF_TRIALS = 100000;

        //Promien okręgu
        final double CIRCLE_OF_RADIUS = 3;

        final Punkt_2D squareCenter = new Punkt_2D(CIRCLE_OF_RADIUS, CIRCLE_OF_RADIUS);


        final double squareSide = 2 * CIRCLE_OF_RADIUS;

        final double squareArea = Math.pow(squareSide, 2);

        //Dokładne pole koła
        final double PRECISE_CIRCLE_AREA = Math.PI * Math.pow(CIRCLE_OF_RADIUS, 2);

        //Ilość prób na wątek
        final int TRIALS_IN_THREAD = NUMBER_OF_TRIALS / NUMBER_OF_TRIALS;

        // Kolekcja wątków algorytmu
        ArrayList<ObszarKola> monteCarloThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
            ObszarKola t = new ObszarKola(TRIALS_IN_THREAD, squareSide, squareCenter, CIRCLE_OF_RADIUS, squareArea);
            monteCarloThreads.add(t);
            monteCarloThreads.get(i).start();
            monteCarloThreads.get(i).join();
        }

        double sumOfAreas = 0;

        for (ObszarKola monteCardloResult: monteCarloThreads
        ) {
            sumOfAreas += monteCardloResult.getResult();
        }

        double predictedCircleArea = (double)sumOfAreas / (double)THREADS;

        System.out.println("Dokładne pole koła: " + PRECISE_CIRCLE_AREA);
        System.out.println("Pole koła obliczone za pomocą symulacji: " + predictedCircleArea);
    }
}