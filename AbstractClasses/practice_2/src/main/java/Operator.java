import java.util.concurrent.ThreadLocalRandom;

public class Operator extends Person{
    public Operator(String fullName) {
        super(fullName);
    }
    @Override
    public void setSalary() {
        this.salary = ThreadLocalRandom.current().nextDouble(30000, 50000);
    }
}
