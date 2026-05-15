public class Deposit extends Transaction {

    private double amount;

    public Deposit(int accountNumber,
                   double amount,
                   BankDatabase bankDatabase) {

        super(accountNumber, bankDatabase);

        this.amount = amount;
    }

    @Override
    public void execute() {

        bankDatabase.deposit(accountNumber, amount);
    }
}