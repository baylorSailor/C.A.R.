package views;

import main.CAR;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Window for requesting help pertaining to issues with the app
 */
public class HelpView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    private JPanel pnMainPanel;
    private JPanel pnHelp;
    private JLabel lbPrompt;
    private JTextArea textArea;
    private JButton btSubmit;

    /**
     * Constructs the window for the help menu
     */
    public HelpView() {
        super("Help Menu");
        log.log(Level.INFO, "Help View has been instantiated");

        pnMainPanel = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnMainPanel.setLayout( gbPanel0 );

        pnHelp = new JPanel();
        pnHelp.setBorder( BorderFactory.createTitledBorder( "Feedback" ) );
        GridBagLayout gbHelp = new GridBagLayout();
        GridBagConstraints gbcHelp = new GridBagConstraints();
        pnHelp.setLayout( gbHelp );

        lbPrompt = new JLabel( "Please enter any comments or concerns and " +
                "click Submit. We will follow up by email."  );
        gbcHelp.gridx = 2;
        gbcHelp.gridy = 3;
        gbcHelp.gridwidth = 12;
        gbcHelp.gridheight = 1;
        gbcHelp.fill = GridBagConstraints.NONE;
        gbcHelp.weightx = 1;
        gbcHelp.weighty = 1;
        gbcHelp.anchor = GridBagConstraints.CENTER;
        gbHelp.setConstraints( lbPrompt, gbcHelp );
        pnHelp.add( lbPrompt );

        textArea = new JTextArea(2,10);
        JScrollPane scpArea = new JScrollPane( textArea );
        gbcHelp.gridx = 2;
        gbcHelp.gridy = 5;
        gbcHelp.gridwidth = 12;
        gbcHelp.gridheight = 6;
        gbcHelp.fill = GridBagConstraints.BOTH;
        gbcHelp.weightx = 1;
        gbcHelp.weighty = 1;
        gbcHelp.anchor = GridBagConstraints.NORTH;
        gbHelp.setConstraints( scpArea, gbcHelp );
        pnHelp.add( scpArea );

        btSubmit = new JButton( "Submit"  );
        gbcHelp.gridx = 5;
        gbcHelp.gridy = 12;
        gbcHelp.gridwidth = 7;
        gbcHelp.gridheight = 1;
        gbcHelp.fill = GridBagConstraints.NONE;
        gbcHelp.weightx = 1;
        gbcHelp.weighty = 0;
        gbcHelp.anchor = GridBagConstraints.NORTH;
        gbHelp.setConstraints( btSubmit, gbcHelp );
        pnHelp.add( btSubmit );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 13;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( pnHelp, gbcPanel0 );
        pnMainPanel.add( pnHelp );

        setContentPane(pnMainPanel);
        setSize(550,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Gets the Submit button
     * @return A button within the Help View
     */
    public JButton getBtSubmit() {
        return btSubmit;
    }

    /**
     * Gets the TextArea containing the comment
     * @return A TextArea within the Help View
     */
    public JTextArea getTextArea() {
        return textArea;
    }
}