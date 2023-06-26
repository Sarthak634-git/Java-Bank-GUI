package Coursework2.Views;

import Coursework2.BankCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;

public class Display extends JFrame {
    JTable table;
    public Display(ArrayList<BankCard> bankCards){
        super("Display");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type"};
        String[][] data = new String[bankCards.size()][5];
        for (int i = 0; i < bankCards.size(); i++) {
            data[i][0] = String.valueOf(bankCards.get(i).getCardId());
            data[i][1] = String.valueOf(bankCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(bankCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(bankCards.get(i).getClientName());
            data[i][4] = bankCards.get(i) instanceof Coursework2.DebitCard ? "Debit Card" : "Credit Card";
        }
        table = new JTable(data, columnNames);
        table.setBackground(Color.white);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(800, 500));

//------------------To make the text in table allign in center----------------------------
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);


        panel.add(scrollPane);
        add(panel);
    }
}
