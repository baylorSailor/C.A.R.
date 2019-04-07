import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

class MainMenuView extends JFrame {
    //TODO Fix layout of buttons in layout
    private JPanel pnMainPanel;

    private JPanel pnSearchResults;
    private JButton btRefresh;
    private JButton btHistory;
    private JButton btActiveRentals;
    private JButton btAccountDetails;
    private JButton btLogout;
    private JLabel lbLoggedInAs;
    private JLabel lbFilters;
    private JLabel lbMake;
    private JLabel lbModel;
    private JLabel lbYear;
    private JLabel lbType;
    private JLabel lbTrans;
    private JLabel lbMileage;
    private JLabel lbMPG;
    private JLabel lbInterior;
    private JLabel lbExterior;
    private JLabel lbPicture;
    private JComboBox cmbYear;
    private JComboBox cmbMake;
    private JComboBox cmbModel;
    private JComboBox cmbType;
    private JComboBox cmbTrans;
    private JSlider sdMileage;
    private JSlider sdMPG;
    private JComboBox cmbInterior;
    private JComboBox cmbExterior;

    public MainMenuView() {
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

        lbLoggedInAs = new JLabel( "User: " + UserController.getUser().getUsername() );
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
        btRefresh.addActionListener(e -> {
            //TODO refresh button
        });

        btHistory = new JButton( "History"  );
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
//        btHistory.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(Driver.history == null) {
//                    Driver.history = new History();
//                } else {
//                    Driver.history.setVisible(true);
//                }
//                setVisible(false);
//            }
//        });

        btActiveRentals = new JButton( "Active Rentals"  );
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
//        btActiveRentals.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(Driver.activeRentals == null) {
//                    Driver.activeRentals = new ActiveRentals();
//                } else {
//                    Driver.activeRentals.setVisible(true);
//                }
//                setVisible(false);
//            }
//        });

        btAccountDetails = new JButton( "Account Details"  );
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
//        btAccountDetails.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(Driver.accountDetails == null) {
//                    Driver.accountDetails = new AccountDetails();
//                } else {
//                    Driver.accountDetails.setVisible(true);
//                }
//                setVisible(false);
//            }
//        });

        btLogout = new JButton( "Logout"  );
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
//        btLogout.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Driver.destroyPanes();
//                //Driver.login.setVisible(true);
//                setVisible(false);
//            }
//        });

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
        cmbMake.addActionListener(e -> {
            String temp = (String) cmbMake.getSelectedItem();

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

    public JPanel getPnMainPanel() {
        return pnMainPanel;
    }

    public void setPnMainPanel(JPanel pnMainPanel) {
        this.pnMainPanel = pnMainPanel;
    }

    public JPanel getPnSearchResults() {
        return pnSearchResults;
    }

    public void setPnSearchResults(JPanel pnSearchResults) {
        this.pnSearchResults = pnSearchResults;
    }

    public JButton getBtRefresh() {
        return btRefresh;
    }

    public void setBtRefresh(JButton btRefresh) {
        this.btRefresh = btRefresh;
    }

    public JButton getBtHistory() {
        return btHistory;
    }

    public void setBtHistory(JButton btHistory) {
        this.btHistory = btHistory;
    }

    public JButton getBtActiveRentals() {
        return btActiveRentals;
    }

    public void setBtActiveRentals(JButton btActiveRentals) {
        this.btActiveRentals = btActiveRentals;
    }

    public JButton getBtAccountDetails() {
        return btAccountDetails;
    }

    public void setBtAccountDetails(JButton btAccountDetails) {
        this.btAccountDetails = btAccountDetails;
    }

    public JButton getBtLogout() {
        return btLogout;
    }

    public void setBtLogout(JButton btLogout) {
        this.btLogout = btLogout;
    }

    public JLabel getLbLoggedInAs() {
        return lbLoggedInAs;
    }

    public void setLbLoggedInAs(JLabel lbLoggedInAs) {
        this.lbLoggedInAs = lbLoggedInAs;
    }

    public JLabel getLbFilters() {
        return lbFilters;
    }

    public void setLbFilters(JLabel lbFilters) {
        this.lbFilters = lbFilters;
    }

    public JLabel getLbMake() {
        return lbMake;
    }

    public void setLbMake(JLabel lbMake) {
        this.lbMake = lbMake;
    }

    public JLabel getLbModel() {
        return lbModel;
    }

    public void setLbModel(JLabel lbModel) {
        this.lbModel = lbModel;
    }

    public JLabel getLbYear() {
        return lbYear;
    }

    public void setLbYear(JLabel lbYear) {
        this.lbYear = lbYear;
    }

    public JLabel getLbType() {
        return lbType;
    }

    public void setLbType(JLabel lbType) {
        this.lbType = lbType;
    }

    public JLabel getLbTrans() {
        return lbTrans;
    }

    public void setLbTrans(JLabel lbTrans) {
        this.lbTrans = lbTrans;
    }

    public JLabel getLbMileage() {
        return lbMileage;
    }

    public void setLbMileage(JLabel lbMileage) {
        this.lbMileage = lbMileage;
    }

    public JLabel getLbMPG() {
        return lbMPG;
    }

    public void setLbMPG(JLabel lbMPG) {
        this.lbMPG = lbMPG;
    }

    public JLabel getLbInterior() {
        return lbInterior;
    }

    public void setLbInterior(JLabel lbInterior) {
        this.lbInterior = lbInterior;
    }

    public JLabel getLbExterior() {
        return lbExterior;
    }

    public void setLbExterior(JLabel lbExterior) {
        this.lbExterior = lbExterior;
    }

    public JLabel getLbPicture() {
        return lbPicture;
    }

    public void setLbPicture(JLabel lbPicture) {
        this.lbPicture = lbPicture;
    }

    public JComboBox getCmbYear() {
        return cmbYear;
    }

    public void setCmbYear(JComboBox cmbYear) {
        this.cmbYear = cmbYear;
    }

    public JComboBox getCmbMake() {
        return cmbMake;
    }

    public void setCmbMake(JComboBox cmbMake) {
        this.cmbMake = cmbMake;
    }

    public JComboBox getCmbModel() {
        return cmbModel;
    }

    public void setCmbModel(JComboBox cmbModel) {
        this.cmbModel = cmbModel;
    }

    public JComboBox getCmbType() {
        return cmbType;
    }

    public void setCmbType(JComboBox cmbType) {
        this.cmbType = cmbType;
    }

    public JComboBox getCmbTrans() {
        return cmbTrans;
    }

    public void setCmbTrans(JComboBox cmbTrans) {
        this.cmbTrans = cmbTrans;
    }

    public JSlider getSdMileage() {
        return sdMileage;
    }

    public void setSdMileage(JSlider sdMileage) {
        this.sdMileage = sdMileage;
    }

    public JSlider getSdMPG() {
        return sdMPG;
    }

    public void setSdMPG(JSlider sdMPG) {
        this.sdMPG = sdMPG;
    }

    public JComboBox getCmbInterior() {
        return cmbInterior;
    }

    public void setCmbInterior(JComboBox cmbInterior) {
        this.cmbInterior = cmbInterior;
    }

    public JComboBox getCmbExterior() {
        return cmbExterior;
    }

    public void setCmbExterior(JComboBox cmbExterior) {
        this.cmbExterior = cmbExterior;
    }
}
