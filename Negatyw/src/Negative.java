import java.awt.image.BufferedImage;
import java.io.IOException;

public class Negative  extends Thread{

    static int width ;
    static int height ;
    static BufferedImage finalImg ;
    int widthEnd;

    int widthStart;
    public Negative(int width, int height, BufferedImage img, int widthStart, int widthEnd) {
        this.width = width;
        this.height = height;
        this.widthEnd = widthEnd;
        this.widthStart = widthStart;
        this.finalImg = img;
    }

    int[][] newPixels = new int[width][height];


        public void run()
        {
            // Here the array is being
            // synchronized

                try{
                    for (int y = 0; y < height; y++) {
                        for (int x = widthStart; x < widthEnd-1; x++) {

                            int p = finalImg.getRGB(x, y);
                            int a = (p >> 24) & 0xff;
                            int r = (p >> 16) & 0xff;
                            int g = (p >> 8) & 0xff;
                            int b = p & 0xff;

                            // subtract RGB from 255
                            r = 255 - r;
                            g = 255 - g;
                            b = 255 - b;

                            // set new RGB value
                            p = (a << 24) | (r << 16) | (g << 8) | b;
                            finalImg.setRGB(x, y, p);

                        }
                        System.out.println("set Pixel"+ Thread.currentThread().getId());
                    }
                }catch (Exception e) {
                    System.out.println(e);
                }

          }




}

