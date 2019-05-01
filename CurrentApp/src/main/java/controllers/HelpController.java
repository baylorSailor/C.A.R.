package controllers;

import adapters.DatabaseAdapter;
import main.CAR;
import views.HelpView;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller class for the Help Menu
 */
public class HelpController {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private HelpView helpView = null;

    /**
     * Shows the help menu for the user
     */
    public void start() {
        helpView = new HelpView();

        submitButtonPressed();
    }

    /**
     * Submit button pressed status
     */
    private void submitButtonPressed() {
        helpView.getBtSubmit().addActionListener(e -> {
            log.log(Level.INFO,"Submit button clicked");
            DatabaseAdapter.writeComments(helpView.getTextArea().getText());
            this.destroy();
            JOptionPane.showMessageDialog(null,"Thank you for your feedback!",
                    "Feedback Saved",JOptionPane.INFORMATION_MESSAGE,DatabaseAdapter.getIcon());
        });
    }

    /**
     * Ensures that the view is disposed of if Logout button is clicked
     */
    public void destroy() {
        log.log(Level.INFO,"Help View has been destroyed");
        if(helpView != null) {
            helpView.dispose();
            helpView = null;
        }
    }
}
