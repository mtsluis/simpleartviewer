package handlers;

import artwork.Artwork;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileHandler {

    public static void saveImage(Artwork artwork) throws IOException {
        URL url = new URL(artwork.getPrimaryImage());
        BufferedImage img = ImageIO.read(url);
        File file = new File("tempfiles/image.jpg");
        ImageIO.write(img, "jpg", file);
        artwork.setFilePath("tempfiles/image.jpg");
    }
}
