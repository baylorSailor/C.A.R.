package views;

import adapters.DatabaseAdapter;
import models.ActiveRentalModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Displays the active rentals for the user.
 */
public class ActiveRentalsView extends JFrame {

    private JPanel pnActiveRentals;
    private JTable tbHTable;
    private final int NUM_COLS = 2;

    public static ArrayList<ActiveRentalModel> activeRentals =
            new ArrayList<>();

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

        //Read the active rentals CSV
        activeRentals = DatabaseAdapter.readActiveRentals();

        //Create the data table
        String [][]dataHTable = new String[activeRentals.size()+1][NUM_COLS];
        if(activeRentals.isEmpty()){
            dataHTable[0][0] = "No Active Rentals >:(";
        }
        else{
            for (int i = 0; i < activeRentals.size(); i++) {
                for (int j = 0; j < NUM_COLS; j++) {
                    //If first col, put vehicle string, else rental date
                    if (j == 0) {
                        dataHTable[i][j] = activeRentals.get(i).vehicleString();
                    } else {
                        dataHTable[i][j] = activeRentals.get(i).activeRentalDate();
                    }
                }
            }
        }
        String []colsHTable = new String[] {"Vehicle", "Rented On" };

        // Create table
        tbHTable = new JTable( dataHTable, colsHTable );
        tbHTable.setSelectionBackground( new Color( 212,212,212 ) );
        tbHTable.setSelectionForeground( new Color( 0,0,0 ) );
        tbHTable.setEnabled(false);

        // Add table to panel
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

        // Add rental scroll pane
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

        //Planning on adding the capability to remove active rental
        //I might be missing it but how do users return the rented
        //The cars need a solid way to go from active to past
        //Maybe add a state for the cars, gonna do this tomorrow
        //Leaving comments as a reminder
        JButton removeSelected = new JButton();
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbHTable.getSelectedRow();
                tbHTable.removeRowSelectionInterval(0,1);
            }
        };
        removeSelected.addActionListener(l);
        //pnActiveRentals.add(removeSelected);
        //End of Remove button code

        setContentPane( pnActiveRentals );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }

    ArrayList<ActiveRentalModel> getActiveRentals(){
        return activeRentals;
    }

}
