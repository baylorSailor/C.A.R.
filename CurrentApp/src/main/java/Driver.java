import javax.swing.*;

public class Driver extends JPanel {

    static UserController userController = new UserController();

    public static void main(String[] args) {
        userController.start();
    }
}
