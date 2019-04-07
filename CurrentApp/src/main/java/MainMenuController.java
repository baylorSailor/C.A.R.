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
    }

    private void refreshButtonPressed() {
        mainMenuView.getBtRefresh().addActionListener(e -> {

        });
    }

    private void historyButtonPressed() {
        mainMenuView.getBtHistory().addActionListener(e -> {
            if(historyView == null) {
                historyView = new HistoryView();
            }
            historyView.setVisible(true);
        });
    }

    private void activeRentalsButtonPressed() {
        mainMenuView.getBtActiveRentals().addActionListener(e -> {
            if(activeRentalsView == null) {
                activeRentalsView = new ActiveRentalsView();
            }
            activeRentalsView.setVisible(true);
        });
    }

    private void accountDetailsButtonPressed() {
        mainMenuView.getBtAccountDetails().addActionListener(e -> {
            if(accountDetailsView == null) {
                accountDetailsView = new AccountDetailsView();
            }
            accountDetailsView.setVisible(true);
        });
    }
}
