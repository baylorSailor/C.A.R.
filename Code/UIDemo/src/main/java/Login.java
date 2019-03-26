import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Login extends JFrame {

   JPanel pnMainPanel;

   JPanel pnLoginPanel;
   JLabel lbUser;
   JLabel lbPass;
   JTextField tfUser;
   JPasswordField tfPass;
   JButton btLogin;
   JButton btCreateAcct;

   public Login() {
      super( "Login" );
      pnMainPanel = new JPanel();
      GridBagLayout gbMainPanel = new GridBagLayout();
      GridBagConstraints gbcMainPanel = new GridBagConstraints();
      pnMainPanel.setLayout( gbMainPanel );

      pnLoginPanel = new JPanel();
      pnLoginPanel.setBorder( BorderFactory.createTitledBorder( "Sign In" ) );
      GridBagLayout gbLoginPanel = new GridBagLayout();
      GridBagConstraints gbcLoginPanel = new GridBagConstraints();
      pnLoginPanel.setLayout( gbLoginPanel );

      lbUser = new JLabel( "Username:"  );
      gbcLoginPanel.gridx = 0;
      gbcLoginPanel.gridy = 0;
      gbcLoginPanel.gridwidth = 1;
      gbcLoginPanel.gridheight = 1;
      gbcLoginPanel.fill = GridBagConstraints.NONE;
      gbcLoginPanel.weightx = 0;
      gbcLoginPanel.weighty = 0;
      gbcLoginPanel.anchor = GridBagConstraints.CENTER;
      gbLoginPanel.setConstraints( lbUser, gbcLoginPanel );
      pnLoginPanel.add( lbUser );

      tfUser = new JTextField( );
      gbcLoginPanel.gridx = 1;
      gbcLoginPanel.gridy = 0;
      gbcLoginPanel.gridwidth = 12;
      gbcLoginPanel.gridheight = 1;
      gbcLoginPanel.fill = GridBagConstraints.HORIZONTAL;
      gbcLoginPanel.weightx = 1;
      gbcLoginPanel.weighty = 0;
      gbcLoginPanel.anchor = GridBagConstraints.CENTER;
      gbLoginPanel.setConstraints( tfUser, gbcLoginPanel );
      pnLoginPanel.add( tfUser );

      lbPass = new JLabel( "Password:"  );
      gbcLoginPanel.gridx = 0;
      gbcLoginPanel.gridy = 2;
      gbcLoginPanel.gridwidth = 1;
      gbcLoginPanel.gridheight = 1;
      gbcLoginPanel.fill = GridBagConstraints.NONE;
      gbcLoginPanel.weightx = 0;
      gbcLoginPanel.weighty = 0;
      gbcLoginPanel.anchor = GridBagConstraints.CENTER;
      gbLoginPanel.setConstraints( lbPass, gbcLoginPanel );
      pnLoginPanel.add( lbPass );

      tfPass = new JPasswordField( );
      tfPass.setEchoChar('*');
      gbcLoginPanel.gridx = 1;
      gbcLoginPanel.gridy = 2;
      gbcLoginPanel.gridwidth = 12;
      gbcLoginPanel.gridheight = 1;
      gbcLoginPanel.fill = GridBagConstraints.HORIZONTAL;
      gbcLoginPanel.weightx = 1;
      gbcLoginPanel.weighty = 0;
      gbcLoginPanel.anchor = GridBagConstraints.CENTER;
      gbLoginPanel.setConstraints( tfPass, gbcLoginPanel );
      pnLoginPanel.add( tfPass );

      btLogin = new JButton( "Login"  );
      //btLogin.setActionCommand("login");
      gbcLoginPanel.gridx = 3;
      gbcLoginPanel.gridy = 5;
      gbcLoginPanel.gridwidth = 5;
      gbcLoginPanel.gridheight = 2;
      gbcLoginPanel.fill = GridBagConstraints.VERTICAL;
      gbcLoginPanel.weightx = 0;
      gbcLoginPanel.weighty = 0;
      gbcLoginPanel.anchor = GridBagConstraints.SOUTH;
      gbLoginPanel.setConstraints( btLogin, gbcLoginPanel );
      pnLoginPanel.add( btLogin );
      getRootPane().setDefaultButton(btLogin);
      btLogin.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            boolean found = false;
            try {
                Scanner sc = new Scanner(new File("./src/main/resources/Users.csv"));
                String line;
                String[] split;

                while (sc.hasNextLine() && !found) {
                    line = sc.nextLine();
                    split = line.split(",");

                    if (tfUser.getText().equals(split[1]) && tfPass.getText().equals(split[3])) {
                        UIDemo.user = new User(split[0], split[1], split[2], split[4], split[5]);
                        found = true;
                    }
                }
            } catch(IOException a) {
                a.printStackTrace();
            }

            if(found) {
                UIDemo.listings = new LocalListings();
            } else {
                setVisible(true);
            }
         }
      });

      btCreateAcct = new JButton( "Create Account"  );
      //btCreateAcct.setActionCommand( "createAccount" );
      gbcLoginPanel.gridx = 8;
      gbcLoginPanel.gridy = 5;
      gbcLoginPanel.gridwidth = 5;
      gbcLoginPanel.gridheight = 2;
      gbcLoginPanel.fill = GridBagConstraints.VERTICAL;
      gbcLoginPanel.weightx = 0;
      gbcLoginPanel.weighty = 0;
      gbcLoginPanel.anchor = GridBagConstraints.SOUTH;
      gbLoginPanel.setConstraints( btCreateAcct, gbcLoginPanel );
      pnLoginPanel.add( btCreateAcct );
      btCreateAcct.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            UIDemo.account = new CreateAccount();
         }
      });


      gbcMainPanel.gridx = 0;
      gbcMainPanel.gridy = 0;
      gbcMainPanel.gridwidth = 15;
      gbcMainPanel.gridheight = 10;
      gbcMainPanel.fill = GridBagConstraints.BOTH;
      gbcMainPanel.weightx = 1;
      gbcMainPanel.weighty = 0;
      gbcMainPanel.anchor = GridBagConstraints.NORTH;
      gbMainPanel.setConstraints( pnLoginPanel, gbcMainPanel );
      pnMainPanel.add( pnLoginPanel );

      setDefaultCloseOperation( EXIT_ON_CLOSE );

      setContentPane( pnMainPanel );
      pack();
      setVisible( true );
   }
} 
