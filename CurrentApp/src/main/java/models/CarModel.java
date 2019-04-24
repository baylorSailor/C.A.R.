package models;

/**
 * An object representing a car
 */
public class CarModel {

    /**
     * Car price
     */
    private Integer price;

    /**
     * Car mileage
     */
    private Integer mileage;

    /**
     * Car make
     */
    private String make;

    /**
     * Car model
     */
    private String model;

    /**
     * Car fuel type
     */
    private String fuelType;

    /**
     * Car manufacture year
     */
    private Integer year;

    /**
     * Car type
     */
    private String type;

    /**
     * Car transmission
     */
    private String transmission;

    /**
     * number of cylinders
     */
    private Integer cylinders;

    /**
     * Car city mpg
     */
    private Integer mpgCity;

    /**
     * Car highway mpg
     */
    private Integer mpgHighway;

    /**
     * Car avg mpg
     */
    private Integer mpgCombined;

    /**
     * Car interior color
     */
    private String interior;

    /**
     * Car exterior color
     */
    private String exterior;

    /**
     * Car image ID for display picture
     */
    private String imageID;

    /**
     * Constructs a car given data array
     * @param data the array of attributess
     */
    public CarModel(String []data){
        this.price = Integer.parseInt(data[0]);
        this.mileage = Integer.parseInt(data[1]);
        this.make = data[2];
        this.model = data[3];
        this.fuelType = data[4];
        this.year = Integer.parseInt(data[5]);
        this.type = data[6];
        this.transmission = data[7];
        this.cylinders = Integer.parseInt(data[8]);
        this.mpgCity = Integer.parseInt(data[9]);
        this.mpgHighway = Integer.parseInt(data[10]);
        this.mpgCombined = Integer.parseInt(data[11]);
        this.interior = data[12];
        this.exterior = data[13];
        this.imageID = data[14];
    }

    /**
     * Constructs a car with given attributes
     * @param price the price
     * @param mileage the mileage
     * @param make the car make
     * @param model the car model
     * @param fuelType car's fuel type
     * @param year car year
     * @param type car type
     * @param transmission car transmission
     * @param cylinders number of cylinders
     * @param mpgCity mpg for city
     * @param mpgHighway mpg for highway
     * @param mpgCombined average mpg
     * @param interior interior color
     * @param exterior exterior color
     * @param imageID image ID of display picture
     */
    public CarModel(Integer price, Integer mileage, String make, String model,
                    String fuelType, Integer year, String type, String transmission,
                    Integer cylinders, Integer mpgCity, Integer mpgHighway, Integer mpgCombined,
                    String interior, String exterior, String imageID) {
        this.price = price;
        this.mileage = mileage;
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.year = year;
        this.type = type;
        this.transmission = transmission;
        this.cylinders = cylinders;
        this.mpgCity = mpgCity;
        this.mpgHighway = mpgHighway;
        this.mpgCombined = mpgCombined;
        this.interior = interior;
        this.exterior = exterior;
        this.imageID = imageID;
    }

    /**
     * Displays the car attributes
     * @return String representation of a car object
     */
    public String toString() {
        return price + "," + mileage + "," + make + "," + model + "," +
                fuelType + "," + year + "," + type + "," + transmission +
                "," + cylinders + "," + mpgCity + "," + mpgHighway + "," +
                mpgCombined + "," + interior + "," + exterior + "," + imageID;
    }

    /**
     * Gets price of the car
     * @return the car's price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets the price of the car
     * @param price the new price of the car
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Gets mileage of the car
     * @return the car's mileage
     */
    public Integer getMileage() {
        return mileage;
    }

    /**
     * Sets the mileage of the car
     * @param mileage the new mileage of the car
     */
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    /**
     * Gets make of the car
     * @return the car's make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the car
     * @param make the new make of the car
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets model of the car
     * @return the car's model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the car
     * @param model the new model of the car
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets fuel type of the car
     * @return the car's fuel type
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Sets the fuel type of the car
     * @param fuelType the fuel type of the car
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Gets year manufactured
     * @return the car's manufacture year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the year car manufactured
     * @param year the year of the car
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Gets type of the car
     * @return the car's type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the car
     * @param type the new type of the car
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets transmission of the car
     * @return the car's transmission
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * Sets the transmission of the car
     * @param transmission the new transmission of the car
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * Gets number of cylinder in car
     * @return number of cylinders the car has
     */
    public Integer getCylinders() {
        return cylinders;
    }

    /**
     * Sets number of cylinders for the car
     * @param cylinders the number cylinders for the car
     */
    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    /**
     * Gets city mpg of the car
     * @return the car's city mpg
     */
    public Integer getMpgCity() {
        return mpgCity;
    }

    /**
     * Sets the city mpg of the car
     * @param mpgCity the new city mpg of the car
     */
    public void setMpgCity(Integer mpgCity) {
        this.mpgCity = mpgCity;
    }

    /**
     * Gets highway mpg of the car
     * @return the car's highway mpg
     */
    public Integer getMpgHighway() {
        return mpgHighway;
    }

    /**
     * Sets the highway mpg of the car
     * @param mpgHighway the new highway mpg of the car
     */
    public void setMpgHighway(Integer mpgHighway) {
        this.mpgHighway = mpgHighway;
    }

    /**
     * Gets avg mpg of the car
     * @return the car's avg mpg
     */
    public Integer getMpgCombined() {
        return mpgCombined;
    }

    /**
     * Sets the avg mpg of the car
     * @param mpgCombined the new avg mpg of the car
     */
    public void setMpgCombined(Integer mpgCombined) {
        this.mpgCombined = mpgCombined;
    }

    /**
     * Gets interior color of the car
     * @return the car's inside color
     */
    public String getInterior() {
        return interior;
    }

    /**
     * Sets the inside color of the car
     * @param interior the new inside color of the car
     */
    public void setInterior(String interior) {
        this.interior = interior;
    }

    /**
     * Gets exterior color of the car
     * @return the car's outside color
     */
    public String getExterior() {
        return exterior;
    }

    /**
     * Sets the outside color of the car
     * @param exterior the new outside color of the car
     */
    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    /**
     * Gets exterior color of the car
     * @return the car's display photo ID
     */
    public String getImageID() {
        return imageID;
    }

    /**
     * Sets the outside color of the car
     * @param imageID the new image ID for the car's display photo
     */
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
