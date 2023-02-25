package practice;

public class BankAccount {
  private double amount = 0.00;
  public double getAmount() {
    // верните значение количества денег не счету
    return amount;
  }

  public void put(double amountToPut) {
    // метод зачисляет деньги на счет
    if (amountToPut > 0){
      amount += amountToPut;
    }
  }

  public void take(double amountToTake) {
    // метод списывает деньги со счета
    if (amountToTake <= amount){
      amount -= amountToTake;
    }
  }
}
