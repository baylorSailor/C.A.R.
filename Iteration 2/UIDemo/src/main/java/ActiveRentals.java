import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActiveRentals extends JFrame {

    JPanel pnMainPanel;

    JPanel pnActiveRentals;
    JTable tbHTable;
    JButton btSearch;
    JButton btHistory;
    JButton btLogout;
    JButton btAccountDetails;

    public ActiveRentals() {
        super( "View Active Rentals" );

        pnMainPanel = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnMainPanel.setLayout( gbMainPanel );

        pnActiveRentals = new JPanel();
        pnActiveRentals.setBorder( BorderFactory.createTitledBorder( "Active Rentals" ) );
        GridBagLayout gbActiveRentals = new GridBagLayout();
        GridBagConstraints gbcActiveRentals = new GridBagConstraints();
        pnActiveRentals.setLayout( gbActiveRentals );

        String [][]dataHTable = new String[][] { new String[] {"No Active Rentals", " "} };
        String []colsHTable = new String[] { "", "" };
        tbHTable = new JTable( dataHTable, colsHTable );
        tbHTable.setSelectionBackground( new Color( 212,212,212 ) );
        tbHTable.setSelectionForeground( new Color( 0,0,0 ) );
        JScrollPane scpHTable = new JScrollPane( tbHTable );
        gbcActiveRentals.gridx = 0;
        gbcActiveRentals.gridy = 0;
        gbcActiveRentals.gridwidth = 15;
        gbcActiveRentals.gridheight = 10;
        gbcActiveRentals.fill = GridBagConstraints.BOTH;
        gbcActiveRentals.weightx = 0;
        gbcActiveRentals.weighty = 0;
        gbcActiveRentals.anchor = GridBagConstraints.CENTER;
        gbActiveRentals.setConstraints( scpHTable, gbcActiveRentals );
        pnActiveRentals.add( scpHTable );
        JScrollPane scpActiveRentals = new JScrollPane( pnActiveRentals );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 19;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpActiveRentals, gbcMainPanel );
        pnMainPanel.add( scpActiveRentals );

        btSearch = new JButton( "Search"  );
        //btSearch.setActionCommand( "search" );
        gbcMainPanel.gridx = 8;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
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
                UIDemo.listings.setVisible(true);
                setVisible(false);
            }
        });

        btHistory = new JButton( "History"  );
        //btHistory.setActionCommand( "history" );
        gbcMainPanel.gridx = 10;
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

        btAccountDetails = new JButton( "Account Details"  );
        //btAccountDetails.setActionCommand( "account" );
        gbcMainPanel.gridx = 12;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btAccountDetails, gbcMainPanel );
        pnMainPanel.add( btAccountDetails );
        btAccountDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(UIDemo.accountDetails == null) {
                    UIDemo.accountDetails = new AccountDetails();
                } else {
                    UIDemo.accountDetails.setVisible(true);
                }
                setVisible(false);
            }
        });

        btLogout = new JButton( "Logout"  );
        //btAccountDetails.setActionCommand( "account" );
        gbcMainPanel.gridx = 14;
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
