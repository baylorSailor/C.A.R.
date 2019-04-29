package views;

import adapters.DatabaseAdapter;
import main.CAR;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Window for creating a new account
 */
public class CreateAccountView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    private JPanel pnCreateAcct;
    private ButtonGroup rbgCreateAcct;

    private JLabel lbFirstName;
    private JLabel lbLastName;
    private JLabel lbUserName;
    private JLabel lbEmail;
    private JLabel lbCreditCard;
    private JLabel lbCreditCardNumber;
    private JLabel lbPassword;
    private JLabel lbPassword2;
    private JLabel lbError;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfUserName;
    private JTextField tfEmail;
    private JTextField tfCreditCardNumber;
    private JRadioButton rbVisa;
    private JRadioButton rbMasterCard;
    private JPasswordField tfPassword;
    private JPasswordField tfPassword2;
    private JButton btCreateAcct;
    private JButton btAddImage;

    static BufferedImage picture = null;

    /**
     * Constructs the window for making a new account
     * {@link #getBtCreateAcct()}
     */
    public CreateAccountView() {
        super( "Create Account" );
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();

        pnCreateAcct = new JPanel();
        pnCreateAcct.setBorder( BorderFactory.createTitledBorder( "New Account" ) );
        rbgCreateAcct = new ButtonGroup();
        GridBagLayout gbCreateAcct = new GridBagLayout();
        GridBagConstraints gbcCreateAcct = new GridBagConstraints();
        pnCreateAcct.setLayout( gbCreateAcct );

        lbFirstName = new JLabel( "Firstname:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 0;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbFirstName, gbcCreateAcct );
        pnCreateAcct.add( lbFirstName );

        tfFirstName = new JTextField( );
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 0;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbFirstName.setLabelFor(tfFirstName);
        gbCreateAcct.setConstraints( tfFirstName, gbcCreateAcct );
        pnCreateAcct.add( tfFirstName );

        lbLastName = new JLabel( "Lastname:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 1;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbLastName, gbcCreateAcct );
        pnCreateAcct.add( lbLastName );

        tfLastName = new JTextField( );
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 1;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbLastName.setLabelFor(tfLastName);
        gbCreateAcct.setConstraints( tfLastName, gbcCreateAcct );
        pnCreateAcct.add( tfLastName );

        lbUserName = new JLabel( "Username:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 2;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbUserName, gbcCreateAcct );
        pnCreateAcct.add( lbUserName );

        tfUserName = new JTextField( );
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 2;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbUserName.setLabelFor(tfUserName);
        gbCreateAcct.setConstraints( tfUserName, gbcCreateAcct );
        pnCreateAcct.add( tfUserName );

        lbEmail = new JLabel( "Email:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 4;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbEmail, gbcCreateAcct );
        pnCreateAcct.add( lbEmail );

        tfEmail = new JTextField( );
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 4;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbEmail.setLabelFor(tfEmail);
        gbCreateAcct.setConstraints( tfEmail, gbcCreateAcct );
        pnCreateAcct.add( tfEmail );

        lbCreditCard = new JLabel( "Credit Card:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 5;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbCreditCard, gbcCreateAcct );
        pnCreateAcct.add( lbCreditCard );

        rbVisa = new JRadioButton( "Visa"  );
        rbgCreateAcct.add( rbVisa );
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 5;
        gbcCreateAcct.gridwidth = 2;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.VERTICAL;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.NORTH;
        gbCreateAcct.setConstraints( rbVisa, gbcCreateAcct );
        pnCreateAcct.add( rbVisa );

        rbMasterCard = new JRadioButton( "MasterCard"  );
        rbgCreateAcct.add( rbMasterCard );
        gbcCreateAcct.gridx = 3;
        gbcCreateAcct.gridy = 5;
        gbcCreateAcct.gridwidth = 2;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.VERTICAL;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.NORTH;
        gbCreateAcct.setConstraints( rbMasterCard, gbcCreateAcct );
        pnCreateAcct.add( rbMasterCard );
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 0;
        gbcMainPanel.gridwidth = 15;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( pnCreateAcct, gbcMainPanel );

        lbCreditCardNumber = new JLabel( "Card Number:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 6;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbCreditCardNumber, gbcCreateAcct );
        pnCreateAcct.add( lbCreditCardNumber );

        tfCreditCardNumber = new JTextField( );
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 6;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbCreditCardNumber.setLabelFor(tfCreditCardNumber);
        gbCreateAcct.setConstraints( tfCreditCardNumber, gbcCreateAcct );
        pnCreateAcct.add( tfCreditCardNumber );

        lbPassword = new JLabel( "Password:"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 7;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbPassword, gbcCreateAcct );
        pnCreateAcct.add( lbPassword );

        tfPassword = new JPasswordField();
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 7;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbPassword.setLabelFor(tfPassword);
        gbCreateAcct.setConstraints( tfPassword, gbcCreateAcct );
        pnCreateAcct.add( tfPassword );

        lbPassword2 = new JLabel("Retype Password:");
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 8;
        gbcCreateAcct.gridwidth = 1;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( lbPassword2, gbcCreateAcct );
        pnCreateAcct.add( lbPassword2 );

        tfPassword2 = new JPasswordField();
        gbcCreateAcct.gridx = 1;
        gbcCreateAcct.gridy = 8;
        gbcCreateAcct.gridwidth = 12;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.HORIZONTAL;
        gbcCreateAcct.weightx = 1;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        lbPassword2.setLabelFor(tfPassword2);
        gbCreateAcct.setConstraints( tfPassword2, gbcCreateAcct );
        pnCreateAcct.add( tfPassword2 );

        btAddImage = new JButton( "Upload Image"  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 9;
        gbcCreateAcct.gridwidth = 5;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.VERTICAL;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.WEST;
        gbCreateAcct.setConstraints( btAddImage, gbcCreateAcct );
        pnCreateAcct.add( btAddImage );

        btCreateAcct = new JButton( "Create Account"  );
        gbcCreateAcct.gridx = 3;
        gbcCreateAcct.gridy = 9;
        gbcCreateAcct.gridwidth = 5;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.VERTICAL;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.CENTER;
        gbCreateAcct.setConstraints( btCreateAcct, gbcCreateAcct );
        pnCreateAcct.add( btCreateAcct );
        getRootPane().setDefaultButton(btCreateAcct);

        lbError = new JLabel( " "  );
        gbcCreateAcct.gridx = 0;
        gbcCreateAcct.gridy = 10;
        gbcCreateAcct.gridwidth = 13;
        gbcCreateAcct.gridheight = 1;
        gbcCreateAcct.fill = GridBagConstraints.NONE;
        gbcCreateAcct.weightx = 0;
        gbcCreateAcct.weighty = 0;
        gbcCreateAcct.anchor = GridBagConstraints.WEST;
        gbCreateAcct.setConstraints( lbError, gbcCreateAcct );
        pnCreateAcct.add( lbError );
        lbError.setForeground(Color.red);

        setContentPane( pnCreateAcct );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    /**
     * Adds an image to the account.
     * @param evt Action event for the image
     */
    public void AddImage(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try {
            picture = ImageIO.read(new File(file.getAbsolutePath()));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample.png"));
            } catch(IOException ee) {
                ee.printStackTrace();
                log.log(Level.SEVERE,"Sample Profile Image couldn't be found");
            }
        }
    }

    /**
     * Checks if all fields have been entered for a new account.
     * @return true if all fields have been entered, otherwise false.
     */
    public boolean allFieldsEntered() {
       boolean foo = true;
       String[] strings = new String[7];
        strings[0] = tfFirstName.getText() + tfLastName.getText();
        strings[1] = tfUserName.getText();
        strings[2] = tfEmail.getText();
        strings[3] = tfPassword.getText();
        strings[5] = tfCreditCardNumber.getText();
        if(DatabaseAdapter.verifySyntax(strings)) {
            if(!(tfFirstName.isValid() && tfUserName.isValid() && tfCreditCardNumber.isValid() && tfEmail.isValid() &&
                    tfLastName.isValid() && (rbVisa.isSelected() || rbMasterCard.isSelected()) &&
                    (tfPassword.getPassword().length >= 7) && (tfPassword.getText().equals(tfPassword2.getText())))) {
                foo = false;
            }
        } else {
            foo = false;
        }

       return foo;
    }

    /**
     * Gets the user account image
     * @return BufferedImage of the picture
     */

    public static BufferedImage getPicture() {
        return picture;
    }

    /**
     * Gets first name
     * @return A textfield representing user's first name
     */
    public JTextField getTfFirstName() {
        return tfFirstName;
    }

    /**
     * Gets last name
     * @return A textfield user's last name
     */
    public JTextField getTfLastName() {
        return tfLastName;
    }

    /**
     * Gets create account button
     * @return The button for create account
     */
    public JButton getBtCreateAcct() {
        return btCreateAcct;
    }

    /**
     * Gets add image button
     * @return The button for add image
     */
    public JButton getBtAddImage() {
        return btAddImage;
    }

    /**
     * Gets user name
     * @return A textfield representing user's username
     */
    public JTextField getTfUserName() {
        return tfUserName;
    }

    /**
     * Gets user email
     * @return A textfield representing the user's email
     */
    public JTextField getTfEmail() {
        return tfEmail;
    }

    /**
     * Gets credit card type
     * @return A radio button representing the card type
     */
    public JRadioButton getRbVisa() {
        return rbVisa;
    }

    /**
     * Gets credit card number
     * @return A textfield representing the card number
     */
    public JTextField getTfCreditCardNumber() {
        return tfCreditCardNumber;
    }

    /**
     * Gets user password
     * @return A textfield representing the user password
     */
    public JPasswordField getTfPassword() {
        return tfPassword;
    }

    /**
     * Sets the error message
     * @param str The error label message
     */
    public void setErrorLabelMessage(String str) {
        this.lbError.setText(str);
    }

    /**
     * Sets the user account picture
     * @param picture The picture to set
     */
    public static void setPicture(BufferedImage picture) {
        CreateAccountView.picture = picture;
    }


}

