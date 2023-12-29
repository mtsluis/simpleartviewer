package handlers;

import artwork.Artwork;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileHandler {


    public static void createTempDirectory() throws IOException {
        File directory = new File("thisisdefolda");
        directory.mkdirs();
        directory.deleteOnExit();
    }

    public static void deleteTempFiles() {
        File directory = new File("thisisdefolda");
        for(File file: directory.listFiles())
            if (!file.isDirectory())
                file.delete();
    }

    public static void saveImage(Artwork artwork) throws IOException {
        URL url = new URL(artwork.getPrimaryImage());
        BufferedImage img = ImageIO.read(url);
        File file = new File("thisisdefolda/image.jpg");
        ImageIO.write(img, "jpg", file);
        artwork.setFilePath("thisisdefolda/image.jpg");
    }
}
