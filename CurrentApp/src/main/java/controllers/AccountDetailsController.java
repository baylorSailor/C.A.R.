package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import views.AccountDetailsView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for the account details view
 */
public class AccountDetailsController {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private AccountDetailsView accountDetailsView = null;

    /**
     * Constructs the account details view if not null
     */
    public AccountDetailsController() {
        if(accountDetailsView == null) {
            log.log(Level.INFO,"AccountDetails Controller & View has been created");
            accountDetailsView = new AccountDetailsView();
            start();
            accountDetailsView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    log.log(Level.INFO,"AccountDetails View has been disposed of");
                    destroy();
                }
            });
        }
    }

    /**
     * Starts the controller for the buttons
     */
    public void start() {
        changePasswordButtonPressed();
        changeCardInfoButtonPressed();
    }

    /**
     * Adds action listener for the change password button
     */
    public void changePasswordButtonPressed() {
        accountDetailsView.getBtChangePassword().addActionListener(e -> {
            log.log(Level.INFO,"Change password button clicked");
            String oldPass = JOptionPane.showInputDialog(null,
                    "Please enter your old password:",
                    "Old Password",
                    JOptionPane.INFORMATION_MESSAGE);
            if(UserController.getUser().getPassword().equals(oldPass)) {
                String newPass = JOptionPane.showInputDialog(null,
                        "Please enter your new password:",
                        "New Password",
                        JOptionPane.INFORMATION_MESSAGE);
                String retypePass = JOptionPane.showInputDialog(null,
                        "Please reenter your new password:",
                        "New Password (Again)",
                        JOptionPane.INFORMATION_MESSAGE);
                if(newPass.equals(retypePass)) {
                    // Update Password
                    DatabaseAdapter.updatePassword(newPass);
                    JOptionPane.showMessageDialog(null,"Your password has been changed."
                    ,"Confirmation",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Passwords do not match!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Incorrect password entered!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Adds action listener for the change card type button
     */
    private void changeCardInfoButtonPressed() {
        accountDetailsView.getBtChangeInfoInfo().addActionListener(e -> {
            log.log(Level.INFO,"Change card info button clicked");
            String newCardType = JOptionPane.showInputDialog(null,
                    "Please enter your new card type:",
                    "New Card Type",
                    JOptionPane.INFORMATION_MESSAGE);
            if(newCardType != null && (newCardType.equalsIgnoreCase("MasterCard") || newCardType.equalsIgnoreCase("Visa"))) {
                String newCardNumber = JOptionPane.showInputDialog(null,
                        "Please enter your new card number:",
                        "New Card Number",
                        JOptionPane.INFORMATION_MESSAGE);
                if(newCardNumber != null && (newCardNumber.length() < 20 & newCardNumber.length() > 11 & newCardNumber.matches("[0-9]+") )) {
                    JOptionPane.showMessageDialog(null,"Your card information has been saved."
                            ,"Confirmation",JOptionPane.INFORMATION_MESSAGE);
                    UserController.getUser().setCreditType(newCardType);
                    UserController.getUser().setCreditCard(newCardNumber);
                    refresh();
                    DatabaseAdapter.updateUser(UserController.getUser(),UserController.getUser());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Invalid Card Number!","ERROR",JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "Not an approved card type :(","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /**
     * Ensures that the view is disposed of if Logout button is clicked
     */
    public void destroy() {
        log.log(Level.INFO,"AccountDetails View has been destroyed");
        if(accountDetailsView != null) {
            accountDetailsView.dispose();
            accountDetailsView = null;
        }
    }

    /**
     * Ensures that the view is refresh if User info changes
     */
    public void refresh() {
        log.log(Level.INFO,"AccountDetails View has been refreshed");
        destroy();
        accountDetailsView = new AccountDetailsView();
        start();
    }
}
