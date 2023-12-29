package terminalprint;

import artwork.Artwork;

public class TerminalPrint {
    public static void printHeader() {
        System.out.printf(" --------------------------------------------------------------------------------------------------%n");
        System.out.printf("| #  | %-45s | %-25s | %-15s |%n", "TITLE", "ARTIST", "DATE");
        System.out.printf(" --------------------------------------------------------------------------------------------------%n");

    }
    public static void printArtTable(Artwork[] artList) {
        printHeader();
        String title;
        String artist;
        String date;
        for (int i = 0; i < artList.length; i++) {
            title = artList[i].getTitle().length() > 44 ? artList[i].getTitle().substring(0, 44) : artList[i].getTitle();
            artist = artList[i].getArtistDisplayName().length() > 24 ? artList[i].getArtistDisplayName().substring(0, 24) : artList[i].getArtistDisplayName();
            date = artList[i].getObjectDate().length() > 14 ? artList[i].getObjectDate().substring(0, 14) : artList[i].getObjectDate();
            if (i >= 9) {
                System.out.printf("| %d | %-45s | %-25s | %-15s |%n", i + 1, title, artist, date);
                continue;
            }
            System.out.printf("| %d  | %-45s | %-25s | %-15s |%n", i + 1, title, artist, date);
        }
        System.out.printf(" --------------------------------------------------------------------------------------------------%n");
    }
}
