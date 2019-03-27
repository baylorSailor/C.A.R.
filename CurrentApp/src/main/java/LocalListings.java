import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LocalListings extends JFrame {
    //TODO Fix layout of buttons in layout
    JPanel pnMainPanel;

    JPanel pnSearchResults;
    JButton btRefresh;
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
    JLabel lbPicture;
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

        JLabel test = new JLabel( "<html>Make: Dodge<br/>Model: Avenger<br/>Year: 2000<br/>Type: Sedan<br/>" +
                "Transmission: Automatic 6-spd"  +
                "&#160 &#160 &#160 &#160 &#160 &#160" + // Add spacing
                "<br/>Miles: 88,278<br/>Avg MPG: 24<br/>Interior: Black<br/>Exterior: Black</html>" );
        gbcSearchResults.gridx = 0;
        gbcSearchResults.gridy = 5;
        gbcSearchResults.gridwidth = 1;
        gbcSearchResults.gridheight = 1;
        gbcSearchResults.fill = GridBagConstraints.NONE;
        test.setHorizontalAlignment(SwingConstants.LEFT);
        gbcSearchResults.weightx = 0;
        gbcSearchResults.weighty = 0;
        gbcSearchResults.anchor = GridBagConstraints.WEST;
        gbMainPanel.setConstraints( test, gbcSearchResults );
        pnSearchResults.add( test );

        BufferedImage picture = null;
        try {
            picture = ImageIO.read(new File("./src/main/resources/sample_car.png"));

        } catch(IOException e) {
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample_car.png"));
            } catch(IOException ee) {
                //TODO add logger to catch this
            }

        } finally {
            lbPicture = new JLabel(new ImageIcon(picture));
            gbcSearchResults.gridx = 13;
            gbcSearchResults.gridy = 5;
            gbcSearchResults.gridwidth = 1;
            gbcSearchResults.gridheight = 1;
            gbcSearchResults.fill = GridBagConstraints.NONE;
            test.setHorizontalAlignment(SwingConstants.RIGHT);
            gbcSearchResults.weightx = 0;
            gbcSearchResults.weighty = 0;
            gbcSearchResults.anchor = GridBagConstraints.EAST;
            gbMainPanel.setConstraints( lbPicture, gbcSearchResults );
            pnSearchResults.add(lbPicture);
        }

        String user = CurrentApp.login.tfUser.getText();
        lbLoggedInAs = new JLabel( "User: " + user );
        Font f = lbLoggedInAs.getFont();
        lbLoggedInAs.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
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

        btRefresh = new JButton( "Refresh"  );
        //btSearch.setActionCommand( "search" );
        gbcMainPanel.gridx = 8;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btRefresh, gbcMainPanel );
        pnMainPanel.add( btRefresh );
        getRootPane().setDefaultButton(btRefresh);
        btRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO refresh button
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
                if(CurrentApp.history == null) {
                    CurrentApp.history = new History();
                } else {
                    CurrentApp.history.setVisible(true);
                }
                setVisible(false);
            }
        });

        btActiveRentals = new JButton( "Active Rentals"  );
        //btActiveRentals.setActionCommand( "active" );
        gbcMainPanel.gridx = 12;
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
                if(CurrentApp.activeRentals == null) {
                    CurrentApp.activeRentals = new ActiveRentals();
                } else {
                    CurrentApp.activeRentals.setVisible(true);
                }
                setVisible(false);
            }
        });

        btAccountDetails = new JButton( "Account Details"  );
        //btAccountDetails.setActionCommand( "account" );
        gbcMainPanel.gridx = 14;
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
                if(CurrentApp.accountDetails == null) {
                    CurrentApp.accountDetails = new AccountDetails();
                } else {
                    CurrentApp.accountDetails.setVisible(true);
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
                CurrentApp.destroyPanes();
                CurrentApp.login.setVisible(true);
                setVisible(false);
            }
        });

        lbFilters = new JLabel( "Search Filters"  );
        f = lbFilters.getFont();
        Map attributes = f.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lbFilters.setFont(f.deriveFont(attributes));
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH; //Vertical for Centering
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 1;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
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

        //TODO Vehicle class needed
        String []dataMake = { "Dodge", "Chrysler", "Chevy", "BMW" };
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
        cmbMake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = (String) cmbMake.getSelectedItem();

            }
        });

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

        String []dataTrans = { "Automatic 6-spd", "Automatic 5-spd", "Manual 6-spd" };
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
