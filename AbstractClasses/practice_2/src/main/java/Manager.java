import java.util.concurrent.ThreadLocalRandom;

public class Manager extends Person{

    public Manager(String fullName) {
        super(fullName);
        this.profit = 0.0;
        this.bonus = 0.0;
    }

    @Override
    public void setSalary() {
        double baseSalary = ThreadLocalRandom.current().nextDouble(100000, 150000);
        this.profit = ThreadLocalRandom.current().nextDouble(115000, 140000);
        this.bonus = this.profit * 0.05;
        this.salary = baseSalary;
    }
}
