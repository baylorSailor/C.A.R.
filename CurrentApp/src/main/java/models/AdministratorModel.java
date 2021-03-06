package models;

/**
 * Class representing an administrator
 */
public class AdministratorModel extends UserModel {

    /**
     * Constructs an administrator object
     * @param fullname the admin's first and last name
     * @param username the username
     * @param email the email
     * @param password the password
     * @param creditType credit card type
     * @param creditCard credit card num
     */
    public AdministratorModel(String fullname,String username,String email,
                              String password,String creditType,String creditCard) {
        super(fullname,username,email,password,creditType,creditCard);
    }

    /**
     * Constructs an admin object with given data
     * @param strings the data
     */
    public AdministratorModel(String[] strings) {
        super(strings);
    }

    /**
     * Constructs an admin given another user
     * @param userModel the user to copy
     */
    public AdministratorModel(UserModel userModel) {
        super(userModel);
    }
}
