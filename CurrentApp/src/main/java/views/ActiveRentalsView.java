package views;

import javax.swing.*;
import java.awt.*;

/**
 * Displays the active rentals for the user.
 */
public class ActiveRentalsView extends JFrame {

    private JPanel pnActiveRentals;
    private JTable tbHTable;

    /**
     * Constructor for ActiveRentals View
     */
    public ActiveRentalsView() {
        super( "View Active Rentals" );
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();

        pnActiveRentals = new JPanel();
        pnActiveRentals.setBorder( BorderFactory.createTitledBorder( "Active Rentals" ) );
        GridBagLayout gbActiveRentals = new GridBagLayout();
        GridBagConstraints gbcActiveRentals = new GridBagConstraints();
        pnActiveRentals.setLayout( gbMainPanel );

        String [][]dataHTable = new String[][] { new String[] {"No Active Rentals", " "} };
        String []colsHTable = new String[] { "", "" };
        tbHTable = new JTable( dataHTable, colsHTable );
        tbHTable.setSelectionBackground( new Color( 212,212,212 ) );
        tbHTable.setSelectionForeground( new Color( 0,0,0 ) );
        JScrollPane scpHTable = new JScrollPane( tbHTable );
        gbcActiveRentals.gridx = 0;
        gbcActiveRentals.gridy = 0;
        gbcActiveRentals.gridwidth = 15;
        gbcActiveRentals.gridheight = 10;
        gbcActiveRentals.fill = GridBagConstraints.BOTH;
        gbcActiveRentals.weightx = 0;
        gbcActiveRentals.weighty = 0;
        gbcActiveRentals.anchor = GridBagConstraints.CENTER;
        gbActiveRentals.setConstraints( scpHTable, gbcActiveRentals );
        pnActiveRentals.add( scpHTable );
        JScrollPane scpActiveRentals = new JScrollPane( pnActiveRentals );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 19;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpActiveRentals, gbcMainPanel );

        setContentPane( pnActiveRentals );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }
}
