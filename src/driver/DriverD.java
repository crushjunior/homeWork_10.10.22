package driver;

import transport.Bus;

public class DriverD extends Driver<Bus>{
    public DriverD(String fullName, String driverLicense, int experience, Bus car) {
        super(fullName, driverLicense, experience, car);
    }
}
