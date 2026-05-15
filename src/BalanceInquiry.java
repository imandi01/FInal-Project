public class BalanceInquiry extends Transaction {

    public BalanceInquiry(int accountNumber,
                          BankDatabase bankDatabase) {

        super(accountNumber, bankDatabase);
    }

    @Override
    public void execute() {

        double balance =
                bankDatabase.getBalance(accountNumber);

        System.out.println(balance);
    }
}