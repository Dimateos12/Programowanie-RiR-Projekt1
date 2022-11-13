import java.io.IOException;

public class Main extends Thread {
    public static final int DELAY = 10;
    public static final int NUMBER_OF_THREADS = 4;


    public static void main(String[] args) throws IOException, InterruptedException {

        LoadingPhoto photo = new LoadingPhoto("src/uwb.jpg");
        photo.loadPhoto();

        int width = photo.getWidth();
        int height = photo.getHeight();
        int widthPerThread = photo.getWidth() / NUMBER_OF_THREADS;

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {

            int start = i * widthPerThread;
            int end = (i + 1) * widthPerThread + 1;

            Negative negative = new Negative(start, height, photo.getImg(), start, end);
            negative.start();
            negative.join();
        }
        SavePhoto savePhoto = new SavePhoto(Negative.finalImg);
        savePhoto.Savephoto();

    }

    ;


}


