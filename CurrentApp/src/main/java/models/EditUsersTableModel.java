package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EditUsersTableModel extends AbstractTableModel {
    private String[] column = { "Name", "Username", "Email",
            "Password", "Credit Card Type", "Card Number", "Permission Level"};
    private ArrayList<UserModel> rows;

    public EditUsersTableModel(ArrayList<UserModel> f) {
        rows = new ArrayList<>(f);
    }

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        return rows.size();
    }

    @Override
    public String getColumnName(int column) {
        return this.column[column];
    }

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

    public boolean isCellEditable(int r, int c) {
        return true;
    }

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

    public ArrayList<UserModel> getRows() {
        return rows;
    }
}