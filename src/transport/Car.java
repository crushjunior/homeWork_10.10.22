package transport;

import driver.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Car {
    private final String brand;
    private final String model;
    private Double engineVolume;
    private Driver driver;
    private final List<Sponsor> sponsors = new ArrayList<>();
    private final List<Mechanic<?>> mechanics = new ArrayList<>();


    public Car(String brand, String model, Double engineVolume) {
        if (brand != null || !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }

        if (model != null || !model.isBlank()) {
            this.model = model;
        } else {
            this.model = "default";
        }

        setEngineVolume(engineVolume);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public List<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setEngineVolume(Double engineVolume) {
        if (Double.compare(engineVolume, 0) == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    protected abstract void startGo();

    protected abstract void finishGo();

    protected abstract void printType();

    public abstract boolean service();

    public abstract void repair();

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public void addMechanic(Mechanic<?> mechanic) {
        mechanics.add(mechanic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(engineVolume, car.engineVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}
