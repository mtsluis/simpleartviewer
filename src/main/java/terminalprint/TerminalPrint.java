package terminalprint;

import artwork.Artwork;

public class TerminalPrint {
    public static void printHeader() {
        System.out.printf(" --------------------------------------------------------------------------------------------%n");
        System.out.printf("| # | %-45s | %-20s | %-15s |%n", "TITLE", "ARTIST", "DATE");
        System.out.printf(" --------------------------------------------------------------------------------------------%n");

    }
    public static void printArtTable(Artwork[] artList) {
        printHeader();
        for (int i = 0; i < artList.length; i++) {
            System.out.printf("| %d | %-45s | %-20s | %-15s |%n", i + 1, artList[i].getTitle(), artList[i].getArtistDisplayName(), artList[i].getObjectDate());
        }
        System.out.printf(" --------------------------------------------------------------------------------------------%n");

    }
}
