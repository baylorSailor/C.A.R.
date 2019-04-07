import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MainMenuController {
    private MainMenuView mainMenuView = new MainMenuView();
    private HistoryView historyView = null;
    private ActiveRentalsView activeRentalsView = null;
    private AccountDetailsView accountDetailsView = null;

    public void start() {
        refreshButtonPressed();
        historyButtonPressed();
        activeRentalsButtonPressed();
        accountDetailsButtonPressed();
        logoutButtonPressed();
    }

    private void refreshButtonPressed() {
        mainMenuView.getBtRefresh().addActionListener(e -> {

        });
    }

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
}
