package views;

import main.CAR;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Window for login
 */
public class LoginView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    private JPanel pnLoginPanel;
    private JLabel lbUser;
    private JLabel lbPass;
    private JLabel lbError;
    private JTextField tfUser;
    private JPasswordField tfPass;
    private JButton btLogin;
    private JButton btCreateAcct;

    /**
     * Constructs the login window
     */
    public LoginView() {
        super( "Login" );
        log.log(Level.INFO,"Login View has been instantiated");
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

        lbError = new JLabel( " "  );
        gbcLoginPanel.gridx = 0;
        gbcLoginPanel.gridy = 7;
        gbcLoginPanel.gridwidth = 13;
        gbcLoginPanel.gridheight = 1;
        gbcLoginPanel.fill = GridBagConstraints.NONE;
        gbcLoginPanel.weightx = 0;
        gbcLoginPanel.weighty = 0;
        gbcLoginPanel.anchor = GridBagConstraints.WEST;
        gbLoginPanel.setConstraints( lbError, gbcLoginPanel );
        pnLoginPanel.add( lbError );
        lbError.setForeground(Color.red);


        btCreateAcct = new JButton( "Create Account"  );
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

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnLoginPanel );
        pack();
        setVisible( true );
    }

    /**
     * Gets the label error
     * @return A label displaying the error
     */
    public JLabel getLbError() {
        return lbError;
    }

    /**
     * Get the username
     * @return A textfield representing the username
     */
    public JTextField getTfUser() {
        return tfUser;
    }

    /**
     * Get the password
     * @return A textfield representing the password
     */
    public JPasswordField getTfPass() {
        return tfPass;
    }

    /**
     * Get the login button
     * @return A button for login
     */
    public JButton getBtLogin() {
        return btLogin;
    }

    /**
     * Get the create account button
     * @return A button for account creation
     */
    public JButton getBtCreateAcct() {
        return btCreateAcct;
    }
}
