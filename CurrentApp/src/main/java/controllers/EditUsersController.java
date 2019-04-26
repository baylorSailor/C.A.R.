package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import models.EditUsersTableModel;
import models.UserModel;
import views.EditUsersView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditUsersController {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private EditUsersView editUsersView = null;
    private ArrayList<UserModel> userModelArrayList = null;
    private EditUsersTableModel model = null;
    private JTable jtUsers = null;

    public void start() {
        userModelArrayList=  DatabaseAdapter.readInUsers();

        model = new EditUsersTableModel(userModelArrayList);
        jtUsers = new JTable(model);

        editUsersView = new EditUsersView(jtUsers);

        saveButtonPressed();
    }

    private void saveButtonPressed() {
        editUsersView.getBtSave().addActionListener(e -> {
            log.log(Level.INFO,"Save button clicked");
            DatabaseAdapter.writeAllUsers(userModelArrayList);
        });
    }
}
