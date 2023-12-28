package artwork;

public class Artwork {

    private int objectID;
    private boolean isPublicDomain;
    private String primaryImageSmall;
    private String department;

    public int getObjectID() {
        return objectID;
    }

    public String getPrimaryImageSmall() {
        return primaryImageSmall;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isPublicDomain() {
        return isPublicDomain;
    }
}
