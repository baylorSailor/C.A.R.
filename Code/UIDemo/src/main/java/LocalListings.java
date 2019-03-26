import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UID;

public class LocalListings extends JFrame {

    JPanel pnMainPanel;

    JPanel pnSearchResults;
    JButton btSearch;
    JButton btHistory;
    JButton btActiveRentals;
    JButton btAccountDetails;
    JButton btLogout;
    JLabel lbLoggedInAs;
    JLabel lbFilters;
    JLabel lbMake;
    JLabel lbModel;
    JLabel lbYear;
    JLabel lbType;
    JLabel lbTrans;
    JLabel lbMileage;
    JLabel lbMPG;
    JLabel lbInterior;
    JLabel lbExterior;
    JComboBox cmbYear;
    JComboBox cmbMake;
    JComboBox cmbModel;
    JComboBox cmbType;
    JComboBox cmbTrans;
    JSlider sdMileage;
    JSlider sdMPG;
    JComboBox cmbInterior;
    JComboBox cmbExterior;

    public LocalListings() {
        super( "View Local Listings");

        pnMainPanel = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnMainPanel.setLayout( gbMainPanel );

        pnSearchResults = new JPanel();
        pnSearchResults.setBorder( BorderFactory.createTitledBorder( "Results" ) );
        GridBagLayout gbSearchResults = new GridBagLayout();
        GridBagConstraints gbcSearchResults = new GridBagConstraints();
        pnSearchResults.setLayout( gbSearchResults );
        JScrollPane scpSearchResults = new JScrollPane( pnSearchResults );
        gbcMainPanel.gridx = 6;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 14;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpSearchResults, gbcMainPanel );
        pnMainPanel.add( scpSearchResults );


        String user = UIDemo.login.tfUser.getText();
        lbLoggedInAs = new JLabel( "User: " + user );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 1;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbLoggedInAs, gbcMainPanel );
        pnMainPanel.add( lbLoggedInAs );

        btSearch = new JButton( "Refresh"  );
        //btSearch.setActionCommand( "search" );
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
                //TODO Implement
            }
        });

        btHistory = new JButton( "History"  );
        //btHistory.setActionCommand( "history" );
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
        //btActiveRentals.setActionCommand( "active" );
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

        btAccountDetails = new JButton( "Account Details"  );
        //btAccountDetails.setActionCommand( "account" );
        gbcMainPanel.gridx = 16;
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
        gbcMainPanel.gridx = 18;
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

        lbFilters = new JLabel( "Search Filters"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 1;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbFilters, gbcMainPanel );
        pnMainPanel.add( lbFilters );

        lbMake = new JLabel( "Make:"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 12;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( lbMake, gbcMainPanel );
        pnMainPanel.add( lbMake );

        String []dataMake = { "Dodge", "Chrysler", "Chevy" };
        cmbMake = new JComboBox( dataMake );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 12;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbMake, gbcMainPanel );
        pnMainPanel.add( cmbMake );

        lbModel = new JLabel( "Model:"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 13;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( lbModel, gbcMainPanel );
        pnMainPanel.add( lbModel );

        String []dataModel = { "Avenger", "200", "Cruze" };
        cmbModel = new JComboBox( dataModel );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 13;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbModel, gbcMainPanel );
        pnMainPanel.add( cmbModel );

        lbYear = new JLabel( "Year:"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 14;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( lbYear, gbcMainPanel );
        pnMainPanel.add( lbYear );

        String []dataYear = { "2000", "2001", "2002" };
        cmbYear = new JComboBox( dataYear );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 14;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbYear, gbcMainPanel );
        pnMainPanel.add( cmbYear );

        lbType = new JLabel( "Type:"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 15;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( lbType, gbcMainPanel );
        pnMainPanel.add( lbType );

        String []dataType = { "Sedan", "SUV", "Coupe" };
        cmbType = new JComboBox( dataType );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 15;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbType, gbcMainPanel );
        pnMainPanel.add( cmbType );

        lbTrans = new JLabel( "Transmission:"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 16;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( lbTrans, gbcMainPanel );
        pnMainPanel.add( lbTrans );

        String []dataTrans = { "Sedan", "SUV", "Coupe" };
        cmbTrans = new JComboBox( dataTrans );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 16;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbTrans, gbcMainPanel );
        pnMainPanel.add( cmbTrans );

        lbMileage = new JLabel( "Mileage"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 17;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbMileage, gbcMainPanel );
        pnMainPanel.add( lbMileage );

        sdMileage = new JSlider( );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 17;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( sdMileage, gbcMainPanel );
        pnMainPanel.add( sdMileage );

        lbMPG = new JLabel( "MPG (Average)"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 18;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbMPG, gbcMainPanel );
        pnMainPanel.add( lbMPG );

        sdMPG = new JSlider( );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 18;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( sdMPG, gbcMainPanel );
        pnMainPanel.add( sdMPG );

        lbInterior = new JLabel( "Interior Color"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 19;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbInterior, gbcMainPanel );
        pnMainPanel.add( lbInterior );

        String []dataInterior = { "Black", "Red", "Beige" };
        cmbInterior = new JComboBox( dataInterior );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 19;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbInterior, gbcMainPanel );
        pnMainPanel.add( cmbInterior );

        lbExterior = new JLabel( "Exterior Color"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 20;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbExterior, gbcMainPanel );
        pnMainPanel.add( lbExterior );

        String []dataExterior = { "Black", "Red", "Yellow" };
        cmbExterior = new JComboBox( dataExterior );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 20;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbExterior, gbcMainPanel );
        pnMainPanel.add( cmbExterior );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnMainPanel );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }
} 
