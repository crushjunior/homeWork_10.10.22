import Data.Data;

public class Main {
    public static void main(String[] args) {
boolean test = Data.validate("test", "testik", "test");
        if (test) {
            System.out.println("Данные верны");
        } else {
            System.out.println("Данные НЕ верны");
        }

    }
}
