import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadingPhoto {


    BufferedImage img = null;
    File file = null;
    String path;
    int width;
    int height;


    public LoadingPhoto(String path) {
        this.path = path;

    }


    public void loadPhoto() {

        try {
            file = new File(
                    "src/uwb.jpg");
            img = ImageIO.read(file);
            System.out.println(Thread.currentThread() + "Loading Photo");
            width = img.getWidth();
            height = img.getHeight();

        } catch (IOException e) {
            System.out.println(e);
        }


    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public File getFile() {
        return file;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}
