package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import models.CarModel;
import views.ActiveRentalsView;
import views.HistoryView;
import views.MainMenuView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private AccountDetailsController accountDetailsController = null;
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
        editUsersButtonPressed();
    }

    /**
     * Adds action listener for the refresh button
     */
    private void refreshButtonPressed() {
        mainMenuView.getBtRefresh().addActionListener(e -> {
            log.log(Level.INFO,"Refresh button clicked");
            boolean match = true;
            List<CarModel> retList = new ArrayList<>();
            CarModel[] fullList = mainMenuView.getCarList();
            for(int i = 0; i < fullList.length && match; i++) {
                if(!mainMenuView.getCmbMake().getSelectedItem().equals("-")) {

                    if(fullList[i].getMake().equals(mainMenuView.getCmbMake().getSelectedItem())) {

                        if(!mainMenuView.getCmbModel().getSelectedItem().equals("-")) {

                            if(fullList[i].getModel().equals(mainMenuView.getCmbModel().getSelectedItem())) {

                                if(!mainMenuView.getCmbYear().getSelectedItem().equals("-")) {

                                    if(fullList[i].getYear().toString().equals(mainMenuView.getCmbYear().getSelectedItem())) {

                                        if(!mainMenuView.getCmbType().getSelectedItem().equals("-")) {

                                            if(fullList[i].getType().equals(mainMenuView.getCmbType().getSelectedItem())) {

                                                if(!mainMenuView.getCmbTrans().getSelectedItem().equals("-")) {

                                                    if(fullList[i].getTransmission().equals(mainMenuView.getCmbTrans().getSelectedItem())) {

                                                        if(!mainMenuView.getCmbInterior().getSelectedItem().equals("-")) {

                                                            if(fullList[i].getInterior().equals(mainMenuView.getCmbInterior())) {

                                                                if(!mainMenuView.getCmbExterior().getSelectedItem().equals("-") &&
                                                                        !fullList[i].getExterior().equals(mainMenuView.getCmbExterior().getSelectedItem())) {

                                                                    match = false;
                                                                }
                                                            } else {
                                                                match = false;
                                                            }
                                                        }
                                                    } else {
                                                        match = false;
                                                    }
                                                }
                                            } else {
                                                match = false;
                                            }
                                        }
                                    } else {
                                        match = false;
                                    }
                                }
                            } else {
                                match = false;
                            }
                        }
                    } else {
                        match = false;
                    }
                }

                if(match) {
                    if(fullList[i].getMileage() < mainMenuView.getSdMileage().getValue()) {
                        match = false;
                    }

                    if(match && fullList[i].getMpgCombined() < mainMenuView.getSdMPG().getValue()) {
                        match = false;
                    }
                }

                if(!match) {
                    match = true;
                } else {
                    retList.add(fullList[i]);
                }
            }

            CarModel[] searchRet = new CarModel[ retList.size() ];
            retList.toArray(searchRet);

            mainMenuView.setSearchList(searchRet);

            mainMenuView.updateSearch();
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
                accountDetailsController = new AccountDetailsController();
        });
    }

    /**
     * Adds action listener for the edit users button
     */
    private void editUsersButtonPressed() {
        mainMenuView.getBtEditUsers().addActionListener(e -> {
            log.log(Level.INFO,"Edit Users button clicked");
            EditUsersController editUsersController = new EditUsersController();
            editUsersController.start();
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
            if(accountDetailsController != null) {
                accountDetailsController.destroy();
                accountDetailsController = null;
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
            //if the car is not already in active rentals then do all this
            //else then don't add it unless we want duplicates
            boolean failFlag = false;

            log.log(Level.INFO,"Add Rental button clicked");
            ImageIcon icon = new ImageIcon("./src/main/resources/logoSmall.png");


            String username = UserController.getUser().getUsername();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date dt = new Date();
            String date = df.format(dt);
            String mk = (String)(mainMenuView.getCmbMake().getSelectedItem());
            String mo = (String)(mainMenuView.getCmbModel().getSelectedItem());
            String yr = (String)(mainMenuView.getCmbYear().getSelectedItem());
            String tp = (String)(mainMenuView.getCmbType().getSelectedItem());
            String tr = (String)(mainMenuView.getCmbTrans().getSelectedItem());
            String intc = (String)(mainMenuView.getCmbInterior().getSelectedItem());
            String ext = (String)(mainMenuView.getCmbExterior().getSelectedItem());
            String mil = username + "," + date + "," + mk + "," + mo + "," + yr + "\n";
            try {
                if (mk.equals("-") || mo.equals("-") || yr.equals("-") || tp.equals("-")
                        || tr.equals("-") || intc.equals("-") || ext.equals("-")) {
                    failFlag = true;
                }
            } catch (NullPointerException p){
                p.printStackTrace();
            }
            if(!failFlag) {
                JOptionPane.showMessageDialog(null,
                        "[" + mk + " " + mo + yr + "] has been added to your active rentals.");
            } else {
                JOptionPane.showMessageDialog(null,"None " +
                        "of the fields can be left blank");
            }
            //testing
//            JOptionPane.showMessageDialog(null,
//                    "[" + mk + " " + mo + yr + "] has been added to your active rentals.",
//                    "Confirmation",
//                    JOptionPane.INFORMATION_MESSAGE,
//                    icon);

            // Add selected car to Active Rentals (Write to csv file)
            try {
                if(!failFlag) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/resources/activeRentals.csv",
                            true));

                    bw.write(username + "," + date + "," + mk + "," + mo + "," + yr + "\n");
                    bw.close();
                } else {
                    //display a jpane that tells them they could not enter that car b/c it was empty
                    log.log(Level.SEVERE,"Active rental could not be written to Database b/c fields were left empty");
                }
            }catch(IOException ex) {
                ex.printStackTrace();
                log.log(Level.SEVERE,"Active rental could not be written to Database");
            }
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