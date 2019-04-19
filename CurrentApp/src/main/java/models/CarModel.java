package models;

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

    // Constructor with array of data
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

    @Override
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getMpgCity() {
        return mpgCity;
    }

    public void setMpgCity(int mpgCity) {
        this.mpgCity = mpgCity;
    }

    public int getMpgHighway() {
        return mpgHighway;
    }

    public void setMpgHighway(int mpgHighway) {
        this.mpgHighway = mpgHighway;
    }

    public int getMpgCombined() {
        return mpgCombined;
    }

    public void setMpgCombined(int mpgCombined) {
        this.mpgCombined = mpgCombined;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }
}
