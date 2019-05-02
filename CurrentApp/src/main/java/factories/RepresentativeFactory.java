package factories;

import models.RepresentativeModel;
import models.UserModel;

/**
 * Factory class for creating administrators
 */
public class RepresentativeFactory extends AbstractUserFactory {
    private static RepresentativeFactory singleton = null;

    /**
     * Creates a new representative and returns the user
     * @param data the data to create representative with
     * @return the representative
     */
    public UserModel getUser(String[] data) {
        return new RepresentativeModel(data[0], data[1], data[2], data[3], data[4], data[5]);
    }

    /**
     * Makes a user with given data, using flyweight design pattern
     * @param data
     * @return
     */
    public UserModel makeUser(String[] data){
        return super.makeUser(data);
    }

    /**
     * Singleton constructor
     * @return the singleton
     */
    public static RepresentativeFactory RepresentativeFactory() {
        if(singleton == null) {
            singleton = new RepresentativeFactory();
        }

        return singleton;
    }
}
