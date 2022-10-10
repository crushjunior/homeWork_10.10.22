package transport;
import driver.Driver;

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

        Driver<PassengerCar> sam = new Driver<>("Самойлов Антон Матвеевич", "B", 5);
        Driver<Bus> luk = new Driver<>("Лукашенко Юрий Кириллович", "С", 7);
        Driver<CargoCar> rom = new Driver<>("Рязанов Олег Михайлович", "D", 25);

        subaru.pitStop();
        subaru.bestLap();
        subaru.maxSpeed();
        System.out.println();
        man.pitStop();
        man.bestLap();
        man.maxSpeed();
        System.out.println();
        kia.pitStop();
        kia.bestLap();
        kia.maxSpeed();
        System.out.println();
        sam.raceInfo(bmw);
        luk.raceInfo(paz);
        rom.raceInfo(scania);
        sam.finishGo(oka);
        sam.startGo(subaru);
        sam.refuel(mitsu);
        System.out.println();
        subaru.printType();
        paz.printType();
        man.printType();
        faw.printType();
        scania.printType();
        System.out.println();
        service(oka, subaru, mitsu, bmw, paz, mers, kia, renault, faw, kamaz, man, scania);
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
}
