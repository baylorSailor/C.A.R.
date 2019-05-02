import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import views.CreateAccountView;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountViewTest {
    protected final CreateAccountView createAccountView = new CreateAccountView();

    @Test
    public void commaInName(){
        String [] strings = new String[7];
        strings[0] = "Magg,ie Burton";
        strings[1] = "Mburton";
        strings[2] = "burton.maggie81@gmail.com";
        strings[3] = "abd";
        strings[4] = "Visa";
        strings[5] = "1111222233334444";
        strings[6] = "abc";

        assertFalse(createAccountView.allFieldsEntered(strings), "Input cannot contain comma");

    }

    @Test
    public void commaInUserName(){

        String [] strings = new String[7];
        strings[0] = "Maggie Burton";
        strings[1] = "M,burton";
        strings[2] = "burton.maggie81@gmail.com";
        strings[3] = "abd";
        strings[5] = "1111222233334444";
        strings[6] = "abc";

        assertFalse(createAccountView.allFieldsEntered(strings), "Input cannot contain comma");

    }

    @Test
    public void commaInEmail(){

        String [] strings = new String[7];
        strings[0] = "Maggie Burton";
        strings[1] = "Mburton";
        strings[2] = "burton,maggie81@gmail.com";
        strings[3] = "abd";
        strings[5] = "1111222233334444";
        strings[6] = "abc";

        assertFalse(createAccountView.allFieldsEntered(strings), "Input cannot contain comma");

    }


    @Test
    public void commaInPassword(){

        String [] strings = new String[7];
        strings[0] = "Maggie Burton";
        strings[1] = "Mburton";
        strings[2] = "burton.maggie81@gmail.com";
        strings[3] = "ab,c";
        strings[5] = "1111222233334444";
        strings[6] = "abc";

        assertFalse(createAccountView.allFieldsEntered(strings), "Input cannot contain comma");


    }

    @Test
    public void commaInCreditCardNumber(){

        String [] strings = new String[7];
        strings[0] = "Maggie Burton";
        strings[1] = "Mburton";
        strings[2] = "burton.maggie81@gmail.com";
        strings[3] = "abc";
        strings[5] = "1111,222233334444";
        strings[6] = "abc";

        assertFalse(createAccountView.allFieldsEntered(strings), "Input cannot contain comma");
    }

    @Test
    public void emptyName(){

        String [] strings = new String[7];
        strings[0] = "";
        strings[1] = "Mburton";
        strings[2] = "burton.maggie81@gmail.com";
        strings[3] = "abc";
        strings[5] = "1111,222233334444";
        strings[6] = "abc";

        assertFalse(createAccountView.allFieldsEntered(strings), "Input cannot contain comma");
    }


}