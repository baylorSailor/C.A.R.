package views;

import adapters.DatabaseAdapter;
import controllers.UserController;
import main.CAR;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Displays details for the account in a window.
 */
public class AccountDetailsView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    private JPanel pnAccountDetails;
    private JLabel lbName;
    private JLabel lbUsername;
    private JLabel lbEmail;
    private JLabel lbCreditCardType;
    private JLabel lbPicture;
    private JLabel lbCreditCardNumber;
    private JButton btChangePassword;
    private JButton btChangeCardInfo;

    /**
     * Constructor for AccountDetailsView
     */
    public AccountDetailsView() {
        super( "View Account Details" );
        log.log(Level.INFO,"Account Details View has been instantiated");

        pnAccountDetails = new JPanel();
        pnAccountDetails.setBorder( BorderFactory.createTitledBorder( "Account Details" ) );
        GridBagLayout gbAccountDetails = new GridBagLayout();
        GridBagConstraints gbcAccountDetails = new GridBagConstraints();
        pnAccountDetails.setLayout( gbAccountDetails );

        BufferedImage picture = DatabaseAdapter.loadImage();
        picture = MainMenuView.resize(picture,240,240);
        lbPicture = new JLabel(new ImageIcon(picture));
        add(lbPicture);
        gbcAccountDetails.gridx = 5;
        gbcAccountDetails.gridy = 0;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 10;
        gbcAccountDetails.fill = GridBagConstraints.VERTICAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.EAST;
        gbAccountDetails.setConstraints( lbPicture, gbcAccountDetails );
        pnAccountDetails.add( lbPicture );

        lbName = new JLabel( "Name: " + UserController.getUser().getFullname());
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 2;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 1;
        gbcAccountDetails.anchor = GridBagConstraints.SOUTHWEST;
        gbAccountDetails.setConstraints( lbName, gbcAccountDetails );
        pnAccountDetails.add( lbName );

        lbUsername = new JLabel( "Username: " + UserController.getUser().getUsername());
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 3;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.WEST;
        gbAccountDetails.setConstraints( lbUsername, gbcAccountDetails );
        pnAccountDetails.add( lbUsername );

        lbEmail = new JLabel( "Email: " + UserController.getUser().getEmail());
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 4;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.WEST;
        gbAccountDetails.setConstraints( lbEmail, gbcAccountDetails );
        pnAccountDetails.add( lbEmail );

        lbCreditCardType = new JLabel( "Credit Card Type: " + UserController.getUser().getCreditType());
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 5;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.WEST;
        gbAccountDetails.setConstraints( lbCreditCardType, gbcAccountDetails );
        pnAccountDetails.add( lbCreditCardType );

        // Replace all but the last four numbers with *
        StringBuilder lb = new StringBuilder(UserController.getUser().getCreditCard());
        int size = UserController.getUser().getCreditCard().length()-4;
        lb.delete(0,size);
        for(int i = 0; i < size; i++) {
            lb.insert(0,"*");
        }
        lb.insert(0,"Credit Card Number: ");

        lbCreditCardNumber = new JLabel( lb.toString() + "                " );
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 6;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 1;
        gbcAccountDetails.anchor = GridBagConstraints.NORTHWEST;
        gbAccountDetails.setConstraints( lbCreditCardNumber, gbcAccountDetails );
        pnAccountDetails.add( lbCreditCardNumber );

        btChangePassword = new JButton("Change Password");
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 10;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.CENTER;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 1;
        gbcAccountDetails.anchor = GridBagConstraints.SOUTHWEST;
        gbAccountDetails.setConstraints( btChangePassword, gbcAccountDetails );
        pnAccountDetails.add( btChangePassword );

        btChangeCardInfo = new JButton("Change Card Info");
        gbcAccountDetails.gridx = 0;
        gbcAccountDetails.gridy = 11;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.CENTER;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.SOUTHWEST;
        gbAccountDetails.setConstraints( btChangeCardInfo, gbcAccountDetails );
        pnAccountDetails.add( btChangeCardInfo );

        setContentPane( pnAccountDetails );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    /**
     * Get the change password button
     * @return A button for change password
     */
    public JButton getBtChangePassword() {
        return btChangePassword;
    }

    /**
     * Get the change card info button
     * @return A button for change card info
     */
    public JButton getBtChangeInfoInfo() {
        return btChangeCardInfo;
    }
}
