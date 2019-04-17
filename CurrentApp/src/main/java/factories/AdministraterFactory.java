package factories;

import models.UserModel;

public class AdministraterFactory extends AbstractUserFactory {
    private static AdministraterFactory singleton = null;

    public UserModel getUser(String[] data) {
        return null;
        //return new AdministraterModel(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    public static AdministraterFactory AdministraterFactory() {
        if(singleton == null) {
            singleton = new AdministraterFactory();
        }

        return singleton;
    }
}
