package app;

import artwork.Artwork;
import com.google.gson.Gson;
import handlers.APIHandler;
import handlers.FileHandler;
import handlers.ImageHandler;
import handlers.SearchHandler;
import terminalprint.TerminalPrint;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        APIHandler apiHandler = new APIHandler();
        Gson gson = new Gson();

        System.out.println("~~~ Welcome to simple art viewer ~~~\n");
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        SearchHandler searchHandler;

        while (true) {
            System.out.println("Search term: ");
            try {
                FileHandler.createTempDirectory();
                userInput = scanner.nextLine();
                searchHandler = gson.fromJson(apiHandler.keywordSearchRequest(userInput).body(), SearchHandler.class);
                Artwork[] artworks = searchHandler.createArtList(apiHandler, gson, 10);
                TerminalPrint.printArtTable(artworks);

                System.out.println("Which work would you like to see (select number): ");
                userInput = scanner.nextLine();
                FileHandler.saveImage(artworks[Integer.parseInt(userInput) - 1]);
                ImageHandler.showImage(artworks[Integer.parseInt(userInput) - 1].getFilePath());

                System.out.println("Quit? (y/n)");
                if (scanner.nextLine().equals("y")) {
                    break;
                }
            } catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        scanner.close();
        FileHandler.deleteTempFiles();
    }
}