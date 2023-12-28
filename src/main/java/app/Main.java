package app;

import artwork.Artwork;
import com.google.gson.Gson;
import handlers.APIHandler;
import handlers.SearchHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TODO: implement an ImageHandler
        /*ImagePlus img = IJ.openImage("tempfiles/test.jpg");
        img.show();*/



       /* HttpRequest sendGETRequest = HttpRequest.newBuilder()
                .uri(new URI("https://collectionapi.metmuseum.org/public/collection/v1/search?title=true&q=sunflowers"))
                .build();

        System.out.println(sendGETRequest);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(sendGETRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse);*/

        /*Artwork artwork = gson.fromJson(getResponse.body(), Artwork.class);
        System.out.println(artwork.getObjectID());
        System.out.println(artwork.isPublicDomain());
        System.out.println(artwork.getPrimaryImage());

        System.out.println(searchHandler.getTotal());
        System.out.println(Arrays.toString(searchHandler.getObjectIDs()));*/

        //--------------------------------------------------------------------------------------------------

        APIHandler apiHandler = new APIHandler();
        Gson gson = new Gson();

        System.out.println("~~~ Welcome to simple art viewer ~~~\n");
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        
        while(!userInput.equals("/quit")) {
            System.out.println("Search term: ");
            userInput = scanner.nextLine();
            try {
                SearchHandler searchHandler = gson.fromJson(apiHandler.searchRequest(userInput).body(), SearchHandler.class);
                Artwork[] artworks = searchHandler.createArtList(apiHandler, 5);

            } catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}