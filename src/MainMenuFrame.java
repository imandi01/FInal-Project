import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private int accountNumber;

    private BankDatabase bankDatabase;

    public MainMenuFrame(int accountNumber,
                         BankDatabase bankDatabase) {

        this.accountNumber = accountNumber;

        this.bankDatabase = bankDatabase;

        setTitle("ATM Main Menu");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton balanceButton =
                new JButton("View Balance");

        JButton withdrawButton =
                new JButton("Withdraw");

        JButton depositButton =
                new JButton("Deposit");

        JButton historyButton =
                new JButton("Transaction History");

        JButton exitButton =
                new JButton("Exit");

        panel.add(balanceButton);

        panel.add(withdrawButton);

        panel.add(depositButton);

        panel.add(historyButton);

        panel.add(exitButton);

        add(panel);

        balanceButton.addActionListener(e -> showBalance());

        withdrawButton.addActionListener(e -> withdraw());

        depositButton.addActionListener(e -> deposit());

        historyButton.addActionListener(
                e -> new HistoryFrame(accountNumber, bankDatabase)
        );

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void showBalance() {

        double balance =
                bankDatabase.getBalance(accountNumber);

        JOptionPane.showMessageDialog(this,
                "Current Balance: $" + balance);
    }

    private void withdraw() {

        String input =
                JOptionPane.showInputDialog(
                        "Enter withdrawal amount:"
                );

        double amount =
                Double.parseDouble(input);

        Withdrawal withdrawal =
                new Withdrawal(accountNumber,
                        amount,
                        bankDatabase);

        withdrawal.execute();

        JOptionPane.showMessageDialog(this,
                "Withdrawal Successful");
    }

    private void deposit() {

        String input =
                JOptionPane.showInputDialog(
                        "Enter deposit amount:"
                );

        double amount =
                Double.parseDouble(input);

        Deposit deposit =
                new Deposit(accountNumber,
                        amount,
                        bankDatabase);

        deposit.execute();

        JOptionPane.showMessageDialog(this,
                "Deposit Successful");
    }
}