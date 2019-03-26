// Andrew Case

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ModelSettings {
    // Member Variables
    private MPG mpg = null;
    private int year = 0;
    private int engCylinders = 0;
    private double volume = 0;
    private String fuelType = null;
    private String model = null;
    private String transDecript = null;
    private String VClass = null;

    // Constructor
    public ModelSettings(String[] line) {
        try {
            this.mpg = new MPG(Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[5]));
            this.engCylinders = Integer.parseInt(line[2]);
            this.volume = Double.parseDouble(line[3]);
            this.fuelType = line[4];
            this.model = line[7];
            this.transDecript = line[8];
            this.VClass = line[9];
            this.year = Integer.parseInt(line[10]);
            Set<ModelSettings> temp = new HashSet<ModelSettings>();
            temp.add(this);
        } catch (NumberFormatException e) {

        }
    }

    // MPG class
    public static class MPG {
        int city;
        int avg;
        double hwy;

        public MPG(int city, int combined, int hwy) {
            this.city = city;
            this.hwy = hwy;
            this.avg = combined;
        }

        @Override
        public String toString() {
            return "MPG = " + city + ':' + hwy + ':' + avg;
        }
    }

    // ModelSettings Member Functions
    public double getVolume() {
        return this.volume;
    }

    public String getTransDecript() {
        return this.transDecript;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public boolean VClassExists() {
        return (this.getVClass() != null);
    }

    public String getVClass() {
        return VClass;
    }

    @Override
    public String toString() {
        return  " year: " + year +
                " cylinders: " + engCylinders +
                " volume: " + volume +
                " fuelType: " + fuelType +
                " model: " + model +
                " transmission: " + transDecript +
                " Size: " + VClass + " " + mpg.toString() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelSettings that = (ModelSettings) o;
        return year == that.year &&
                engCylinders == that.engCylinders &&
                Double.compare(that.volume, volume) == 0 &&
                Objects.equals(getMpg(), that.getMpg()) &&
                Objects.equals(fuelType, that.fuelType) &&
                Objects.equals(model, that.model) &&
                Objects.equals(transDecript, that.transDecript) &&
                Objects.equals(VClass, that.VClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMpg(), year, engCylinders, volume, fuelType, model, transDecript, VClass);
    }

    public MPG getMpg() {
        return mpg;
    }

    public void setMpg(MPG mpg) {
        this.mpg = mpg;
    }


}
