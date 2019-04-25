package views;

import adapters.DatabaseAdapter;
import controllers.UserController;
import main.CAR;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    private JButton btChangePassword;

    /**
     * Constructor for AccountDetailsView
     */
    public AccountDetailsView() {
        super( "View Account Details" );

        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();

        pnAccountDetails = new JPanel();
        pnAccountDetails.setBorder( BorderFactory.createTitledBorder( "Account Details" ) );
        GridBagLayout gbAccountDetails = new GridBagLayout();
        GridBagConstraints gbcAccountDetails = new GridBagConstraints();
        pnAccountDetails.setLayout( gbAccountDetails );

        lbName = new JLabel( "Name: " + UserController.getUser().getFullname());
        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 9;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.VERTICAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbName, gbcAccountDetails );
        pnAccountDetails.add( lbName );

        lbUsername = new JLabel( "Username: " + UserController.getUser().getUsername());
        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 11;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.VERTICAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbUsername, gbcAccountDetails );
        pnAccountDetails.add( lbUsername );

        lbEmail = new JLabel( "Email: " + UserController.getUser().getEmail());
        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 13;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.VERTICAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbEmail, gbcAccountDetails );
        pnAccountDetails.add( lbEmail );

        lbCreditCardType = new JLabel( "Credit Card Type: " + UserController.getUser().getCreditType());
        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 15;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.VERTICAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( lbCreditCardType, gbcAccountDetails );
        pnAccountDetails.add( lbCreditCardType );

        btChangePassword = new JButton("Change Password");
        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 17;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.VERTICAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.NORTH;
        gbAccountDetails.setConstraints( btChangePassword, gbcAccountDetails );
        pnAccountDetails.add( btChangePassword );

        BufferedImage picture = DatabaseAdapter.loadImage();
        lbPicture = new JLabel(new ImageIcon(picture));
        add(lbPicture);

        gbcAccountDetails.gridx = 7;
        gbcAccountDetails.gridy = 7;
        gbcAccountDetails.gridwidth = 1;
        gbcAccountDetails.gridheight = 1;
        gbcAccountDetails.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountDetails.weightx = 1;
        gbcAccountDetails.weighty = 0;
        gbcAccountDetails.anchor = GridBagConstraints.CENTER;
        gbAccountDetails.setConstraints( lbPicture, gbcAccountDetails );
        pnAccountDetails.add( lbPicture );

        JScrollPane scpAccountDetails = new JScrollPane( pnAccountDetails );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 19;
        gbcMainPanel.gridheight = 15;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpAccountDetails, gbcMainPanel );

        setContentPane( pnAccountDetails );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }
}
