package controllers;

import main.CAR;
import views.AccountDetailsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                    accountDetailsView.dispose();
                    accountDetailsView = null;
                }
            });
        }
    }

    /**
     * Starts the controller for the buttons
     */
    public void start() {
        changePasswordButtonPressed();
    }

    /**
     * Adds action listener for the change password button
     */
    public void changePasswordButtonPressed() {
        accountDetailsView.getBtChangePassword().addActionListener(e -> {
            String oldPass = JOptionPane.showInputDialog(null,
                    "Please enter your old password:",
                    "Old Password",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println(oldPass + "\n");
            //Check if same pass
            //New one
            //New one confirmation
            //check if they match
        });
    }

    /**
     * Ensures that the view is disposed of if Logout button is clicked
     */
    public void destroy() {
        log.log(Level.INFO,"AccountDetails Controller & View has been destroyed");
        if(accountDetailsView != null) {
            accountDetailsView.dispose();
            accountDetailsView = null;
        }
    }
}
