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
    private EditCarsView editCarsView = null;
    private EditCarsTableModel model = null;
    private JTable jtCars = null;

    /**
     * Reads in cars from the database
     */
    public void start() {
        model = new EditCarsTableModel(DatabaseAdapter.readInCars());
        jtCars = new JTable(model);
        editCarsView = new EditCarsView(jtCars);

        saveButtonPressed();
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
}
