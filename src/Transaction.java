public abstract class Transaction {

    protected int accountNumber;
    protected BankDatabase bankDatabase;

    public Transaction(int accountNumber,
                       BankDatabase bankDatabase) {

        this.accountNumber = accountNumber;
        this.bankDatabase = bankDatabase;
    }

    public abstract void execute();
}