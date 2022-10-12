package transport;

public class Mechanic<C extends Car>{
    private final String fullName;
    private final String company;

    public Mechanic(String fullName, String company) {
        this.fullName = fullName;
        this.company = company;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public boolean service(C c) {
        return c.service();
    }

    public void repair(C c) {
        c.repair();
    }

    @Override
    public String toString() {
        return "Механик " + getFullName() + " " +
                "из компании: " + getCompany();
    }
}
