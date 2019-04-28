package factories;

import models.UserModel;

public class UserFactory extends AbstractUserFactory {
    private static UserFactory singleton = null;

    /**
     * Creates a new user and returns the user
     * @param data the data to create user with
     * @return the user
     */
    public UserModel getUser(String[] data) {
        return new UserModel(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    /**
     * Singleton constructor
     * @return the singleton
     */
    public static UserFactory UserFactory() {
        if(singleton == null) {
            singleton = new UserFactory();
        }

        return singleton;
    }
}
