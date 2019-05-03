package models;

public class RepresentativeModel extends UserModel{
    /**
     * Constructs a representative object
     * @param fullname the admin's first and last name
     * @param username the username
     * @param email the email
     * @param password the password
     * @param creditType credit card type
     * @param creditCard credit card num
     */
    public RepresentativeModel(String fullname,String username,String email,
                              String password,String creditType,String creditCard) {
        super(fullname,username,email,password,creditType,creditCard);
    }

    /**
     * Constructs an admin object with given data
     * @param strings the data
     */
    public RepresentativeModel(String[] strings) {
        super(strings);
    }

    /**
     * Constructs an admin given another user
     * @param userModel the user to copy
     */
    public RepresentativeModel(UserModel userModel) {
        super(userModel);
    }
}
