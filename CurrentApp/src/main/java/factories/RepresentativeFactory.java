package factories;

import models.UserModel;

public class RepresentativeFactory extends AbstractUserFactory {
    private static RepresentativeFactory singleton = null;

    public UserModel getUser(String[] data) {
        return null;
        //return new RepresentativeModel(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    public static RepresentativeFactory RepresentativeFactory() {
        if(singleton == null) {
            singleton = new RepresentativeFactory();
        }

        return singleton;
    }
}
