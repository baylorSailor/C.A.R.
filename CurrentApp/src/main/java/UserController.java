import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                        try {
                            String creditType;
                            BufferedWriter bw;
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
                                    bw = new BufferedWriter(new FileWriter("./src/main/resources/Users.csv", true));
                                    bw.write(tfFirstName.getText() + " " + tfLastName.getText() + ","
                                            + tfUserName.getText() + "," + tfEmail.getText() + "," + tfPassword.getText() + ","
                                            + creditType + "," + tfCreditCardNumber.getText() +  "\n");
                                    bw.close();
                                    /// TODO Ensure that a photo is added, then save it
                                    SaveImage();
                                } else {
                                    //TODO Log error
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        setVisible(false);
                    }
                });
            }
        });
    }

    public UserModel getUser() {
        return user;
    }
}
