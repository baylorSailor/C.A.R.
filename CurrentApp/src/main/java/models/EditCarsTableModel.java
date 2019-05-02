package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a table model with editable properties
 */
public class EditCarsTableModel extends AbstractTableModel {

    /**
     * Generates the column headers
     */
    private String[] column = { "Price", "Mileage", "Make",
            "Model", "Fuel Type", "Year", "Type", "Transmission", "Cylinders",
            "City", "Highway", "Combined", "Interior", "Exterior",
            "Image ID", "State"};


    /**
     * The list of cars
     */
    private ArrayList<CarModel> rows;

    /**
     * Constructs a new list of cars for the table
     * @param f
     */
    public EditCarsTableModel(ArrayList<CarModel> f) {
        rows = new ArrayList<>(f);
    }

    /**
     * Returns the number of columns
     * @return the column count
     */
    public int getColumnCount() {
        return 16;
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
                return rows.get(rowIndex).getPrice();
            }
            case 1 : {
                return rows.get(rowIndex).getMileage();
            }
            case 2 : {
                return rows.get(rowIndex).getMake();
            }
            case 3 : {
                return rows.get(rowIndex).getModel();
            }
            case 4 : {
                return rows.get(rowIndex).getFuelType();
            }
            case 5 : {
                return rows.get(rowIndex).getYear().toString();
            }
            case 6 : {
                return rows.get(rowIndex).getType();
            }
            case 7 : {
                return rows.get(rowIndex).getTransmission();
            }
            case 8 : {
                return rows.get(rowIndex).getCylinders();
            }
            case 9 : {
                return rows.get(rowIndex).getMpgCity();
            }
            case 10 : {
                return rows.get(rowIndex).getMpgHighway();
            }
            case 11 : {
                return rows.get(rowIndex).getMpgCombined();
            }
            case 12 : {
                return rows.get(rowIndex).getInterior();
            }
            case 13 : {
                return rows.get(rowIndex).getExterior();
            }
            case 14 : {
                return rows.get(rowIndex).getImageID();
            }
            case 15 : {
                if(rows.get(rowIndex).getState() == 0) {
                    return "AVAILABLE";
                } else if(rows.get(rowIndex).getState() == 1) {
                    return "RENTED";
                } else if(rows.get(rowIndex).getState() == 2) {
                    return "RESERVED";
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
                rows.get(r).setPrice((Integer) o);
                break;
            }
            case 1 : {
                rows.get(r).setMileage((Integer) o);
                break;
            }
            case 2 : {
                rows.get(r).setMake((String) o);
                break;
            }
            case 3 : {
                rows.get(r).setModel((String)o);
                break;
            }
            case 4 : {
                rows.get(r).setFuelType((String)o);
                break;
            }
            case 5 : {
                rows.get(r).setYear((Integer) o);
                break;
            }
            case 6 : {
                rows.get(r).setType((String)o);
                break;
            }
            case 7 : {
                rows.get(r).setTransmission((String)o);
                break;
            }
            case 8 : {
                rows.get(r).setCylinders((Integer) o);
                break;
            }
            case 9 : {
                rows.get(r).setMpgCity((Integer) o);
                break;
            }
            case 10 : {
                rows.get(r).setMpgHighway((Integer) o);
                break;
            }
            case 11 : {
                rows.get(r).setMpgCombined((Integer) o);
                break;
            }
            case 12 : {
                rows.get(r).setInterior((String)o);
                break;
            }
            case 13 : {
                rows.get(r).setExterior((String)o);
                break;
            }
            case 14 : {
                rows.get(r).setImageID((String)o);
                break;
            }
            case 15 : {
                switch(o.toString()) {
                    case "AVAILABLE": {
                        rows.get(r).setState(0);
                        break;
                    }
                    case "RENTED": {
                        rows.get(r).setState(1);
                        break;
                    }
                    case "RESERVED": {
                        rows.get(r).setState(2);
                        break;
                    }
                }
            }
        }
        fireTableCellUpdated(r,c);
    }

    /**
     * Adds a new editable row
     */
    public void addRow() {
        List<String> arrayList = new ArrayList<>();
        for(int i = 0; i < getColumnCount(); i++) {
            arrayList.add("0");
        }
        String[] arr = arrayList.toArray(new String[0]);
        rows.add(new CarModel(arr));
        fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
    }

    /**
     * Removes a row
     */
    public void delRow(int index) {
        rows.remove(index);
        fireTableRowsDeleted(index,index);
    }

    /**
     * Gets the list of cars
     * @return the list of cars
     */
    public ArrayList<CarModel> getRows() {
        return rows;
    }
}