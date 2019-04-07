import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserController {
    UserModel user = null;
    LoginView view = new LoginView();

    public void start() {
        view.btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((user = DatabaseAdapter.Users.verifyUser(view.tfUser.getText(),view.tfPass.getText())) != null) {
                    view.setVisible(false);
                    view.dispose();
                    view = null;
                    new MainMenuController().start();
                } else {
                    view.lbError.setText("Incorrect username or password.");
                }
            }
        });

        view.btCreateAcct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccountView accountSetupView = new CreateAccountView();

                accountSetupView.btCreateAcct.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String creditType;
                        File file = new File("./src/main/resources/Users.csv");
                        if(accountSetupView.allFieldsEntered()) {
                            if(accountSetupView.rbVisa.isSelected()) {
                                creditType = "Visa";
                            } else {
                                creditType = "MasterCard";
                            }
                            user = new UserModel(accountSetupView.tfFirstName.getText() +
                                    accountSetupView.tfLastName.getText(),accountSetupView.tfUserName.getText(),
                                    accountSetupView.tfEmail.getText(),accountSetupView.tfPassword.getText(),
                                    creditType,accountSetupView.tfCreditCardNumber.getText());

                            if(file.exists()) {
                                DatabaseAdapter.Users.writeUser(user);
                                /// TODO Ensure that a photo is added, then save it
                                DatabaseAdapter.Users.SaveImage(user);
                            } else {
                                //TODO Log error
                            }
                        }
                        accountSetupView.setVisible(false);
                    }
                });
            }
        });
    }
}
