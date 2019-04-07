import javax.swing.*;
import java.io.File;

class UserController {
    static UserModel user = null;
    private LoginView view = new LoginView();

    public void start() {
        view.getBtLogin().addActionListener(e -> {
            if((user = DatabaseAdapter.Users.verifyUser(view.getTfUser().getText(),view.getTfPass().getText()))
                                                            != null) {
                view.setVisible(false);
                view.dispose();
                view = null;
                new MainMenuController().start();
            } else {
                view.getLbError().setText("Incorrect username or password.");
            }
        });

        view.getBtCreateAcct().addActionListener(e -> {
            CreateAccountView accountSetupView = new CreateAccountView();

            accountSetupView.getBtCreateAcct().addActionListener(e1 -> {
                String creditType;
                File file = new File("./src/main/resources/Users.csv");
                if(accountSetupView.allFieldsEntered()) {
                    if(accountSetupView.getRbVisa().isSelected()) {
                        creditType = "Visa";
                    } else {
                        creditType = "MasterCard";
                    }
                    user = new UserModel(accountSetupView.getTfFirstName().getText() +
                            accountSetupView.getTfLastName().getText(),accountSetupView.getTfUserName().getText(),
                            accountSetupView.getTfEmail().getText(),accountSetupView.getTfPassword().getText(),
                            creditType,accountSetupView.getTfCreditCardNumber().getText());

                    if(file.exists()) {
                        DatabaseAdapter.Users.writeUser(user);
                        DatabaseAdapter.Users.SaveImage(user);
                    } else {
                        //TODO Log error
                    }
                    accountSetupView.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "One or more fields are empty.",
                            "", JOptionPane.WARNING_MESSAGE);
                }
            });
        });
    }

    public static UserModel getUser() {
        return user;
    }
}
