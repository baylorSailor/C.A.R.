package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Class representing a table model with editable properties
 */
public class EditUsersTableModel extends AbstractTableModel {

    /**
     * Generates the column headers
     */
    private String[] column = { "Name", "Username", "Email",
            "Password", "Credit Card Type", "Card Number", "Permission Level"};

    /**
     * The list of users
     */
    private ArrayList<UserModel> rows;

    /**
     * Constructs a new list of users for the table
     * @param f
     */
    public EditUsersTableModel(ArrayList<UserModel> f) {
        rows = new ArrayList<>(f);
    }

    /**
     * Returns the number of columns
     * @return the column count
     */
    public int getColumnCount() {
        return 7;
    }

    /**
     * Returns the number of rows in the table (list size)
     * @return the num of rows
     */
    public int getRowCount() {
        return rows.size();
    }

    /**
     * Returns the column title
     * @param column the index of the column
     * @return The name of the column
     */
    @Override
    public String getColumnName(int column) {
        return this.column[column];
    }

    /**
     * Returns the object at a specified index
     * @param rowIndex row index
     * @param colIndex column index
     * @return The object at the specified location
     */
    public Object getValueAt(int rowIndex, int colIndex) {
        switch(colIndex) {
            case 0 : {
                return rows.get(rowIndex).getFullname();
            }
            case 1 : {
                return rows.get(rowIndex).getUsername();
            }
            case 2 : {
                return rows.get(rowIndex).getEmail();
            }
            case 3 : {
                return rows.get(rowIndex).getPassword();
            }
            case 4 : {
                return rows.get(rowIndex).getCreditType();
            }
            case 5 : {
                return rows.get(rowIndex).getCreditCard();
            }
            case 6 : {
                if(rows.get(rowIndex) instanceof AdministratorModel) {
                    return "Admin";
                }
//                else if(rows.get(rowIndex) instanceof RepresentativeModel) {
//                    return "2";
//                }
                else {
                    return "User";
                }
            }
        }
        return null;
    }

    /**
     * Determines if cell is editable
     * @param r row index
     * @param c col index
     * @return true if editable, false otherwise
     */
    public boolean isCellEditable(int r, int c) {
        return true;
    }

    /**
     * Set the value at a particular spot in the table
     * @param o the new property to set
     * @param r row index
     * @param c column index
     */
    public void setValueAt(Object o, int r, int c) {
        switch(c) {
            case 0 : {
                rows.get(r).setFullname((String)o);
                break;
            }
            case 1 : {
                rows.get(r).setUsername((String)o);
                break;
            }
            case 2 : {
                rows.get(r).setEmail((String)o);
                break;
            }
            case 3 : {
                rows.get(r).setPassword((String)o);
                break;
            }
            case 4 : {
                rows.get(r).setCreditType((String)o);
                break;
            }
            case 5 : {
                rows.get(r).setCreditCard((String)o);
                break;
            }
            case 6 : {
                if(o.toString().equals("Admin")) {
                    rows.set(r,new AdministratorModel(rows.get(r)));
                }
//                else if(rows.get(r).toString().equals("Rep")) {
//                    rows.set(r,new RepresentativeModel(rows.get(r)));
//                }
                else if(o.toString().equals("User")) {
                    rows.set(r,new UserModel(rows.get(r)));
                }
                break;
            }
        }
        fireTableCellUpdated(r,c);
    }

    /**
     * Gets the list of users
     * @return the list of users
     */
    public ArrayList<UserModel> getRows() {
        return rows;
    }
}