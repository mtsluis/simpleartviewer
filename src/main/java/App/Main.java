package App;

import artwork.Artwork;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Gson gson = new Gson();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://collectionapi.metmuseum.org/public/collection/v1/objects/36774"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());


        Artwork artwork = gson.fromJson(getResponse.body(), Artwork.class);
        System.out.println(artwork.getObjectID());
        System.out.println(artwork.isPublicDomain());
        System.out.println(artwork.getPrimaryImageSmall());
        System.out.println(artwork.getDepartment());

    }
}