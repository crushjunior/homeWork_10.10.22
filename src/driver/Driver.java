package driver;

import transport.Car;
import transport.Competing;

public abstract class Driver<D extends Car & Competing> {
    private final String fullName;
    private String driverLicense;
    private int experience;
    private D car;

    public Driver(String fullName, String driverLicense, int experience, D car) {
        if (fullName != null || !fullName.isBlank()) {
            this.fullName = fullName;
        } else {
            this.fullName = "default";
        }

        setDriverLicense(driverLicense);

        setExperience(experience);

        setCar(car);
    }

    public String getFullName() {
        return fullName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public int getExperience() {
        return experience;
    }

    public D getCar() {
        return car;
    }

    public void setDriverLicense(String driverLicense) {
        if (driverLicense == null) {
            throw new IllegalArgumentException("Необходимо указать тип прав!");
        }
            this.driverLicense = driverLicense;
    }


    public void setExperience(int experience) {
        if (experience <= 0) {
            this.experience = 1;
        } else {
            this.experience = experience;
        }
    }

    public void setCar(D car) {
        if (car != null) {
            this.car = car;
        }
    }

    public void raceInfo() {
        System.out.println("Водитель " + getFullName() + " управляет автомобилем " + car.getBrand() + " и будет участвовать в заезде.");

    }

    public void startGo() {
        System.out.println("Запускай " + car.getBrand());
    }

    public void finishGo() {
        System.out.println("Глуши " + car.getBrand());
    }

    public void refuel() {
        System.out.println("Заправь " + car.getBrand());
    }

    @Override
    public String toString() {
        return "Водитель: " + getFullName() + ", " +
                "категория прав: " + getDriverLicense() + ", " +
                "опыт: " + getExperience() + ", " +
                "автомобиль: " + getCar();
    }
}

