package transport;

public class Bus extends Car implements Competing{
    private static final int MAX_SPEED = 201;
    private static final double BEST_LAP = 1.36;
    private Capacity capacity;

    public Bus(String brand, String model, Double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        setCapacity(capacity);

    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    protected void startGo() {
        System.out.println("Проверь двери и газуй!");
    }
    protected void finishGo() {
        System.out.println("Тормози аккуратно, не бревна везёшь!");
    }

    @Override
    protected void printType() {
        if (capacity == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            System.out.println("Вместимость автобуса от " + capacity.getFrom() + " до " + capacity.getTo());
        }
    }

    @Override
    public boolean service() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " в диагностике не требуется");
        return true;
    }

    @Override
    public String toString() {
        return "Класс: " + getClass() + ", " +
                "марка: " + getBrand() +  ", " +
                "модель: " + getModel() +  ", " +
                "объём двмигателя: " + getEngineVolume() +  ".";
    }

    @Override
    public void pitStop() {
        System.out.println("Был пит стоп!");
    }

    @Override
    public void bestLap() {
        System.out.println("Лучшее время круга: " + BEST_LAP);
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость: " + MAX_SPEED);
    }
}
