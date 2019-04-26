package models;

public class AdministratorModel extends UserModel {

    public AdministratorModel(String fullname, String username, String email, String password, String creditType,
                       String creditCard) {
        super(fullname,username,email,password,creditType,creditCard);
    }

    public AdministratorModel(String[] strings) {
        super(strings);
    }

    public AdministratorModel(UserModel userModel) {
        super(userModel);
    }
}
