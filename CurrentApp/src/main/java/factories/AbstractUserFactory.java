package factories;

import models.UserModel;
import java.util.HashMap;


// Implementing Factory Design pattern & Flyweight
abstract public class AbstractUserFactory {

    static HashMap<String, UserModel> hMap = new HashMap<>();

    abstract public UserModel getUser(String[] data);

    // Flyweight Design Pattern
    public UserModel makeUser(String[] data){
        UserModel user = null;
        String name = data[0];

        // If map has user, return reference to it
        if(hMap.containsKey(name)){
            user = hMap.get(name);
        }
        else{
            //Make user depending on type
            user = getUser(data);
            hMap.put(name, user);
        }
        return user;
    }
}
