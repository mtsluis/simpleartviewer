package handlers;

import ij.IJ;
import ij.ImagePlus;

public class ImageHandler {

    public static void showImage(String path){
        ImagePlus img = IJ.openImage(path);
        img.show();
    }
}
