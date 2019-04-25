package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import views.AccountDetailsView;
import views.ActiveRentalsView;
import views.HistoryView;
import views.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Integer carListPosition = 0;

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
        leftArrowButtonPressed();
        rightArrowButtonPressed();
        makeSelected();
        modelSelected();
        yearSelected();
        typeSelected();
        transmissionSelected();
        interiorColorSelected();
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
                    " has been added to your active rentals.",
                    "Confirmation",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon);

            //TODO Add selected car to Active Rentals

        });
    }

    /**
     * Adds action listener for the left arrow button
     */
    private void leftArrowButtonPressed() {
        mainMenuView.getBtLeftButton().addActionListener(e -> {
            log.log(Level.INFO,"Left arrow button clicked");
            //TODO Implement left arrow
        });
    }

    /**
     * Adds action listener for the right arrow button
     */
    private void rightArrowButtonPressed() {
        mainMenuView.getBtRightButton().addActionListener(e -> {
            log.log(Level.INFO,"Right arrow button clicked");
            //TODO Implement right arrow
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
                clearCriteria(6);
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
            String selectedMake = (String) mainMenuView.getCmbMake().getSelectedItem();
            String selectedModel = (String) mainMenuView.getCmbModel().getSelectedItem();

            DefaultComboBoxModel model = new DefaultComboBoxModel( DatabaseAdapter.loadAllYears(selectedMake,
                    selectedModel) );
            mainMenuView.getCmbYear().setModel( model );
            if(selectedModel.equals("-")) {
                clearCriteria(5);
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
            String selectedMake = (String) mainMenuView.getCmbMake().getSelectedItem();
            String selectedYear = (String) mainMenuView.getCmbYear().getSelectedItem();
            String selectedModel = (String) mainMenuView.getCmbModel().getSelectedItem();

            DefaultComboBoxModel year = new DefaultComboBoxModel( DatabaseAdapter.loadAllTypes(selectedMake,
                    selectedModel,selectedYear) );
            mainMenuView.getCmbType().setModel( year );
            if(selectedYear.equals("-")) {
                clearCriteria(4);
            } else {
                mainMenuView.getCmbType().setEnabled(true);
            }
        });
    }

    /**
     * Adds action listener for the selected Type & changes the transmission
     */
    private void typeSelected() {
        mainMenuView.getCmbType().addActionListener(e -> {
            String selectedMake = (String) mainMenuView.getCmbMake().getSelectedItem();
            String selectedModel = (String) mainMenuView.getCmbModel().getSelectedItem();
            String selectedYear = (String) mainMenuView.getCmbYear().getSelectedItem();
            String selectedType = (String) mainMenuView.getCmbType().getSelectedItem();

            DefaultComboBoxModel type = new DefaultComboBoxModel( DatabaseAdapter.loadAllTransmissions(selectedMake,
                    selectedModel,selectedYear, selectedType) );
            mainMenuView.getCmbTrans().setModel( type );
            if(selectedType.equals("-")) {
                clearCriteria(3);
            } else {
                mainMenuView.getCmbTrans().setEnabled(true);
            }
        });
    }

    /**
     * Adds action listener for the selected Transmission & changes the interior color
     */
    private void transmissionSelected() {
        mainMenuView.getCmbTrans().addActionListener(e -> {
            String selectedMake = (String) mainMenuView.getCmbMake().getSelectedItem();
            String selectedModel = (String) mainMenuView.getCmbModel().getSelectedItem();
            String selectedYear = (String) mainMenuView.getCmbYear().getSelectedItem();
            String selectedType = (String) mainMenuView.getCmbType().getSelectedItem();
            String selectedTransmission = (String) mainMenuView.getCmbTrans().getSelectedItem();

            DefaultComboBoxModel trans = new DefaultComboBoxModel( DatabaseAdapter.loadAllInteriorColor(selectedMake,
                    selectedModel,selectedYear,selectedType,selectedTransmission) );
            mainMenuView.getCmbInterior().setModel( trans );
            if(selectedTransmission.equals("-")) {
                clearCriteria(1);
            } else {
                mainMenuView.getCmbInterior().setEnabled(true);
            }
        });
    }

    /**
     * Adds action listener for the selected interior color & changes the exterior color
     */
    private void interiorColorSelected() {
        mainMenuView.getCmbInterior().addActionListener(e -> {
            String selectedMake = (String) mainMenuView.getCmbMake().getSelectedItem();
            String selectedModel = (String) mainMenuView.getCmbModel().getSelectedItem();
            String selectedYear = (String) mainMenuView.getCmbYear().getSelectedItem();
            String selectedType = (String) mainMenuView.getCmbType().getSelectedItem();
            String selectedTransmission = (String) mainMenuView.getCmbTrans().getSelectedItem();
            String selectedInteriorColor = (String) mainMenuView.getCmbInterior().getSelectedItem();

            DefaultComboBoxModel interior = new DefaultComboBoxModel( DatabaseAdapter.loadAllExteriorColor(selectedMake,
                    selectedModel,selectedYear,selectedType,selectedTransmission,selectedInteriorColor) );
            mainMenuView.getCmbExterior().setModel( interior );
            if(selectedInteriorColor.equals("-")) {
                clearCriteria(0);
            } else {
                mainMenuView.getCmbExterior().setEnabled(true);
            }
        });
    }

    /**
     * Clears the criteria of all following search parameters based on which "-" is selected
     */
    private void clearCriteria(int selected) {
        switch (selected) {
            case 6 : {
                mainMenuView.getCmbModel().setSelectedIndex(0);
                mainMenuView.getCmbModel().setEnabled(false);
            }
            case 5 : {
                mainMenuView.getCmbYear().setSelectedIndex(0);
                mainMenuView.getCmbYear().setEnabled(false);
            }
            case 4 : {
                mainMenuView.getCmbType().setSelectedIndex(0);
                mainMenuView.getCmbType().setEnabled(false);
            }
            case 3 : {
                mainMenuView.getCmbTrans().setSelectedIndex(0);
                mainMenuView.getCmbTrans().setEnabled(false);
            }
            case 1 : {
                mainMenuView.getCmbInterior().setSelectedIndex(0);
                mainMenuView.getCmbInterior().setEnabled(false);
            }
            case 0 : {
                mainMenuView.getCmbExterior().setSelectedIndex(0);
                mainMenuView.getCmbExterior().setEnabled(false);
            }
        }
    }
}