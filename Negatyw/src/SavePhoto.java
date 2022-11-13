import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SavePhoto {
    BufferedImage finalImg1;
    File f = null;

    public SavePhoto(BufferedImage finalImg1) {
        this.finalImg1 = finalImg1;
    }

    public void Savephoto() {

        try {

            f = new File(
                    "src/NegativeUwb.jpg");
            ImageIO.write(finalImg1, "png", f);
            System.out.println("Save new Photo");

        } catch (IOException e) {
            System.out.println(e);
        }

    }


}
