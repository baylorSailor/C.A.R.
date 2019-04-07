import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JPanel {

    static UserController userController = new UserController();
    //TODO Add Vehicle Class

//    static void destroyPanes() {
//        try {
////            login.dispose();
//            listings.dispose();
//            account.dispose();
//            history.dispose();
//            accountDetails.dispose();
//            activeRentals.dispose();
//        } catch(NullPointerException e) {
//            //TODO add logger to catch this
//        } finally {
//            listings = null;
//            account = null;
//            history = null;
//            accountDetails = null;
//            activeRentals = null;
////            login = new LoginView();
//        }
//    }

    public static void main(String[] args) {
        userController.start();
    }
}
