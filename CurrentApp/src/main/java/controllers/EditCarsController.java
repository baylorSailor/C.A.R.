package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import models.EditCarsTableModel;
import views.EditCarsView;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller class for the EditCars Table
 */
public class EditCarsController {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private EditCarsTableModel model = null;
    private JTable jtCars = null;
    private EditCarsView editCarsView = null;

    /**
     * Reads in cars from the database
     */
    public void start() {
        model = new EditCarsTableModel(DatabaseAdapter.readInCars());
        jtCars = new JTable(model);
        editCarsView = new EditCarsView(jtCars);

        saveButtonPressed();
        addCarButtonPressed();
        removeCarButtonPressed();
    }

    /**
     * Save button pressed status
     */
    private void saveButtonPressed() {
        editCarsView.getBtSave().addActionListener(e -> {
            log.log(Level.INFO,"Save button clicked");
            DatabaseAdapter.writeAllCars(model.getRows());
        });
    }

    /**
     * Add car button pressed status
     */
    private void addCarButtonPressed() {
        editCarsView.getBtAddRow().addActionListener(e -> {
            log.log(Level.INFO,"Add Car button clicked");
            model.addRow();
        });
    }

    /**
     * Remove car button pressed status
     */
    private void removeCarButtonPressed() {
        editCarsView.getBtRemoveRow().addActionListener(e -> {
            log.log(Level.INFO,"Remove Car button clicked");
            if(jtCars.getSelectedRow() > -1) {
                model.delRow(jtCars.getSelectedRow());
            }
        });
    }

    /**
     * Ensures that the view is disposed of if Logout button is clicked
     */
    public void destroy() {
        log.log(Level.INFO,"Edit Cars Controller has been destroyed");
        if(editCarsView != null) {
            editCarsView.dispose();
            editCarsView = null;
        }
    }
}
