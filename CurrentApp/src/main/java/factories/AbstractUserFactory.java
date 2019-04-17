package factories;

import models.UserModel;

abstract public class AbstractUserFactory {
    abstract public UserModel getUser(String[] data);
}
