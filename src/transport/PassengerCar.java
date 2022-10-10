package transport;

public class PassengerCar extends Car implements Competing{
    private static final int MAX_SPEED = 268;
    private static final double BEST_LAP = 1.21;
    private TypeOfBody typeOfBody;

    public PassengerCar(String brand, String model, Double engineVolume, TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        setTypeOfBody(typeOfBody);
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    protected void startGo() {
        System.out.println("Газ в полас!");
    }
    protected void finishGo() {
        System.out.println("Тормози!");
    }

    @Override
    protected void printType() {
        if (typeOfBody == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            System.out.println("Тип кузова: " + getTypeOfBody());
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.5;
    }

    @Override
    public String toString() {
        return "Класс: " + getClass() + ", " +
                "марка: " + getBrand() +  ", " +
                "модель: " + getModel() +  ", " +
                "объём двигателя: " + getEngineVolume() +  ".";
    }

    @Override
    public void pitStop() {
        System.out.println("Здесь был пит стоп!");
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
