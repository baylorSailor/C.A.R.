import javax.swing.*;
import java.io.File;

class UserController {
    static UserModel user = null;
    private LoginView loginView = new LoginView();
    private MainMenuController mainMenuController = null;
    private CreateAccountView createAccountView = null;

    public void start() {
        loginView.getBtLogin().addActionListener(e -> {
            if((user = DatabaseAdapter.Users.verifyUser(loginView.getTfUser().getText(),
                                                                    loginView.getTfPass().getText())) != null) {
                removeAllFramesAndStart();
            } else {
                loginView.getLbError().setText("Incorrect username or password.");
            }
        });

        loginView.getBtCreateAcct().addActionListener(e -> {
            createAccountView = new CreateAccountView();

            createAccountView.getBtAddImage().addActionListener(createAccountView::AddImage);

            createAccountView.getBtCreateAcct().addActionListener(e1 -> {
                if(DatabaseAdapter.Users.userExists(createAccountView.getTfEmail().getText())) {
                    createAccountView.setErrorLabelMessage("Account already exists.");
                }
                String creditType;
                File file = new File("./src/main/resources/Users.csv");
                if(createAccountView.allFieldsEntered()) {
                    if(createAccountView.getRbVisa().isSelected()) {
                        creditType = "Visa";
                    } else {
                        creditType = "MasterCard";
                    }
                    user = new UserModel(createAccountView.getTfFirstName().getText() +
                            createAccountView.getTfLastName().getText(),createAccountView.getTfUserName().getText(),
                            createAccountView.getTfEmail().getText(),createAccountView.getTfPassword().getText(),
                            creditType,createAccountView.getTfCreditCardNumber().getText());

                    if(file.exists()) {
                        DatabaseAdapter.Users.writeUser(user);
                        DatabaseAdapter.Users.SaveImage(user);
                    } else {
                        //TODO Log error
                    }
                    removeAllFramesAndStart();
                } else {
                    String message = "1. No fields may be left empty.\n" +
                                     "2. Password must be 7 or more characters.\n" +
                                     "3. Image is preferred, but no image is required.\n" +
                                     "4. Passwords must match.";
                    JOptionPane.showMessageDialog(null, message,
                            "Required Account Information", JOptionPane.WARNING_MESSAGE);
                }
            });
        });
    }

    public static UserModel getUser() {
        return user;
    }
    
    private void removeAllFramesAndStart() {
        loginView.dispose();
        loginView = null;
        createAccountView.dispose();
        createAccountView = null;
        mainMenuController = new MainMenuController();
        mainMenuController.start();
    }
}
