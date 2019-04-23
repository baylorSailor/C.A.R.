package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import models.UserModel;
import views.CreateAccountView;
import views.LoginView;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Controller for the user object
 */
public class UserController {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    static UserModel user = null;
    private LoginView loginView = new LoginView();
    private MainMenuController mainMenuController = null;
    private CreateAccountView createAccountView = null;

    /**
     * Controller for the login and create account buttons
     */
    public void start() {
        loginButtonPressed();
        createAccountButtonPressed();
    }

    /**
     * Get the user
     * @return A user in the system
     */
    public static UserModel getUser() {
        return user;
    }

    /**
     * Remove the login window and start the main screen
     */
    private void removeAllFramesAndStart() {
        loginView.dispose();
        loginView = null;
        if(createAccountView != null) {
            createAccountView.dispose();
            createAccountView = null;
        }
        mainMenuController = new MainMenuController();
        mainMenuController.start();
    }

    /**
     * Add action listener for login button
     */
    private void loginButtonPressed() {
        loginView.getBtLogin().addActionListener(e -> {
            log.log(Level.INFO,"Login button clicked");
            if((user = DatabaseAdapter.verifyUser(loginView.getTfUser().getText(),
                                                                        loginView.getTfPass().getText())) != null) {
                removeAllFramesAndStart();
            } else {
                loginView.getLbError().setText("Incorrect username or password.");
            }
        });
    }

    /**
     * Add action listener for create account button
     */
    private void createAccountButtonPressed() {
        loginView.getBtCreateAcct().addActionListener(e -> {
            log.log(Level.INFO,"Create account button clicked");
            createAccountView = new CreateAccountView();

            createAccountView.getBtAddImage().addActionListener(createAccountView::AddImage);

            createAccountView.getBtCreateAcct().addActionListener(e1 -> {
                if(DatabaseAdapter.userExists(createAccountView.getTfEmail().getText())) {
                    createAccountView.setErrorLabelMessage("Account already exists.");
                } else {
                    String creditType;
                    File file = new File("./src/main/resources/Users.csv");
                    if(createAccountView.allFieldsEntered()) {
                        if(createAccountView.getRbVisa().isSelected()) {
                            creditType = "Visa";
                        } else {
                            creditType = "MasterCard";
                        }
                        user = new UserModel(createAccountView.getTfFirstName().getText() +
                                createAccountView.getTfLastName().getText(),createAccountView.getTfUserName().getText(),
                                createAccountView.getTfEmail().getText(),createAccountView.getTfPassword().getText(),
                                creditType,createAccountView.getTfCreditCardNumber().getText());

                        if(file.exists()) {
                            DatabaseAdapter.writeUser(user);
                            DatabaseAdapter.saveImage(user);
                        } else {
                            log.log(Level.SEVERE,"Users.csv was not found");
                        }
                        removeAllFramesAndStart();
                    } else {
                        String message = "1. No fields may be left empty.\n" +
                                "2. Password must be 7 or more characters.\n" +
                                "3. Image is preferred, but no image is required.\n" +
                                "4. Passwords must match.";
                        JOptionPane.showMessageDialog(null, message,
                                "Required Account Information", JOptionPane.WARNING_MESSAGE);
                    }
                }

            });
        });
    }
}
