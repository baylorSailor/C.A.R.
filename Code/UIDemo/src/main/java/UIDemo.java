import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIDemo extends JPanel {

    public static void createAndShowGUI() {
        // Creates a new JFrame object with the given title
        JFrame frame = new JFrame("C.A.R.");
        // Allows the X button to work
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create and set up the content pane
        JPanel contentPane = new JPanel();
        // Adds the content pane to the frame
        frame.setContentPane(contentPane);
        // Creates a new menubar object
        JMenuBar menuBar = new JMenuBar();
        // Sets the minimum size of the menuBar
        menuBar.setMinimumSize(new Dimension(100,100));
        // Creates a new menu option with the given title
        JMenu menu = new JMenu("File");
        // Creates a new menu item with the given title
        JMenuItem menuItem = new JMenuItem("Save");
        // Adds a swing listner for the menuItem
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //updateTable();
            }
        });
        // Adds the menu option to the menu bar
        menuBar.add(menu);
        // Adds the menu item to the menu option
        menu.add(menuItem);
        // Adds the menuBar to the frame
        frame.setJMenuBar(menuBar);
        // Computes the size of the window
        frame.pack();
        // Puts it to the middle of the screen
        frame.setLocationRelativeTo(null);
        // Sets the visibility to true
        frame.setVisible(true);
    }

    public static Login login = null;
    public static LocalListings listings = null;
    public static CreateAccount account = null;
    public static History history = null;
    public static AccountDetails accountDetails = null;
    public static ActiveRentals activeRentals = null;
    public static User user = null;

    public static void main(String[] args) {
        //login = new Login();
        //listings = new LocalListings();
        //history = new History();
        accountDetails = new AccountDetails();
    }
}
