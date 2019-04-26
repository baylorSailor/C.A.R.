package factories;

import models.AdministratorModel;
import models.UserModel;

public class AdministratorFactory extends AbstractUserFactory {
    private static AdministratorFactory singleton = null;

    public UserModel getUser(String[] data) {
        //return null;
        return new AdministratorModel(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    public static AdministratorFactory AdministratorFactory() {
        if(singleton == null) {
            singleton = new AdministratorFactory();
        }

        return singleton;
    }
}
