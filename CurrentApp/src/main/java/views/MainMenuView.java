/**
 * Main Menu view for the app.
 */

package views;

import adapters.DatabaseAdapter;
import controllers.UserController;
import factories.RepresentativeFactory;
import main.CAR;
import models.AdministratorModel;
import models.CarModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Window for the main screen
 */
public class MainMenuView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private static CarModel[] CarList;
    private static CarModel[] SearchList;
    private JPanel pnMainPanel;

    private JPanel pnSearchResults;
    private JButton btRefresh;
    private JButton btHistory;
    private JButton btActiveRentals;
    private JButton btAccountDetails;
    private JButton btEditUsers;
    private JButton btEditCars;
    private JButton btLogout;
    private JButton btHelp;
    private JButton btAddRental;
    private JButton btLeftButton;
    private JButton btRightButton;
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
    private JComboBox cmbDate;
    private JSlider sdMileage;
    private JSlider sdMPG;
    private JComboBox cmbInterior;
    private JComboBox cmbExterior;

    public Integer carListPosition = 0;

    /**
     * Constructs main window screen
     */
    public MainMenuView() {
        super( "View Local Listings");
        log.log(Level.INFO,"Main Menu View has been instantiated");
        pnMainPanel = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnMainPanel.setLayout( gbMainPanel );

        pnSearchResults = new JPanel();
        pnSearchResults.setBorder( BorderFactory.createTitledBorder( "Results" ) );
        GridBagLayout gbSearchResults = new GridBagLayout();
        GridBagConstraints gbcSearchResults = new GridBagConstraints();
        pnSearchResults.setLayout( gbSearchResults );

        gbcMainPanel.gridx = 6;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 18;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( pnSearchResults, gbcMainPanel );
        pnMainPanel.add( pnSearchResults );

        //Test label in the main window
        CarList = DatabaseAdapter.loadAllCars();
        SearchList = CarList;
        JLabel test = new JLabel( "<html>Make: " + SearchList[0].getMake() +
                "<br/>Model: " + SearchList[0].getModel() + "<br/>Year: " +
                SearchList[0].getYear().toString() + "<br/>Type: " +
                SearchList[0].getType() + "<br/>Transmission: " +
                SearchList[0].getTransmission() +
                "&#160 &#160 &#160 &#160 &#160 &#160" + // Add spacing
                "<br/>Miles: " + SearchList[0].getMileage().toString() +
                "<br/>Avg MPG: " + SearchList[0].getMpgCombined() +
                "<br/>Interior: " + SearchList[0].getInterior() +
                "<br/>Exterior: " + SearchList[0].getExterior() + "</html>" );
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
            //if car name == TT display audi photo
            //System.out.println(SearchList[0].getModel());
            picture = ImageIO.read(new File("./src/main/resources/CarPics/dfa0e17.jpg"));
        } catch(IOException e) {
            log.log(Level.SEVERE,e.getMessage());
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample_car.png"));
            } catch(IOException ee) {
                log.log(Level.SEVERE,ee.getMessage());
            }

        } finally {
            picture = resize(picture,150,300);
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
        if(UserController.getUser() instanceof AdministratorModel) {
            lbLoggedInAs.setForeground(Color.red);
        }
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

        //Edit Users Button
        btEditUsers = new JButton( "Edit Users"  );
        gbcMainPanel.gridx = 16;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btEditUsers, gbcMainPanel );
        pnMainPanel.add( btEditUsers );
        btEditUsers.setVisible(false);
        if(UserController.getUser() instanceof AdministratorModel) {
            btEditUsers.setVisible(true);
        }

        //Edit Vehicles Button
        btEditCars = new JButton( "Edit Cars"  );
        gbcMainPanel.gridx = 18;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btEditCars, gbcMainPanel );
        pnMainPanel.add( btEditCars );
        btEditCars.setVisible(false);
        //if(UserController.getUser() instanceof RepresentativeModel) {
            btEditCars.setVisible(true);
        //}

        //Logout Button
        btLogout = new JButton( "Logout"  );
        gbcMainPanel.gridx = 20;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btLogout, gbcMainPanel );
        pnMainPanel.add( btLogout );

        //Help Button
        btHelp = new JButton( "Help"  );
        gbcMainPanel.gridx = 22;
        gbcMainPanel.gridy = 9;
        gbcMainPanel.gridwidth = 0;
        gbcMainPanel.gridheight = 0;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btHelp, gbcMainPanel );
        pnMainPanel.add( btHelp );

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

        String []dataMake = DatabaseAdapter.loadAllMakes();
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

        String []dataModel = DatabaseAdapter.loadAllModels(null);
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
        cmbModel.setEnabled(false);

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

        String []dataYear = DatabaseAdapter.loadAllYears(null,null);
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
        cmbYear.setEnabled(false);

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

        String []dataType = DatabaseAdapter.loadAllTypes(null,null,null);
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
        cmbType.setEnabled(false);

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

        String []dataTrans = DatabaseAdapter.loadAllTransmissions(null, null,null,null);
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
        cmbTrans.setEnabled(false);

        //Interior color options
        lbInterior = new JLabel( "Interior Color"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 17;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbInterior, gbcMainPanel );
        pnMainPanel.add( lbInterior );

        String []dataInterior = DatabaseAdapter.loadAllInteriorColor(null,
                null,null,null,null);
        cmbInterior = new JComboBox( dataInterior );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 17;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbInterior, gbcMainPanel );
        pnMainPanel.add( cmbInterior );
        cmbInterior.setEnabled(false);

        //Exterior color options
        lbExterior = new JLabel( "Exterior Color"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 18;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbExterior, gbcMainPanel );
        pnMainPanel.add( lbExterior );

        String []dataExterior = DatabaseAdapter.loadAllExteriorColor(null,
                null,null,null,null,
                null);
        cmbExterior = new JComboBox( dataExterior );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 18;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbExterior, gbcMainPanel );
        pnMainPanel.add( cmbExterior );
        cmbExterior.setEnabled(false);

        //Mileage slider
        lbMileage = new JLabel( "Mileage"  );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 19;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbMileage, gbcMainPanel );
        pnMainPanel.add( lbMileage );

        sdMileage = new JSlider( JSlider.HORIZONTAL,
                10, 90, 10);
        sdMileage.setMajorTickSpacing(10);
        sdMileage.setPaintTicks(true);
        sdMileage.setPaintLabels(true);
        sdMileage.setPaintTrack(true);
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 19;
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
        gbcMainPanel.gridy = 20;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( lbMPG, gbcMainPanel );
        pnMainPanel.add( lbMPG );

        sdMPG = new JSlider( JSlider.HORIZONTAL,
                0, 50, 0);
        sdMPG.setMajorTickSpacing(10);
        sdMPG.setPaintTicks(true);
        sdMPG.setPaintLabels(true);
        sdMPG.setPaintTrack(true);
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 20;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( sdMPG, gbcMainPanel );
        pnMainPanel.add( sdMPG );

        //Add to rental button
        btAddRental = new JButton( "Add Rental"  );
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 22;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( btAddRental, gbcMainPanel );
        pnMainPanel.add( btAddRental );

        //Add to date picker
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        String[] dates = new String[7];
        for(int i = 0; i < 7; i++) {
            calendar.add(Calendar.DATE,i);
            Date today = calendar.getTime();
            String str = today.toString();
            str = str.substring(0,10);
            dates[i] = str;
        }
        cmbDate = new JComboBox( dates );
        gbcMainPanel.gridx = 2;
        gbcMainPanel.gridy = 22;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( cmbDate, gbcMainPanel );
        pnMainPanel.add( cmbDate );

        //Left arrow button
        btLeftButton = new JButton(" < ");
        gbcMainPanel.gridx = 11;
        gbcMainPanel.gridy = 20;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( btLeftButton, gbcMainPanel );
        pnMainPanel.add( btLeftButton );

        //Right arrow button
        btRightButton = new JButton(" > ");
        gbcMainPanel.gridx = 15;
        gbcMainPanel.gridy = 20;
        gbcMainPanel.gridwidth = 1;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( btRightButton, gbcMainPanel );
        pnMainPanel.add( btRightButton );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnMainPanel );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    /**
     * Updates the Search Pane based on criteria provided
     */
    public void updateSearch() {
        //JPanel oldPanel = pnSearchResults;
        pnSearchResults.removeAll();
        JLabel test;

        if(SearchList.length == 0) {
            test = new JLabel("NO MATCHING CARS! :(");
        } else {
            test = new JLabel("<html>Make: " + SearchList[carListPosition].getMake() +
                    "<br/>Model: " + SearchList[carListPosition].getModel() + "<br/>Year: " +
                    SearchList[carListPosition].getYear().toString() + "<br/>Type: " +
                    SearchList[carListPosition].getType() + "<br/>Transmission: " +
                    SearchList[carListPosition].getTransmission() +
                    "&#160 &#160 &#160 &#160 &#160 &#160" + // Add spacing
                    "<br/>Miles: " + SearchList[carListPosition].getMileage().toString() +
                    "<br/>Avg MPG: " + SearchList[carListPosition].getMpgCombined() +
                    "<br/>Interior: " + SearchList[carListPosition].getInterior() +
                    "<br/>Exterior: " + SearchList[carListPosition].getExterior() + "</html>");
        }
        pnSearchResults.add(test);

        BufferedImage picture = null;
        try {
            //if car name == TT display audi photo
            //System.out.println(SearchList[0].getModel());
            String imageID = SearchList[carListPosition].getImageID();
            picture = ImageIO.read(new File("./src/main/resources/CarPics/" +
                    imageID + ".jpg"));
        } catch(IOException e) {
            log.log(Level.SEVERE,e.getMessage());
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample_car.png"));
            } catch(IOException ee) {
                log.log(Level.SEVERE,ee.getMessage());
            }

        } finally {
            picture = resize(picture,150,300);
            lbPicture = new JLabel(new ImageIcon(picture));
            test.setHorizontalAlignment(SwingConstants.RIGHT);
            pnSearchResults.add(lbPicture);
        }

        pnSearchResults.revalidate();
        pnSearchResults.repaint();
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
     * Button for edit users
     * @return A button for edit users
     */
    public JButton getBtEditUsers() {
        return btEditUsers;
    }

    /**
     * Button for logout
     * @return A button for logging out
     */
    public JButton getBtLogout() {
        return btLogout;
    }

    /**
     * Button for help
     * @return A button for help
     */
    public JButton getBtHelp() {
        return btHelp;
    }

    /**
     * Button for add rental
     * @return A button for adding the rental car
     */
    public JButton getBtAddRental(){
        return btAddRental;
    }

    /**
     * Button for going left in list
     * @return A button for moving left through the array of cars
     */
    public JButton getBtLeftButton() {
        return btLeftButton;
    }

    /**
     * Button for going right in list
     * @return A button for moving right through the array of cars
     */
    public JButton getBtRightButton() {
        return btRightButton;
    }

    /**
     * ComboBox for the selected make
     * @return A ComboBox for the selected make
     */
    public JComboBox getCmbMake() {
        return cmbMake;
    }

    /**
     * ComboBox for the selected model
     * @return A ComboBox for the selected model
     */
    public JComboBox getCmbModel() {
        return cmbModel;
    }

    /**
     * ComboBox for the selected year
     * @return A ComboBox for the selected year
     */
    public JComboBox getCmbYear() {
        return cmbYear;
    }

    /**
     * ComboBox for the selected type
     * @return A ComboBox for the selected type
     */
    public JComboBox getCmbType() {
        return cmbType;
    }

    /**
     * ComboBox for the selected transmission
     * @return A ComboBox for the selected transmission
     */
    public JComboBox getCmbTrans() {
        return cmbTrans;
    }

    /**
     * JSlider for the selected mileage
     * @return A JSlider for the selected mileage
     */
    public JSlider getSdMileage() {
        return sdMileage;
    }

    /**
     * JSlider for the selected MPG
     * @return A JSlider for the selected MPG
     */
    public JSlider getSdMPG() {
        return sdMPG;
    }

    /**
     * ComboBox for the selected interior color
     * @return A ComboBox for the selected interior color
     */
    public JComboBox getCmbInterior() {
        return cmbInterior;
    }

    /**
     * ComboBox for the selected exterior color
     * @return A ComboBox for the selected exterior color
     */
    public JComboBox getCmbExterior() {
        return cmbExterior;
    }

    /** CarModel list for searching
     * @return A CarModel[] for searching
     */
    public CarModel[] getCarList() {
        return CarList;
    }

    /**
     * Sets the SearchList containing CarModels
     * @param searchList An array containing CarModels
     */
    public void setSearchList(CarModel[] searchList) {
        SearchList = searchList;
    }

    /**
     * Gets the SearchList containing CarModels
     * @return An array containing CarModels
     */
    public static CarModel[] getSearchList() {
        return SearchList;
    }

    /**
     * Resizes the image
     * @param img the image to be resized
     * @param height the desired height of the image
     * @param width the desired width of the image
     */
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
