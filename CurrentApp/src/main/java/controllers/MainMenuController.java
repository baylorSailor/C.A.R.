package controllers;

import main.CAR;
import views.AccountDetailsView;
import views.ActiveRentalsView;
import views.HistoryView;
import views.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for the main menu
 */
public class MainMenuController {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    private MainMenuView mainMenuView = new MainMenuView();
    private HistoryView historyView = null;
    private ActiveRentalsView activeRentalsView = null;
    private AccountDetailsView accountDetailsView = null;

    /**
     * Starts the controller for the buttons
     */
    public void start() {
        refreshButtonPressed();
        historyButtonPressed();
        activeRentalsButtonPressed();
        accountDetailsButtonPressed();
        logoutButtonPressed();
        addRentalButtonPressed();
    }

    /**
     * Adds action listener for the refresh button
     */
    private void refreshButtonPressed() {
        mainMenuView.getBtRefresh().addActionListener(e -> {
            log.log(Level.INFO,"Refresh button clicked");
        });
    }

    /**
     * Adds action listener for the history button
     */
    private void historyButtonPressed() {
        mainMenuView.getBtHistory().addActionListener(e -> {
            log.log(Level.INFO,"History button clicked");
            if(historyView == null) {
                historyView = new HistoryView();

                historyView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        historyView.dispose();
                        historyView = null;
                    }
                });
            }
        });
    }

    /**
     * Adds action listener for the active rentals button
     */
    private void activeRentalsButtonPressed() {
        mainMenuView.getBtActiveRentals().addActionListener(e -> {
            log.log(Level.INFO,"Active Rentals button clicked");
            if(activeRentalsView == null) {
                activeRentalsView = new ActiveRentalsView();

                activeRentalsView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        activeRentalsView.dispose();
                        activeRentalsView = null;
                    }
                });
            }
        });
    }

    /**
     * Adds action listener for the account details button
     */
    private void accountDetailsButtonPressed() {
        mainMenuView.getBtAccountDetails().addActionListener(e -> {
            log.log(Level.INFO,"Account Details button clicked");
            if(accountDetailsView == null) {
                accountDetailsView = new AccountDetailsView();

                accountDetailsView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        accountDetailsView.dispose();
                        accountDetailsView = null;
                    }
                });
            }
        });
    }

    /**
     * Adds action listener for the logout button
     */
    private void logoutButtonPressed() {
        mainMenuView.getBtLogout().addActionListener(e -> {
            log.log(Level.INFO,"Logout button clicked");
            mainMenuView.dispose();
            mainMenuView = null;
            if(historyView != null) {
                historyView.dispose();
                historyView = null;
            }
            if(accountDetailsView != null) {
                accountDetailsView.dispose();
                accountDetailsView = null;
            }
            if(activeRentalsView != null) {
                activeRentalsView.dispose();
                activeRentalsView = null;
            }
            new UserController().start();
        });
    }

    /**
     * Adds action listener for the add rental button
     */
    private void addRentalButtonPressed(){
        mainMenuView.getBtAddRental().addActionListener(e -> {
            log.log(Level.INFO,"Add Rental button clicked");
            ImageIcon icon = new ImageIcon("./src/main/resources/carIcon.png");

            JOptionPane.showMessageDialog(new Frame(),
                    "<Car> has been added to your active rentals.",
                    "Confirmation",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon);
        });
    }
}