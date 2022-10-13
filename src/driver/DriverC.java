package driver;

import transport.CargoCar;

public class DriverC extends Driver<CargoCar> {
    public DriverC(String fullName, String driverLicense, int experience, CargoCar car) {
        super(fullName, driverLicense, experience, car);
    }
}
