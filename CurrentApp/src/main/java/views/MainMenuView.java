/**
 * Main Menu view for the app.
 */

package views;

import controllers.UserController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Window for the main screen
 */
public class MainMenuView extends JFrame {
    private JPanel pnMainPanel;

    private JPanel pnSearchResults;
    private JButton btRefresh;
    private JButton btHistory;
    private JButton btActiveRentals;
    private JButton btAccountDetails;
    private JButton btLogout;
    private JButton btAddRental;
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

    /**
     * Constructs main window screen
     */
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

        //Test label in the main window
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

        //User displayed
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

        //Refresh Button
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

        //History Button
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

        //Active Rental Button
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

        //Account Details Button
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

        //Logout Button
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

        //Search Filters display
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

        //Make options
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

        //Model Options
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

        //Year options
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

        //Type options
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

        //Transmission options
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

        //Mileage slider
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

        //MPG slider
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

        //Interior color options
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

        //Exterior color options
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

        //Add to rental button
        btAddRental = new JButton( "Add Rental"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 22;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btAddRental, gbcMainPanel );
        pnMainPanel.add( btAddRental );
        getRootPane().setDefaultButton(btAddRental);

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnMainPanel );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    /**
     * Button for refreshing the display
     * @return A button for refreshing the page
     */
    public JButton getBtRefresh() {
        return btRefresh;
    }

    /**
     * Button for getting the history
     * @return A button for rental history
     */
    public JButton getBtHistory() {
        return btHistory;
    }

    /**
     * Button for active rentals
     * @return A button for active rentals
     */
    public JButton getBtActiveRentals() {
        return btActiveRentals;
    }

    /**
     * Button for account details
     * @return A button for account details
     */
    public JButton getBtAccountDetails() {
        return btAccountDetails;
    }

    /**
     * Button for logout
     * @return A button for logging out
     */
    public JButton getBtLogout() {
        return btLogout;
    }

    /**
     * Button for add rental
     * @return A button for adding the rental car
     */
    public JButton getBtAddRental(){ return btAddRental; }
}
