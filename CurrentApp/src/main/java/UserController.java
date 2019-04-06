import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    UserModel user = null;

    public void start() {
        LoginView view = new LoginView();

        view.btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((user = DatabaseAdapter.Users.verifyUser(view.tfUser.getText(),view.tfPass.getText())) != null) {
                    view.setVisible(false);
                    view.dispose();
                    new MainMenuController().start();
                } else {
                    view.lbError.setText("Incorrect username or password.");
                }
            }
        });

        view.btCreateAcct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
