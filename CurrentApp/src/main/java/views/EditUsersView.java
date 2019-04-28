package views;

import javax.swing.*;
import java.awt.*;

public class EditUsersView extends JFrame {

    private JPanel pnEditUsers;
    private JButton btSave;

    public EditUsersView(JTable table) {
        super( "Edit Users" );

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

    public JButton getBtSave() {
        return btSave;
    }
}
