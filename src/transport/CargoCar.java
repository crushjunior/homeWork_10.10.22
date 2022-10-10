package transport;

public class CargoCar extends Car implements Competing{
    private static final int MAX_SPEED = 222;
    private static final double BEST_LAP = 1.31;
    private TypeWeight typeWeight;

    public CargoCar(String brand, String model, Double engineVolume, TypeWeight typeWeight) {
        super(brand, model, engineVolume);
        setTypeWeight(typeWeight);
    }

    public TypeWeight getTypeWeight() {
        return typeWeight;
    }

    public void setTypeWeight(TypeWeight typeWeight) {
        this.typeWeight = typeWeight;
    }

    protected void startGo() {
        System.out.println("Проверь прицеп и стартуй!");
    }
    protected void finishGo() {
        System.out.println("Тормози плавно!");
    }

    @Override
    protected void printType() {
        if (typeWeight == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            String to = typeWeight.getTo() == null ? "" : " до " + typeWeight.getTo();
            System.out.println("Грузоподъёмность от " + typeWeight.getFrom()  + to);
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.7;
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
        System.out.println("Пит стоп!");
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
