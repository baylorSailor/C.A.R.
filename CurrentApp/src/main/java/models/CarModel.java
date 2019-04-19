package models;

/**
 * An object representing a car
 */
public class CarModel {

    // Car Attributes (14 total)
    private int price;
    private int mileage;
    private String make;
    private String model;
    private String fuelType;
    private int year;
    private String type;
    private String transmission;
    private int cylinders;
    private int mpgCity;
    private int mpgHighway;
    private int mpgCombined;
    private String interior;
    private String exterior;

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
     */
    public CarModel(int price, int mileage, String make, String model,
                    String fuelType, int year, String type, String transmission,
                    int cylinders, int mpgCity, int mpgHighway, int mpgCombined,
                    String interior, String exterior) {
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
    }

    /**
     * Displays the car attributes
     * @return String representation of a car object
     */
    public String toString() {
        return "CarModel{" +
                "price=" + price +
                ", mileage=" + mileage +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", transmission='" + transmission + '\'' +
                ", cylinders=" + cylinders +
                ", mpgCity=" + mpgCity +
                ", mpgHighway=" + mpgHighway +
                ", mpgCombined=" + mpgCombined +
                ", interior='" + interior + '\'' +
                ", exterior='" + exterior + '\'' +
                '}';
    }

    /**
     * Gets price of the car
     * @return the car's price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the car
     * @param price the new price of the car
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets mileage of the car
     * @return the car's mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Sets the mileage of the car
     * @param mileage the new mileage of the car
     */
    public void setMileage(int mileage) {
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
    public int getYear() {
        return year;
    }

    /**
     * Sets the year car manufactured
     * @param year the year of the car
     */
    public void setYear(int year) {
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
    public int getCylinders() {
        return cylinders;
    }

    /**
     * Sets number of cylinders for the car
     * @param cylinders the number cylinders for the car
     */
    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    /**
     * Gets city mpg of the car
     * @return the car's city mpg
     */
    public int getMpgCity() {
        return mpgCity;
    }

    /**
     * Sets the city mpg of the car
     * @param mpgCity the new city mpg of the car
     */
    public void setMpgCity(int mpgCity) {
        this.mpgCity = mpgCity;
    }

    /**
     * Gets highway mpg of the car
     * @return the car's highway mpg
     */
    public int getMpgHighway() {
        return mpgHighway;
    }

    /**
     * Sets the highway mpg of the car
     * @param mpgHighway the new highway mpg of the car
     */
    public void setMpgHighway(int mpgHighway) {
        this.mpgHighway = mpgHighway;
    }

    /**
     * Gets avg mpg of the car
     * @return the car's avg mpg
     */
    public int getMpgCombined() {
        return mpgCombined;
    }

    /**
     * Sets the avg mpg of the car
     * @param mpgCombined the new avg mpg of the car
     */
    public void setMpgCombined(int mpgCombined) {
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
}
