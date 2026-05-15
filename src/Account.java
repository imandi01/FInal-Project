import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private int pin;
    private double balance;

    private ArrayList<String> history;

    public Account(int accountNumber, int pin, double balance) {

        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;

        history = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {

        balance -= amount;

        history.add("Withdraw: $" + amount);
    }

    public void deposit(double amount) {

        balance += amount;

        history.add("Deposit: $" + amount);
    }

    public ArrayList<String> getHistory() {

        return history;
    }
}