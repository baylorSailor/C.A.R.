import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AccountDetails extends JFrame {

    JPanel pnMainPanel;

    JPanel pnHistory;
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

        pnHistory = new JPanel();
        pnHistory.setBorder( BorderFactory.createTitledBorder( "AccountDetails" ) );
        GridBagLayout gbHistory = new GridBagLayout();
        GridBagConstraints gbcHistory = new GridBagConstraints();
        pnHistory.setLayout( gbHistory );

        lbName = new JLabel( "Name: " + UIDemo.user.getName());
        gbcHistory.gridx = 2;
        gbcHistory.gridy = 7;
        gbcHistory.gridwidth = 1;
        gbcHistory.gridheight = 1;
        gbcHistory.fill = GridBagConstraints.HORIZONTAL;
        gbcHistory.weightx = 1;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.NORTH;
        gbHistory.setConstraints( lbName, gbcHistory );
        pnHistory.add( lbName );

        lbUsername = new JLabel( "Username: " + UIDemo.user.getUsername());
        gbcHistory.gridx = 2;
        gbcHistory.gridy = 9;
        gbcHistory.gridwidth = 1;
        gbcHistory.gridheight = 1;
        gbcHistory.fill = GridBagConstraints.HORIZONTAL;
        gbcHistory.weightx = 1;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.NORTH;
        gbHistory.setConstraints( lbUsername, gbcHistory );
        pnHistory.add( lbUsername );

        lbEmail = new JLabel( "Email: " + UIDemo.user.getEmail());
        gbcHistory.gridx = 2;
        gbcHistory.gridy = 11;
        gbcHistory.gridwidth = 1;
        gbcHistory.gridheight = 1;
        gbcHistory.fill = GridBagConstraints.HORIZONTAL;
        gbcHistory.weightx = 1;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.NORTH;
        gbHistory.setConstraints( lbEmail, gbcHistory );
        pnHistory.add( lbEmail );

        lbCreditCardType = new JLabel( "Credit Card Type: " + UIDemo.user.getCreditType());
        gbcHistory.gridx = 2;
        gbcHistory.gridy = 13;
        gbcHistory.gridwidth = 1;
        gbcHistory.gridheight = 1;
        gbcHistory.fill = GridBagConstraints.HORIZONTAL;
        gbcHistory.weightx = 1;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.NORTH;
        gbHistory.setConstraints( lbCreditCardType, gbcHistory );
        pnHistory.add( lbCreditCardType );

        lbLabel8 = new JLabel( "Picture"  ); // TODO Add Picture
        gbcHistory.gridx = 7;
        gbcHistory.gridy = 3;
        gbcHistory.gridwidth = 1;
        gbcHistory.gridheight = 1;
        gbcHistory.fill = GridBagConstraints.HORIZONTAL;
        gbcHistory.weightx = 1;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.CENTER;
        gbHistory.setConstraints( lbLabel8, gbcHistory );
        pnHistory.add( lbLabel8 );
        JScrollPane scpHistory = new JScrollPane( pnHistory );
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
                //TODO Save session & Sign user out
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
