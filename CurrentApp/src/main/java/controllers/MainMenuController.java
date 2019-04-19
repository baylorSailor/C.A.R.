package controllers;

import views.AccountDetailsView;
import views.ActiveRentalsView;
import views.HistoryView;
import views.MainMenuView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Controller for the main menu
 */
public class MainMenuController {
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

        });
    }

    /**
     * Adds action listener for the history button
     */
    private void historyButtonPressed() {
        mainMenuView.getBtHistory().addActionListener(e -> {
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
            System.out.println("Add rental button pressed");
        });
    }
}