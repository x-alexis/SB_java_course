package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        this.lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        if (LocalDate.now().isAfter(this.lastIncome.plusMonths(1))){
            super.take(amountToTake);
        }
    }
}
