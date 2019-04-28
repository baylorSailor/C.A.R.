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
     * Constructs user with given UserModel object
     * @param other UserModel to be copied
     */
    public UserModel(UserModel other) {
        this.fullname = other.fullname;
        this.pictureLocation = "./src/main/resources/" + other.username + ".png";
        this.username = other.username;
        this.email = other.email;
        this.password = other.password;
        this.creditType = other.creditType;
        this.creditCard = other.creditCard;
    }

    /**
     * Constructs user with given attributes in a String[]
     * @param array an array of strings containing user info
     */
    public UserModel(String[] array) {
        this.fullname = array[0];
        this.username = array[1];
        this.pictureLocation = "./src/main/resources/" + username + ".png";
        this.email = array[2];
        this.password = array[3];
        this.creditType = array[4];
        this.creditCard = array[5];
    }

    /**
     * Creates a string containing all given attributes of a user
     * @return a string with proper CSV formatting
     */
    @Override
    public String toString() {
        return getFullname() + "," + getUsername() + "," + getEmail() + "," +
                getPassword() + "," + getCreditType() + "," + getCreditCard() + "," +
                "0";
    }

    /**
     * Creates a string array containing all given attributes of a user
     * @return a string array with all given attributes of a user
     */
    public String[] toStringArray() {
        String[]strings = new String[6];
        strings[0] = fullname;
        strings[1] = username;
        strings[2] = email;
        strings[3] = password;
        strings[4] = creditType;
        strings[5] = creditCard;
        return strings;
    }

    /**
     * Sets the password of the user
     * @param  password a string representing user's new password
     */
    public void setPassword(String password) {
        this.password = password;
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

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
