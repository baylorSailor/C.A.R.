package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Window displaying rental history
 */
public class HistoryView extends JFrame {

    private JPanel pnHistory;
    private JTable tbHTable;

    /**
     * Constructs the window for rental history
     */
    public HistoryView() {
        super( "View History" );
        GridBagLayout gbMainPanel = new GridBagLayout();
        GridBagConstraints gbcMainPanel = new GridBagConstraints();

        pnHistory = new JPanel();
        pnHistory.setBorder( BorderFactory.createTitledBorder( "Previous Transactions" ) );
        GridBagLayout gbHistory = new GridBagLayout();
        GridBagConstraints gbcHistory = new GridBagConstraints();
        pnHistory.setLayout( gbMainPanel );

        //      String [][]dataHTable = new String[][] { new String[] {"11", "21"},
        //                                               new String[] {"12", "22"},
        //                                               new String[] {"13", "23"} };
        String [][]dataHTable = new String[][] { new String[] {"No History Available", " "} };
        String []colsHTable = new String[] { "", "" };
        tbHTable = new JTable( dataHTable, colsHTable );
        tbHTable.setSelectionBackground( new Color( 212,212,212 ) );
        tbHTable.setSelectionForeground( new Color( 0,0,0 ) );
        tbHTable.setEnabled(false);
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
