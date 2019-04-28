package models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an active rental entry
 */
public class ActiveRentalModel{

    private String user;
    private String date;
    private String make;
    private String model;
    private String year;

    /**
     * Constructor for an active rental entry
     * @param us the user
     * @param SD the date
     * @param mk the make
     * @param mo the model
     * @param yr the year
     */
    public ActiveRentalModel(String us, String SD, String mk, String mo, String yr){
        user = us;
        date = SD;
        make = mk;
        model = mo;
        year = yr;
    }

    /**
     * Constructs an active rental entry
     * @param data the entry data
     */
    public ActiveRentalModel(String[] data){
        try {
            user = data[0];
            date = data[1];
            make = data[2];
            model = data[3];
            year = data[4];
        } catch (Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Number format exception");
        }
    }

    /**
     * Returns a string representation of an active rental entry
     * @return String representation of an entry
     */
    @Override
    public String toString() {
        return "ActiveRentalModel{" +
                "user='" + user + '\'' +
                ", date='" + date + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    /**
     * Vehicle string representation
     * @return Vehicle string representation
     */
    public String vehicleString(){
        return make + " " + model + " " + year;
    }

    /**
     * active rental date string representation
     * @return Rental date string representation
     */
    public String activeRentalDate() {
        return date;
    }
}
