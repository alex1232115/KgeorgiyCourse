package technologies.internet.gson.les1;

public class UserPost {
    private String photoUrl;

    private int userId;

    private String description;

    private int likesQuantity;

    public UserPost() {
    }

    public UserPost(String photoUrl, int userId, String description, int likesQuantity) {
        this.photoUrl = photoUrl;
        this.userId = userId;
        this.description = description;
        this.likesQuantity = likesQuantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikesQuantity() {
        return likesQuantity;
    }

    public void setLikesQuantity(int likesQuantity) {
        this.likesQuantity = likesQuantity;
    }
}
