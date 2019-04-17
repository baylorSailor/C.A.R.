package views;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JPanel pnLoginPanel;
    private JLabel lbUser;
    private JLabel lbPass;
    private JLabel lbError;
    private JTextField tfUser;
    private JPasswordField tfPass;
    private JButton btLogin;
    private JButton btCreateAcct;

    public LoginView() {
        super( "Login" );
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

    public JLabel getLbError() {
        return lbError;
    }

    public JTextField getTfUser() {
        return tfUser;
    }

    public JPasswordField getTfPass() {
        return tfPass;
    }

    public JButton getBtLogin() {
        return btLogin;
    }

    public JButton getBtCreateAcct() {
        return btCreateAcct;
    }
}
