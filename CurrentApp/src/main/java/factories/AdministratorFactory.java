package factories;

import models.AdministratorModel;
import models.UserModel;

/**
 * Factory class for creating administrators
 */
public class AdministratorFactory extends AbstractUserFactory {
    private static AdministratorFactory singleton = null;

    /**
     * Creates a new administrator and returns the user
     * @param data the data to create admin with
     * @return the administrator
     */
    public UserModel getUser(String[] data) {
        return new AdministratorModel(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    /**
     * Singleton constructor
     * @return the singleton
     */
    public static AdministratorFactory AdministratorFactory() {
        if(singleton == null) {
            singleton = new AdministratorFactory();
        }

        return singleton;
    }

    /**
     * Makes a user with given data, using flyweight design pattern
     * @param data
     * @return
     */
    public UserModel makeUser(String[] data){
        return super.makeUser(data);
    }

}
