import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    JTextField accountField;
    JPasswordField pinField;

    JButton loginButton;

    BankDatabase bankDatabase;

    public LoginFrame() {

        bankDatabase = new BankDatabase();

        setTitle("ATM Login");
        setSize(350, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Account Number:"));

        accountField = new JTextField();

        panel.add(accountField);

        panel.add(new JLabel("PIN:"));

        pinField = new JPasswordField();

        panel.add(pinField);

        loginButton = new JButton("Login");

        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        try {

            int accountNumber =
                    Integer.parseInt(accountField.getText());

            int pin =
                    Integer.parseInt(pinField.getText());

            if (bankDatabase.authenticateUser(accountNumber, pin)) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                new MainMenuFrame(accountNumber, bankDatabase);

                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Login");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers.");
        }
    }
}