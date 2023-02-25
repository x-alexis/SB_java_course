public class CompanyClient extends Client {
    private final double takeCommission;
    public CompanyClient() {
        this.name = "Юридическое лицо";
        this.amount = 0.0;
        this.takeCommission = 1.0;
    }
    @Override
    public void take(double amount) {
        double currentCommission = amount / 100 * takeCommission;
        super.take(amount + currentCommission);
    }
}
