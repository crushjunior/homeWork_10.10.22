package transport;
import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PassengerCar oka = new PassengerCar("Лада", "Ока", 1.0, TypeOfBody.HATCHBACK);
        PassengerCar subaru = new PassengerCar("Subaru", "Impreza", 2.4, TypeOfBody.SEDAN);
        PassengerCar mitsu = new PassengerCar("Mitsubishi", "Lancer", 2.5, TypeOfBody.SEDAN);
        PassengerCar bmw = new PassengerCar("BMW", "M5", 4.4, TypeOfBody.SEDAN);

        CargoCar kamaz = new CargoCar("Камаз", "6520", 11.8, TypeWeight.N1);
        CargoCar man = new CargoCar("MAN", "TGS", 9.0, TypeWeight.N2);
        CargoCar scania = new CargoCar("Scania", "R420", 13.3, TypeWeight.N3);
        CargoCar renault = new CargoCar("Renault", "Magnum", 12.8, TypeWeight.N1);

        Bus paz = new Bus("ПАЗ", "1234", 6.6, Capacity.EXTRA_SMALL);
        Bus mers = new Bus("Mersedes", "Vito", 4.3, Capacity.EXTRA_SMALL);
        Bus kia = new Bus("KIA", "Runner", 5.1, Capacity.LARGE);
        Bus faw = new Bus("FAW", "Samurai", 3.9, Capacity.EXTRA_LARGE);

        DriverB sam = new DriverB("Самойлов Антон Матвеевич", "B", 5, subaru);
        DriverC luk = new DriverC("Лукашенко Юрий Кириллович", "С", 7, man);
        DriverD rom = new DriverD("Рязанов Олег Михайлович", "D", 25, faw);

        Sponsor sony = new Sponsor("SONY", 1_000_000);
        Sponsor lg = new Sponsor("LG", 3_000_000);
        Sponsor bq = new Sponsor("BQ", 2_000_000);

        Mechanic<Car> vitya = new Mechanic<Car>("Виктор Степанов", "AMG");
        Mechanic<Bus> sanya = new Mechanic<Bus>("Александр Соколов", "Brabus");
        Mechanic<CargoCar> oleg = new Mechanic<CargoCar>("Олег Подорожкин", "Red Bull");
        Mechanic<PassengerCar> alex = new Mechanic<PassengerCar>("Алексей Головин", "Shelby");

        Sto<Car> genergy = new Sto<>();


        subaru.addMechanic(vitya);
        subaru.addMechanic(alex);
        subaru.addSponsor(lg, bq);
        subaru.setDriver(sam);

        faw.addMechanic(vitya); faw.addMechanic(sanya);
        faw.addSponsor(sony, lg); faw.setDriver(rom);

        man.addMechanic(vitya); man.addMechanic(oleg);
        man.addSponsor(sony, bq, lg); man.setDriver(luk);



//        subaru.pitStop();
//        subaru.bestLap();
//        subaru.maxSpeed();
//        System.out.println();
//        man.pitStop();
//        man.bestLap();
//        man.maxSpeed();
//        System.out.println();
//        kia.pitStop();
//        kia.bestLap();
//        kia.maxSpeed();
//        System.out.println();
//        sam.raceInfo();
//        luk.raceInfo();
//        rom.raceInfo();
//        sam.finishGo();
//        luk.startGo();
//        rom.refuel();
//        System.out.println();
//        subaru.printType();
//        paz.printType();
//        man.printType();
//        faw.printType();
//        scania.printType();
//        System.out.println();
//        service(oka, subaru, mitsu, bmw, paz, mers, kia, renault, faw, kamaz, man, scania);
        List<Car> cars = List.of(subaru, faw, man);
        List<Sponsor> sponsors = List.of(lg, sony, bq);
        List<Mechanic> mechanics = List.of(sanya, oleg, vitya, alex);
        List<Driver> drivers = List.of(sam, rom, luk);
        System.out.println();
//        System.out.println(cars);
//        System.out.println(sponsors);
//        System.out.println(mechanics);
//        System.out.println(drivers);
        printInfo(subaru);
        System.out.println();
        printInfo(man, faw);
        System.out.println();
        genergy.addPassCar(subaru);
        genergy.addPassCar(oka);
        genergy.addPassCar(mitsu);
        genergy.addPassCar(bmw);
        System.out.println();
        genergy.addCargoCar(kamaz);
        genergy.addCargoCar(man);
        genergy.addCargoCar(scania);
        genergy.addCargoCar(renault);
        System.out.println();
        genergy.service();

    }

    private static void serviceCar(Car car) {
        try {
            if (!car.service()) {
                throw new RuntimeException("Автомобиль " + car.getBrand() + " " + car.getModel() + " не прошёл диагностику");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void service(Car... cars) {
        for (Car car : cars) {
            serviceCar(car);
        }
    }

    private static void printInfo(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() + ", ");
        System.out.println(car.getDriver() + ", ");
        System.out.println(car.getSponsors() + ", ");
        System.out.println(car.getMechanics());
    }

    private static void printInfo(Car... cars) {
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getModel() + ", ");
            System.out.println(car.getDriver() + ", ");
            System.out.println(car.getSponsors() + ", ");
            System.out.println(car.getMechanics());
            System.out.println();
        }
    }
}
