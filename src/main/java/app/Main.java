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

//TODO implementar runnable para o input do user e passar tudo a comandos em vez de uma linha lógica no main
//TODO criar um directório para armazenar informação do user se ele quiser criar um profile (criar classe Profile)
//TODO início pode ser 1-login, 2-create profile 3-use without profile(you may create one later)
//TODO
public class Main {
    public static void main(String[] args) {

        APIHandler apiHandler = new APIHandler();
        Gson gson = new Gson();

        System.out.println(Messages.WELCOME);
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        SearchHandler searchHandler;

        while (true) {
            System.out.println(Messages.SEARCH);
            try {
                FileHandler.createTempDirectory();
                userInput = scanner.nextLine();
                searchHandler = gson.fromJson(apiHandler.keywordSearchRequest(userInput).body(), SearchHandler.class);
                Artwork[] artworks = searchHandler.createArtList(apiHandler, gson, 10);
                TerminalPrint.printArtTable(artworks);

                System.out.println(Messages.SELECT_ART);
                userInput = scanner.nextLine();
                FileHandler.saveImage(artworks[Integer.parseInt(userInput) - 1]);
                ImageHandler.showImage(artworks[Integer.parseInt(userInput) - 1].getFilePath());

                System.out.println(Messages.QUIT);
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