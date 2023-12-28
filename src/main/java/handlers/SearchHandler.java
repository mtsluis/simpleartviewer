package handlers;

import artwork.Artwork;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;

public class SearchHandler {

    private int total;
    private int[] objectIDs;
    private Artwork[] artworksList;

    public int getTotal() {
        return total;
    }

    public int[] getObjectIDs() {
        return objectIDs;
    }

    public Artwork[] getArtworksList() {
        return artworksList;
    }

    public Artwork[] createArtList(APIHandler apiHandler, Gson gson, int searchLimit) throws URISyntaxException, IOException, InterruptedException {
        artworksList = new Artwork[searchLimit];
        for (int i = 0; i < searchLimit; i++) {
            Artwork artwork = gson.fromJson(apiHandler.artworkRequest(String.valueOf(objectIDs[i])).body(), Artwork.class);
            artworksList[i] = artwork;
        }
        return artworksList;
    }
}
