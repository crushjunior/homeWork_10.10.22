package transport;

import java.util.LinkedList;
import java.util.Queue;

public class Sto <T extends Car>{
    private Queue<T> queue = new LinkedList<>();

    public void addPassCar(PassengerCar car) {
        queue.offer((T) car);
        System.out.println(car.getBrand() + " " + car.getModel() + " встал в очередь на ТО");
    }

    public void addCargoCar(CargoCar car) {
        queue.offer((T) car);
        System.out.println("Грузовик " + car.getBrand() + " " + car.getModel() + " встал в очередь на ТО");
    }

    public void service() {
        T car = queue.poll();
        if (car != null) {
            System.out.println(car.getBrand() + " " + car.getModel() + " прошёл ТО");
            service();
        } else {
            System.out.println("Все авто обслужены");
        }
    }
}
