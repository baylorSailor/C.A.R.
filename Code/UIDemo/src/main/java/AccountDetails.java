import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountDetails extends JFrame {

    JPanel pnMainPanel;

    JPanel pnAccountDetails;
    JLabel lbName;
    JLabel lbUsername;
    JLabel lbEmail;
    JLabel lbCreditCardType;
    JLabel lbLabel8;
    JButton btSearch;
    JButton btHistory;
    JButton btActiveRentals;
    JButton btLogout;

    public AccountDetails() {
        super( "View Account Details" );

        pnMainPanel = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnMainPanel.setLayout( gbMainPanel );

        pnAccountDetails = new JPanel();
        pnAccountDetails.setBorder( BorderFactory.createTitledBorder( "AccountDetails" ) );
        GridBagLayout gbAccountDetails = new GridBagLayout();
        GridBagConstraints gbcAccountDetails = new GridBagConstraints();
        pnAccountDetails.setLayout( gbAccountDetails );

        lbName = new JLabel( "Name: " + UIDemo.user.getName());
        gbcAccountDetails.gridx = 2;
        gbcAccountDetails.gridy = 7;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbName, gbcAccountDetails );
        pnAccountDetails.add( lbName );

        lbUsername = new JLabel( "Username: " + UIDemo.user.getUsername());
        gbcAccountDetails.gridx = 2;
        gbcAccountDetails.gridy = 9;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbUsername, gbcAccountDetails );
        pnAccountDetails.add( lbUsername );

        lbEmail = new JLabel( "Email: " + UIDemo.user.getEmail());
        gbcAccountDetails.gridx = 2;
        gbcAccountDetails.gridy = 11;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbEmail, gbcAccountDetails );
        pnAccountDetails.add( lbEmail );

        lbCreditCardType = new JLabel( "Credit Card Type: " + UIDemo.user.getCreditType());
        gbcAccountDetails.gridx = 2;
        gbcAccountDetails.gridy = 13;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbCreditCardType, gbcAccountDetails );
        pnAccountDetails.add( lbCreditCardType );

        lbLabel8 = new JLabel( "Picture"  ); // TODO Add Picture
        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 3;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.CENTER;
        gbAccountDetails.setConstraints( lbLabel8, gbcAccountDetails );
        pnAccountDetails.add( lbLabel8 );
        
        JScrollPane scpHistory = new JScrollPane( pnAccountDetails );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 19;
        gbcMainPanel.gridheight = 15;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpHistory, gbcMainPanel );
        pnMainPanel.add( scpHistory );

        btSearch = new JButton( "Search"  );
        gbcMainPanel.gridx = 8;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 4;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btSearch, gbcMainPanel );
        pnMainPanel.add( btSearch );
        btSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(UIDemo.listings == null) {
                    UIDemo.listings = new LocalListings();
                } else {
                    UIDemo.listings.setVisible(true);
                }
                setVisible(false);
            }
        });

        btHistory = new JButton( "History"  );
        gbcMainPanel.gridx = 12;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btHistory, gbcMainPanel );
        pnMainPanel.add( btHistory );
        btHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(UIDemo.history == null) {
                    UIDemo.history = new History();
                } else {
                    UIDemo.history.setVisible(true);
                }
                setVisible(false);
            }
        });

        btActiveRentals = new JButton( "Active Rentals"  );
        btActiveRentals.setActionCommand( "History" );
        gbcMainPanel.gridx = 14;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btActiveRentals, gbcMainPanel );
        pnMainPanel.add( btActiveRentals );
        btActiveRentals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(UIDemo.activeRentals == null) {
                    UIDemo.activeRentals = new ActiveRentals();
                } else {
                    UIDemo.activeRentals.setVisible(true);
                }
                setVisible(false);
            }
        });

        btLogout = new JButton( "Logout"  );
        //btAccountDetails.setActionCommand( "account" );
        gbcMainPanel.gridx = 16;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btLogout, gbcMainPanel );
        pnMainPanel.add( btLogout );
        btLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIDemo.destroyPanes();
                UIDemo.login.setVisible(true);
                setVisible(false);
            }
        });

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnMainPanel );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }
}
