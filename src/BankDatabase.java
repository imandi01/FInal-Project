import java.util.ArrayList;

public class BankDatabase {

    private ArrayList<Account> accounts;

    public BankDatabase() {

        accounts = new ArrayList<>();

        accounts.add(new Account(12345, 54321, 1000.0));
        accounts.add(new Account(98765, 56789, 500.0));
    }

    public boolean authenticateUser(int accountNumber, int pin) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber
                    && account.getPin() == pin) {

                return true;
            }
        }

        return false;
    }

    public Account getAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {

                return account;
            }
        }

        return null;
    }

    public double getBalance(int accountNumber) {

        Account account = getAccount(accountNumber);

        if (account != null) {

            return account.getBalance();
        }

        return 0;
    }

    public void withdraw(int accountNumber, double amount) {

        Account account = getAccount(accountNumber);

        if (account != null) {

            account.withdraw(amount);
        }
    }

    public void deposit(int accountNumber, double amount) {

        Account account = getAccount(accountNumber);

        if (account != null) {

            account.deposit(amount);
        }
    }
}