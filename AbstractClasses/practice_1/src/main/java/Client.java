
public abstract class Client {
    protected String name;
    protected double amount;
    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }

    public void put(double amount) {
        if (amount > 0) {
            this.amount += amount;
        }
    }

    public void take(double amount) {
        if (this.amount >= amount){
            this.amount -= amount;
        }
    }

}
