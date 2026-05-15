public class Withdrawal extends Transaction {

    private double amount;

    public Withdrawal(int accountNumber,
                      double amount,
                      BankDatabase bankDatabase) {

        super(accountNumber, bankDatabase);

        this.amount = amount;
    }

    @Override
    public void execute() {

        bankDatabase.withdraw(accountNumber, amount);
    }
}