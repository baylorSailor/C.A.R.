package views;

import main.CAR;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditCarsView extends JFrame {

    private static Logger log = Logger.getLogger(CAR.class.getName());
    private JPanel pnEditCars;
    private JButton btSave;

    /**
     * Constructs the window for editing cars within the database
     */
    public EditCarsView(JTable table) {
        super( "Edit Cars" );
        log.log(Level.INFO,"Edit Cars View has been instantiated");

        pnEditCars = new JPanel();
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        pnEditCars.setBorder( BorderFactory.createTitledBorder( "Cars" ) );
        pnEditCars.setLayout( gbMainPanel );

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
        pnEditCars.add( btSave );


        table.setPreferredScrollableViewportSize(new Dimension(1200,70));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200,500));
        pnEditCars.add(scrollPane);

        setContentPane( pnEditCars );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    /**
     * Gets the Save button
     * @return A button within the Edit Cars View
     */
    public JButton getBtSave() {
        return btSave;
    }
}
