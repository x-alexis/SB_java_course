public class IndividualEntrepreneurClient extends Client {
    private final Double putCommission;
    private final Double putCommissionMore1000;
    public IndividualEntrepreneurClient() {
        this.name = "Индивидуальный предприниматель";
        this.amount = 0.0;
        this.putCommission = 1.0;
        this.putCommissionMore1000 = 0.5;
    }
    @Override
    public void put(double amount) {
        double currentCommission = amount /100 * (amount < 1000 ? putCommission : putCommissionMore1000);
        super.put(amount - currentCommission);
    }
}
