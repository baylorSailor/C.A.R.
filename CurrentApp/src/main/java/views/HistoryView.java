package views;

import adapters.DatabaseAdapter;
import models.HistoryModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Window displaying rental history
 */
public class HistoryView extends JFrame {

    private JPanel pnHistory;
    private JTable tbHTable;
    private final int NUM_COLS = 2;

    private ArrayList<HistoryModel> rentalHistory;

    /**
     * Constructs the window for rental history
     */
    public HistoryView() {

        // Set Layout
        super( "View History" );
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();

        //Create history panel
        pnHistory = new JPanel();
        pnHistory.setBorder( BorderFactory.createTitledBorder( "Previous Rentals" ) );
        GridBagLayout gbHistory = new GridBagLayout();
        GridBagConstraints gbcHistory = new GridBagConstraints();
        pnHistory.setLayout( gbMainPanel );

        //Read the history CSV
        rentalHistory = DatabaseAdapter.readHistory();

        // Store rental history into table
        String [][]dataHTable = new String[rentalHistory.size()+1][NUM_COLS];
        if(rentalHistory.isEmpty()) {
            dataHTable[0][0] = "No rentals yet :(";
        }
        for(int i = 0; i < rentalHistory.size(); i++){
            for(int j = 0; j < NUM_COLS; j++){
                //If first col, put vehicle string, else rental date
                if(j == 0){
                    dataHTable[i][j] = rentalHistory.get(i).vehicleString();
                }
                else{
                    dataHTable[i][j] = rentalHistory.get(i).rentalDateString();
                }
            }
        }

        // Column header titles
        String []colsHTable = new String[] { "Vehicle", "Rental Date" };


        tbHTable = new JTable( dataHTable, colsHTable );
        tbHTable.setSelectionBackground( new Color( 212,212,212 ) );
        tbHTable.setSelectionForeground( new Color( 0,0,0 ) );
        tbHTable.setEnabled(false);

        // Adds the table
        JScrollPane scpHTable = new JScrollPane( tbHTable );
        gbcHistory.gridx = 0;
        gbcHistory.gridy = 0;
        gbcHistory.gridwidth = 15;
        gbcHistory.gridheight = 10;
        gbcHistory.fill = GridBagConstraints.BOTH;
        gbcHistory.weightx = 0;
        gbcHistory.weighty = 0;
        gbcHistory.anchor = GridBagConstraints.CENTER;
        gbHistory.setConstraints( scpHTable, gbcHistory );
        pnHistory.add( scpHTable );

        //Adds scroll pane
        JScrollPane scpHistory = new JScrollPane( pnHistory );
        gbcMainPanel.gridx = 1;
        gbcMainPanel.gridy = 10;
        gbcMainPanel.gridwidth = 19;
        gbcMainPanel.gridheight = 10;
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.weightx = 1;
        gbcMainPanel.weighty = 0;
        gbcMainPanel.anchor = GridBagConstraints.NORTH;
        gbMainPanel.setConstraints( scpHistory, gbcMainPanel );

        setContentPane( pnHistory );
        pack();
        setLocationRelativeTo(null);
        setVisible( true );
    }
}
