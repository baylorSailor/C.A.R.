package views;

import main.CAR;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditUsersView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private JPanel pnEditUsers;
    private JButton btSave;

    /**
     * Constructs the window for editing users within the database
     */
    public EditUsersView(JTable table) {
        super( "Edit Users" );
        log.log(Level.INFO,"Edit Users View has been instantiated");

        pnEditUsers = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnEditUsers.setBorder( BorderFactory.createTitledBorder( "Users" ) );
        pnEditUsers.setLayout( gbMainPanel );

        //Active Rental Button
        btSave = new JButton( "Save"  );
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 1;
        gbcMainPanel.gridwidth = 2;
        gbcMainPanel.gridheight = 1;
        gbcMainPanel.fill = GridBagConstraints.NONE;
        gbcMainPanel.weightx = 0;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.CENTER;
        gbMainPanel.setConstraints( btSave, gbcMainPanel );
        pnEditUsers.add( btSave );


        table.setPreferredScrollableViewportSize(new Dimension(800,70));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800,300));
        pnEditUsers.add(scrollPane);

        setContentPane( pnEditUsers );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    /**
     * Gets the Save button
     * @return A button within the Edit Users View
     */
    public JButton getBtSave() {
        return btSave;
    }
}
