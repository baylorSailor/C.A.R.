class UserModel {
    private String fullname;
    private String pictureLocation;
    private String username;
    private String email;
    private String password;
    private String creditType;
    private String creditCard;

    public UserModel(String fullname, String username, String email, String password, String creditType,
                     String creditCard) {
        this.fullname = fullname;
        this.pictureLocation = "./src/main/resources/" + username + ".png";
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditType = creditType;
        this.creditCard = creditCard;
    }

    public String getFullname() {
        return fullname;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    public String getPictureLocation() {
        return pictureLocation;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCreditType() {
        return creditType;
    }

    public String getCreditCard() {
        return creditCard;
    }
}
