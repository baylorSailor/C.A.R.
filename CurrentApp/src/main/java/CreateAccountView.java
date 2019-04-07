import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

class CreateAccountView extends JFrame {

    private JPanel pnMainPanel;

    private JPanel pnCreateAcct;
    private ButtonGroup rbgCreateAcct;
    private JLabel lbFirstName;
    private JTextField tfFirstName;
    private JLabel lbLastName;
    private JTextField tfLastName;
    private JButton btCreateAcct;
    private JButton btAddImage;
    private JLabel lbUserName;
    private JTextField tfUserName;
    private JLabel lbEmail;
    private JTextField tfEmail;
    private JLabel lbCreditCard;
    private JRadioButton rbVisa;
    private JRadioButton rbMasterCard;
    private JLabel lbCreditCardNumber;
    private JTextField tfCreditCardNumber;
    private JLabel lbPassword;
    private JPasswordField tfPassword;
    private JLabel lbError;

    static BufferedImage picture = null;

    public CreateAccountView() {
      super( "Create Account" );
      pnMainPanel = new JPanel();
      GridBagLayout gbMainPanel = new GridBagLayout();
      GridBagConstraints gbcMainPanel = new GridBagConstraints();
      pnMainPanel.setLayout( gbMainPanel );

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
      //rbMasterCard.setActionCommand( "Visa" );
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
      pnMainPanel.add( pnCreateAcct );

      lbCreditCardNumber = new JLabel( "Credit Card Number:"  );
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
       gbCreateAcct.setConstraints( tfPassword, gbcCreateAcct );
       pnCreateAcct.add( tfPassword );

       btAddImage = new JButton( "Upload Image"  );
       gbcCreateAcct.gridx = 3;
       gbcCreateAcct.gridy = 8;
       gbcCreateAcct.gridwidth = 5;
       gbcCreateAcct.gridheight = 2;
       gbcCreateAcct.fill = GridBagConstraints.VERTICAL;
       gbcCreateAcct.weightx = 0;
       gbcCreateAcct.weighty = 0;
       gbcCreateAcct.anchor = GridBagConstraints.SOUTH;
       gbCreateAcct.setConstraints( btAddImage, gbcCreateAcct );
       pnCreateAcct.add( btAddImage );
       btAddImage.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               AddImage(e);
           }
       });

      btCreateAcct = new JButton( "Create Account"  );
      gbcCreateAcct.gridx = 3;
      gbcCreateAcct.gridy = 10;
      gbcCreateAcct.gridwidth = 5;
      gbcCreateAcct.gridheight = 2;
      gbcCreateAcct.fill = GridBagConstraints.VERTICAL;
      gbcCreateAcct.weightx = 0;
      gbcCreateAcct.weighty = 0;
      gbcCreateAcct.anchor = GridBagConstraints.SOUTH;
      gbCreateAcct.setConstraints( btCreateAcct, gbcCreateAcct );
      pnCreateAcct.add( btCreateAcct );
      getRootPane().setDefaultButton(btCreateAcct);

      setContentPane( pnMainPanel );
      pack();
      setVisible( true );
    }

    private void AddImage(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try {
            picture = ImageIO.read(new File(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample.png"));
            } catch(IOException ee) {
                ee.printStackTrace();
                //TODO add logger to catch this
            }
        }
    }

    public boolean allFieldsEntered() {
       boolean foo = true;
       if(!(tfFirstName.isValid() && tfUserName.isValid() && tfCreditCardNumber.isValid() && tfEmail.isValid() &&
       tfLastName.isValid() && tfPassword.isValid() && (rbVisa.isSelected() ||
               rbMasterCard.isSelected()))) {
           foo = false;
       }
       return foo;
    }

    public static BufferedImage getPicture() {
        return picture;
    }

    public JPanel getPnMainPanel() {
        return pnMainPanel;
    }

    public void setPnMainPanel(JPanel pnMainPanel) {
        this.pnMainPanel = pnMainPanel;
    }

    public JPanel getPnCreateAcct() {
        return pnCreateAcct;
    }

    public void setPnCreateAcct(JPanel pnCreateAcct) {
        this.pnCreateAcct = pnCreateAcct;
    }

    public ButtonGroup getRbgCreateAcct() {
        return rbgCreateAcct;
    }

    public void setRbgCreateAcct(ButtonGroup rbgCreateAcct) {
        this.rbgCreateAcct = rbgCreateAcct;
    }

    public JLabel getLbFirstName() {
        return lbFirstName;
    }

    public void setLbFirstName(JLabel lbFirstName) {
        this.lbFirstName = lbFirstName;
    }

    public JTextField getTfFirstName() {
        return tfFirstName;
    }

    public void setTfFirstName(JTextField tfFirstName) {
        this.tfFirstName = tfFirstName;
    }

    public JLabel getLbLastName() {
        return lbLastName;
    }

    public void setLbLastName(JLabel lbLastName) {
        this.lbLastName = lbLastName;
    }

    public JTextField getTfLastName() {
        return tfLastName;
    }

    public void setTfLastName(JTextField tfLastName) {
        this.tfLastName = tfLastName;
    }

    public JButton getBtCreateAcct() {
        return btCreateAcct;
    }

    public void setBtCreateAcct(JButton btCreateAcct) {
        this.btCreateAcct = btCreateAcct;
    }

    public JButton getBtAddImage() {
        return btAddImage;
    }

    public void setBtAddImage(JButton btAddImage) {
        this.btAddImage = btAddImage;
    }

    public JLabel getLbUserName() {
        return lbUserName;
    }

    public void setLbUserName(JLabel lbUserName) {
        this.lbUserName = lbUserName;
    }

    public JTextField getTfUserName() {
        return tfUserName;
    }

    public void setTfUserName(JTextField tfUserName) {
        this.tfUserName = tfUserName;
    }

    public JLabel getLbEmail() {
        return lbEmail;
    }

    public void setLbEmail(JLabel lbEmail) {
        this.lbEmail = lbEmail;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(JTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    public JLabel getLbCreditCard() {
        return lbCreditCard;
    }

    public void setLbCreditCard(JLabel lbCreditCard) {
        this.lbCreditCard = lbCreditCard;
    }

    public JRadioButton getRbVisa() {
        return rbVisa;
    }

    public void setRbVisa(JRadioButton rbVisa) {
        this.rbVisa = rbVisa;
    }

    public JRadioButton getRbMasterCard() {
        return rbMasterCard;
    }

    public void setRbMasterCard(JRadioButton rbMasterCard) {
        this.rbMasterCard = rbMasterCard;
    }

    public JLabel getLbCreditCardNumber() {
        return lbCreditCardNumber;
    }

    public void setLbCreditCardNumber(JLabel lbCreditCardNumber) {
        this.lbCreditCardNumber = lbCreditCardNumber;
    }

    public JTextField getTfCreditCardNumber() {
        return tfCreditCardNumber;
    }

    public void setTfCreditCardNumber(JTextField tfCreditCardNumber) {
        this.tfCreditCardNumber = tfCreditCardNumber;
    }

    public JLabel getLbPassword() {
        return lbPassword;
    }

    public void setLbPassword(JLabel lbPassword) {
        this.lbPassword = lbPassword;
    }

    public JPasswordField getTfPassword() {
        return tfPassword;
    }

    public static void setPicture(BufferedImage picture) {
        CreateAccountView.picture = picture;
    }
}

