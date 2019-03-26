// Andrew Case

import java.util.*;

public class Make implements Comparable<Make> {

    // Member Variables
    private String brand = null;
    private static int identifier = 0;
    private int identity;
    private Set<ModelSettings> models;

    // Constructor
    Make(String brand2, ModelSettings models2) {
        this.brand = brand2;
        this.models = new HashSet<>();
        this.models.add(models2);
        this.identifier++;
        this.identity = identifier++;
    }

    // Functions
    public boolean containsVClass(String v) {
        for(ModelSettings i : models) {
            if(i.VClassExists()) {
                if(i.getVClass().equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int numOfSettings() {
        return (models.size());
    }

    public String getBrand() {
        return brand;
    }

    public int compareTo(Make other) {
        return this.brand.compareToIgnoreCase(other.brand);
    }

    public Set<ModelSettings> getModels() {
        return models;
    }

    public void setModels(ModelSettings models) {
        this.models.add(models);
    }

    @Override
    public String toString() {
        ArrayList<ModelSettings> list = new ArrayList<>();
        list.addAll(models);

        try {
            list.sort(Comparator.comparingDouble(x -> x.getVolume()));
            list.sort(Comparator.comparing(ModelSettings::getTransDecript));
            list.sort(Comparator.comparingInt(x -> x.getYear()));
        } catch (NullPointerException e) { }

        return "brand='" + brand + '\'' +
                ", identity=" + identity +
                ", models=" + '\n' + list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Make make = (Make) o;
        return Objects.equals(brand, make.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }
}