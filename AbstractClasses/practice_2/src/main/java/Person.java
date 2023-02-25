public abstract class Person implements Employee{
    protected Company company;
    protected String fullName;
    protected double salary;
    protected double profit;
    protected double bonus;
    protected Person(String fullName) {
        this.fullName = fullName;
        this.salary = 0.0;
    }
    @Override
    public Double getMonthSalary() {
        double scale = Math.pow(10, 2);
        return Math.ceil((salary + bonus)  * scale) / scale;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public void setSalary() {
    }

    @Override
    public double getProfit() {
        return this.profit;
    }

    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String toString() {
//        System.out.println(this.getClass().getName());
        return String.format("Person {fullName = '%s', salary = %.2f}", fullName, getMonthSalary());
    }
}
