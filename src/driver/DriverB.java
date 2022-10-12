package driver;

import transport.PassengerCar;

public class DriverB extends Driver<PassengerCar>{
    public DriverB(String fullName, String driverLicense, int experience, PassengerCar car) {
        super(fullName, driverLicense, experience, car);
    }
}
