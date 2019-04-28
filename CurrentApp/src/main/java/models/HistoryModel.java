package models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a rental history entry
 */
public class HistoryModel {

    private String user;
    private String startDate;
    private String endDate;
    private String make;
    private String model;
    private String year;

    /**
     * Constructor for a rental history entry
     * @param us the user
     * @param SD the start date
     * @param ED the end date
     * @param mk the make
     * @param mo the model
     * @param yr the year
     */
    public HistoryModel(String us, String SD, String ED, String mk, String mo, String yr){
        user = us;
        startDate = SD;
        endDate = ED;
        make = mk;
        model = mo;
        year = yr;
    }

    /**
     * Constructs a rental history entry
     * @param data the entry data
     */
    public HistoryModel(String[] data){
        try {
            user = data[0];
            startDate = data[1];
            endDate = data[2];
            make = data[3];
            model = data[4];
            year = data[5];
        } catch (Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Number format exception");
        }
    }

    /**
     * Returns a string representation of a rental history entry
     * @return String representation of an entry
     */
    @Override
    public String toString() {
        return "HistoryModel{" +
                "user='" + user + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
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
     * Rental date string representation
     * @return Rental date string representation
     */
    public String rentalDateString(){
        return startDate + " to " + endDate;
    }

    /**
     * Gets the username
     * @return the username
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the username
     * @param user new username
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the start date
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date
     * @param startDate new start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date
     * @return the end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date
     * @param endDate new end date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the make
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make
     * @param make new make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the mode
     * @param model new model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the year
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the year
     * @param year new year
     */
    public void setYear(String year) {
        this.year = year;
    }
}
