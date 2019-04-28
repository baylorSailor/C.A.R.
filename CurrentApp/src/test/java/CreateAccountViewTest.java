import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountViewTest {
    protected CreateAccountView createAccountView = null;

    @BeforeEach
    void init(){createAccountView = new CreateAccountView();}

    @Test
    public void passwordDoesNotMatch(){
        createAccountView.setTfFirstName("Test");
        createAccountView.setTfLastName("Case");
        createAccountView.setTfCreditCardNumber("4444333322221111");
        createAccountView.setTfEmail("test@case.com");
        createAccountView.setTfUserName("test_case");
        createAccountView.setTfPassword("1234567");
        createAccountView.setTfPassword2("1234568");

        assertFalse(createAccountView.allFieldsEntered(), "Passwords Don't Match");

    }

    @Test
    public void passwordTooShort(){
        createAccountView.setTfFirstName("Test");
        createAccountView.setTfLastName("Case");
        createAccountView.setTfCreditCardNumber("4444333322221111");
        createAccountView.setTfEmail("test@case.com");
        createAccountView.setTfUserName("test_case");
        createAccountView.setTfPassword("12345");
        createAccountView.setTfPassword2("12345");

        assertFalse(createAccountView.allFieldsEntered(), "Passwords Don't Match");

    }



}