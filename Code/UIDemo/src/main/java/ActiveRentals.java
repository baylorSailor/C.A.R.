import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ActiveRentals extends JFrame {

    JPanel pnMainPanel;

    JPanel pnHistory;
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

        pnHistory = new JPanel();
        pnHistory.setBorder( BorderFactory.createTitledBorder( "History" ) );
        GridBagLayout gbHistory = new GridBagLayout();
        GridBagConstraints gbcHistory = new GridBagConstraints();
        pnHistory.setLayout( gbHistory );

        String [][]dataHTable = new String[][] { new String[] {"11", "21"},
                new String[] {"12", "22"},
                new String[] {"13", "23"} };
        String []colsHTable = new String[] { "", "" };
        tbHTable = new JTable( dataHTable, colsHTable );
        tbHTable.setSelectionBackground( new Color( 212,212,212 ) );
        tbHTable.setSelectionForeground( new Color( 0,0,0 ) );
        JScrollPane scpHTable = new JScrollPane( tbHTable );
        gbcHistory.gridx = 0;
        gbcHistory.gridy = 0;
        gbcHistory.gridwidth = 15;
        gbcHistory.gridheight = 10;
        gbcHistory.fill = GridBagConstraints.BOTH;
        gbcHistory.weightx = 0;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.CENTER;
        gbHistory.setConstraints( scpHTable, gbcHistory );
        pnHistory.add( scpHTable );
        JScrollPane scpHistory = new JScrollPane( pnHistory );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 19;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpHistory, gbcMainPanel );
        pnMainPanel.add( scpHistory );

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
                //TODO Implement this
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
