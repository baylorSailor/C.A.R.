package controllers;

import adapters.DatabaseAdapter;
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
        makeSelected();
        modelSelected();
        yearSelected();
    }

    /**
     * Adds action listener for the refresh button
     */
    private void refreshButtonPressed() {
        mainMenuView.getBtRefresh().addActionListener(e -> {
            log.log(Level.INFO,"Refresh button clicked");
            //TODO Refresh Search Results Pane
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
    private void addRentalButtonPressed() {
        mainMenuView.getBtAddRental().addActionListener(e -> {
            log.log(Level.INFO,"Add Rental button clicked");
            ImageIcon icon = new ImageIcon("./src/main/resources/logoSmall.png");

            JOptionPane.showMessageDialog(new Frame(),
                    "<Car> has been added to your active rentals.",
                    "Confirmation",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon);

            //TODO Add selected car to Active Rentals
        });
    }

    /**
     * Adds action listener for the selected Make & changes the models
     */
    private void makeSelected() {
        mainMenuView.getCmbMake().addActionListener(e -> {
            String selectedMake = (String) mainMenuView.getCmbMake().getSelectedItem();

            DefaultComboBoxModel model = new DefaultComboBoxModel( DatabaseAdapter.loadAllModels(selectedMake) );
            mainMenuView.getCmbModel().setModel( model );
            if(selectedMake.equals("-")) {
                mainMenuView.getCmbModel().setSelectedIndex(0);
                mainMenuView.getCmbYear().setSelectedIndex(0);
                mainMenuView.getCmbModel().setEnabled(false);
                mainMenuView.getCmbYear().setEnabled(false);
            } else {
                mainMenuView.getCmbModel().setEnabled(true);
            }
        });
    }

    /**
     * Adds action listener for the selected Model & changes the years
     */
    private void modelSelected() {
        mainMenuView.getCmbModel().addActionListener(e -> {
            String selectedModel = (String) mainMenuView.getCmbModel().getSelectedItem();

            DefaultComboBoxModel model = new DefaultComboBoxModel( DatabaseAdapter.loadAllYears(selectedModel) );
            mainMenuView.getCmbYear().setModel( model );
            if(selectedModel.equals("-")) {
                mainMenuView.getCmbYear().setSelectedIndex(0);
                mainMenuView.getCmbYear().setEnabled(false);
            } else {
                mainMenuView.getCmbYear().setEnabled(true);
            }
        });
    }

    /**
     * Adds action listener for the selected Year & changes the types
     */
    private void yearSelected() {
        mainMenuView.getCmbYear().addActionListener(e -> {
            String selectedYear = (String) mainMenuView.getCmbYear().getSelectedItem();

            DefaultComboBoxModel year = new DefaultComboBoxModel( DatabaseAdapter.loadAllTypes(selectedYear) );
            mainMenuView.getCmbType().setModel( year );
            if(selectedYear.equals("-")) {
                mainMenuView.getCmbType().setSelectedIndex(0);
                mainMenuView.getCmbType().setEnabled(false);
            } else {
                mainMenuView.getCmbType().setEnabled(true);
            }
        });
    }
}