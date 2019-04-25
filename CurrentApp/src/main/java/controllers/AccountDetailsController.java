package controllers;

import main.CAR;
import views.AccountDetailsView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for the account details view
 */
public class AccountDetailsController {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private AccountDetailsView accountDetailsView = null;

    /**
     * Constructs the account details view if not null
     */
    public AccountDetailsController() {
        if(accountDetailsView == null) {
            log.log(Level.INFO,"AccountDetails Controller & View has been created");
            accountDetailsView = new AccountDetailsView();

            accountDetailsView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    log.log(Level.INFO,"AccountDetails View has been disposed of");
                    accountDetailsView.dispose();
                    accountDetailsView = null;
                }
            });
        }
    }

    /**
     * Ensures that the view is disposed of if Logout button is clicked
     */
    public void destroy() {
        log.log(Level.INFO,"AccountDetails Controller & View has been destroyed");
        if(accountDetailsView != null) {
            accountDetailsView.dispose();
            accountDetailsView = null;
        }
    }
}
