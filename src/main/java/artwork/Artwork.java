package artwork;

public class Artwork {

    private int objectID;
    private boolean isPublicDomain;
    private String primaryImage;
    private String artistDisplayName;
    private String title;
    private String objectDate;

    private String filePath;

    public int getObjectID() {
        return objectID;
    }

    public boolean isPublicDomain() {
        return isPublicDomain;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public String getArtistDisplayName() {
        return artistDisplayName;
    }

    public String getTitle() {
        return title;
    }

    public String getObjectDate() {
        return objectDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
