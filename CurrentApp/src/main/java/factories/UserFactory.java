package factories;

import models.UserModel;

public class UserFactory {
    public UserModel getUser(String userType, String[] data) {
        if(userType == null) {
            return null;
        }

        if(userType.equalsIgnoreCase("0")) {
            return new UserModel(data[0], data[1], data[2], data[3], data[4], data[5]);
        }
        //else if(userType.equalsIgnoreCase("Rep"){ return repModel }
        //else if(userType.equalsIgnoreCase("Admin"){ return adminModel }
        return null;
    }
}
