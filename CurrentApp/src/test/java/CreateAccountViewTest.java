import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import views.CreateAccountView;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountViewTest {
    protected CreateAccountView createAccountView = null;

    @BeforeEach
    void init(){createAccountView = new CreateAccountView();}

    @Test
    public void passwordDoesNotMatch(){

        assertFalse(createAccountView.allFieldsEntered(), "Passwords Don't Match");

    }

    @Test
    public void passwordTooShort(){

        assertFalse(createAccountView.allFieldsEntered(), "Passwords Don't Match");

    }

    @Test
    public void commaInfName(){

        assertFalse(createAccountView.allFieldsEntered(), "Input cannot contain comma");

    }

    @Test
    public void commaInlName(){

        assertFalse(createAccountView.allFieldsEntered(), "Input cannot contain comma");

    }

    @Test
    public void commaInEmail(){

        assertFalse(createAccountView.allFieldsEntered(), "Input cannot contain comma");

    }

    @Test
    public void commaInUserName(){

        assertFalse(createAccountView.allFieldsEntered(), "Input cannot contain comma");

    }

    @Test
    public void commaInPassword(){

        assertFalse(createAccountView.allFieldsEntered(), "Input cannot contain comma");

    }



}