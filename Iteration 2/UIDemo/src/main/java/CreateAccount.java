import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class CreateAccount extends JFrame {

   JPanel pnMainPanel;

   JPanel pnCreateAcct;
   ButtonGroup rbgCreateAcct;
   JLabel lbFirstName;
   JTextField tfFirstName;
   JLabel lbLastName;
   JTextField tfLastName;
   JButton btCreateAcct;
   JButton btAddImage;
   JLabel lbUserName;
   JTextField tfUserName;
   JLabel lbEmail;
   JTextField tfEmail;
   JLabel lbCreditCard;
   JRadioButton rbVisa;
   JRadioButton rbMasterCard;
   JLabel lbCreditCardNumber;
   JTextField tfCreditCardNumber;
   JLabel lbPassword;
   JTextField tfPassword;

   BufferedImage picture = null;

   public CreateAccount() {
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
      System.out.println(tfFirstName.getText());

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
       //btCreateAcct.setActionCommand( "createAccount" );
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
      //btCreateAcct.setActionCommand( "createAccount" );
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
      btCreateAcct.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){

            try {
               String creditType;
               BufferedWriter bw;
               File file = new File("./src/main/resources/Users.csv");

               if(rbVisa.isSelected()) {
                  creditType = "Visa";
               } else {
                  creditType = "MasterCard";
               }

               if(file.exists()){
                   bw = new BufferedWriter(new FileWriter("./src/main/resources/Users.csv", true));
                   bw.write(tfFirstName.getText() + " " + tfLastName.getText() + ","
                           + tfUserName.getText() + "," + tfEmail.getText() + "," + tfPassword.getText() + ","
                           + creditType + "," + tfCreditCardNumber.getText() +  "\n");
                   bw.close();
                   /// TODO Ensure that a photo is added, then save it
                   SaveImage();
               }
               else{
                   bw = new BufferedWriter(new FileWriter("./src/main/resources/Users.csv"));
                   bw.write(tfFirstName.getText() + " " + tfLastName.getText() + ","
                           + tfUserName.getText() + "," + tfEmail.getText() + "," + tfPassword.getText() + ","
                           + creditType + "," + tfCreditCardNumber.getText() + "\n");
                   bw.close();
               }
            } catch (IOException ex){
                // TODO add logger to catch this
               ex.printStackTrace();
            }

            setVisible(false);
         }
      });

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
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample.png"));
            } catch(IOException ee) {
                //TODO add logger to catch this
            }
        }
    }

    private void SaveImage() {
        File outfile = new File("./src/main/resources/" + tfUserName.getText() + ".png");
        try {
            ImageIO.write(picture, "png", new File(outfile.getPath()));
        } catch(IOException ee) {
            //TODO add logger to catch this
        }
    }
}

