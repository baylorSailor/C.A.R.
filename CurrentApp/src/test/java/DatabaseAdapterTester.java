import adapters.DatabaseAdapter;
import models.UserModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DatabaseAdapterTester {
    protected DatabaseAdapter data = null;

    @BeforeEach
    void init(){
        data = new DatabaseAdapter();
    }

    @Test
    @DisplayName("Should not save user with comma in name")
    public void commaInName(){
        assertFalse(data.writeUser(new UserModel("maggie,burton","burton_maggie",
                "burton.maggie81@gmail.com","abcdefg","Visa","111122223333444")),
                "Name cannot contain a comma");
    }

    @DisplayName("Should not save user with comma in username")
    @Test
    public void commaInUsername(){
        assertFalse(data.writeUser(new UserModel("maggie burton","burton,maggie",
                        "burton.maggie81@gmail.com","abcdefg","Visa","111122223333444")),
                "Username cannot contain a comma");
    }

    @DisplayName("Should not save user with comma in email")
    @Test
    public void commaInEmail(){
        assertFalse(data.writeUser(new UserModel("maggie burton","burton_maggie",
                        "burton,maggie81@gmail.com","abcdefg","Visa","111122223333444")),
                "Email cannot contain a comma");
    }

    @DisplayName("Should not save user with comma in password")
    @Test
    public void commaInPassword(){
        assertFalse(data.writeUser(new UserModel("maggie burton","burton_maggie",
                        "burton.maggie81@gmail.com","abcd,efg","Visa","111122223333444")),
                "Password cannot contain a comma");
    }

    @DisplayName("Should not save user with comma in credit card")
    @Test
    public void commaInCreditCard(){
        assertFalse(data.writeUser(new UserModel("maggie burton","burton_maggie",
                        "burton.maggie81@gmail.com","abcdefg","Visa","1111,22223333444")),
                "Credit Card cannot contain a comma");
    }


    @DisplayName("Should not save user if credit card type is not MasterCard or Visa")
    @Test
    public void IncorrectCreditCardType(){
        assertFalse(data.writeUser(new UserModel("maggie burton","burton_maggie",
                        "burton.maggie81@gmail.com","abcdefg","American Express","111122223333444")),
                "Credit Card cannot contain a comma");
    }

}
