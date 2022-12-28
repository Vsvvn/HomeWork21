package transport;

import transport.driver.Driver;

import java.util.*;

public abstract class Transport {

    private String brand;
    private String model;
    private double engineVolume;

//    private final List<Driver<?>> drivers = new ArrayList<>();
//    private final List<Mechanic<?>> mechanics = new ArrayList<>();
//    private final List<Sponsor> sponsors = new ArrayList<>();
//
    private final Set<Driver<?>> drivers = new HashSet<>();
    private final Set<Mechanic<?>> mechanics = new HashSet<>();
    private final Set<Sponsor> sponsors = new HashSet<>();



    public Transport(String brand) {
        this(brand,
                "default",
                1.5);
    }

    public Transport(String brand, String model, double engineVolume) {

        if (brand == null && brand.isEmpty() && brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (model == null || model.isEmpty() && brand.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }

        if (engineVolume >= 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public abstract void start();

    public abstract void finish();

    public abstract void printType();

    public abstract boolean diagnostic();

    public void addDriver(Driver<?>... drivers) {
        this.drivers.addAll(Arrays.asList(drivers));
    }

    public void addMechanic(Mechanic<?>... mechanic) {
        this.mechanics.addAll(Set.of(mechanic));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Set.of(sponsors));
    }

    public abstract void repair();

    @Override
    public String toString() {
        return "Марка " + brand +
                ", модель " + model +
                ", объем двигателя — " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0
                && Objects.equals(brand, transport.brand)
                && Objects.equals(model, transport.model)
                && Objects.equals(drivers, transport.drivers)
                && Objects.equals(mechanics, transport.mechanics)
                && Objects.equals(sponsors, transport.sponsors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, drivers, mechanics, sponsors);
    }
}