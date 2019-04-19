package models;

/**
 * Class representing a user
 */
public class UserModel {

    /**
     * User's full name
     */
    private String fullname;

    /**
     * User's picture location
     */
    private String pictureLocation;

    /**
     * User's username
     */
    private String username;

    /**
     * User's email
     */
    private String email;

    /**
     * User's password
     */
    private String password;

    /**
     * User's credit card type
     */
    private String creditType;

    /**
     * User's credit card number
     */
    private String creditCard;

    /**
     * Constructs user with given attributes
     * @param fullname full name of user
     * @param username account username
     * @param email user email
     * @param password user password
     * @param creditType user credit card type
     * @param creditCard user credit card number
     */
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

    /**
     * Gets the full name of the user
     * @return A string representing user's full name
     */
    public String getFullname() {
        return fullname;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    /**
     * Gets the picture location of the user
     * @return A string representing user's picture location
     */
    public String getPictureLocation() {
        return pictureLocation;
    }

    /**
     * Gets the username of the user
     * @return A string representing user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email of the user
     * @return A string representing user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password of the user
     * @return A string representing user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the credit card type of the user
     * @return A string representing user's credit card type
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * Gets the credit card number of the user
     * @return A string representing user's credit card number
     */
    public String getCreditCard() {
        return creditCard;
    }
}
