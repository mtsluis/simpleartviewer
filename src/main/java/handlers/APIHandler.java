package handlers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIHandler {

    private final String MET_SEARCH_URL = "https://collectionapi.metmuseum.org/public/collection/v1/search?q=";
    private final String MET_ARTWORKS_URL = "https://collectionapi.metmuseum.org/public/collection/v1/objects/";

    public HttpResponse<String> keywordSearchRequest(String searchQuery) throws URISyntaxException, IOException, InterruptedException {
        searchQuery = searchQuery.replaceAll(" ", "+");
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(MET_SEARCH_URL + searchQuery))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return getResponse;
    }

    public HttpResponse<String> artworkSearchRequest(String artworkID) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(MET_ARTWORKS_URL + artworkID))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return getResponse;
    }
}
