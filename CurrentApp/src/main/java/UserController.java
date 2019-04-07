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

            accountSetupView.btCreateAcct.addActionListener(e1 -> {
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
            });
        });
    }

    public static UserModel getUser() {
        return user;
    }
}
