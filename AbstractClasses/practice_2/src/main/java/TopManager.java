public class TopManager extends Person{
     public TopManager(String fullName) {
        super(fullName);
        this.profit = 0.0;
        this.bonus = 0.0;
    }
    @Override
    public void setSalary() {
        this.salary = 500000.0;
        this.recalculateBonus(this.company.getIncome());
    }

    public void recalculateBonus(Double income) {
        if (income.compareTo(10000000.0) >= 0){
            this.bonus = this.salary * 1.5;
        } else {
            this.bonus = 0;
        }
    }
}
