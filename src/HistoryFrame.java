import javax.swing.*;
import java.awt.*;

public class HistoryFrame extends JFrame {

    JTextArea area;

    public HistoryFrame(int accountNumber,
                        BankDatabase bankDatabase) {

        setTitle("Transaction History");

        setSize(400, 400);

        setLocationRelativeTo(null);

        area = new JTextArea();

        JScrollPane pane =
                new JScrollPane(area);

        add(pane, BorderLayout.CENTER);

        Account account =
                bankDatabase.getAccount(accountNumber);

        for (String s : account.getHistory()) {

            area.append(s + "\n");
        }

        setVisible(true);
    }
}