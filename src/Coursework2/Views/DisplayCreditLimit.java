package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.CreditCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayCreditLimit extends JFrame {

    public DisplayCreditLimit(ArrayList<BankCard> bankCards){
        super("Display Credit Limit");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnNames = {"Card Id", "Client Name", "Balance Amount", "CVC Number","Credit Limit","Grace Period", "Is Granted", "Card Type"};
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }
        String[][] data = new String[creditCards.size()][8];
        for (int i = 0; i < creditCards.size(); i++) {
            data[i][0] = String.valueOf(creditCards.get(i).getCardId());
            data[i][1] = String.valueOf(creditCards.get(i).getClientName());
            data[i][2] = String.valueOf(creditCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(creditCards.get(i).getCVCnumber());
            data[i][4] = String.valueOf(creditCards.get(i).getCreditLimit());
            data[i][5] = String.valueOf(creditCards.get(i).getGracePeriod());
            data[i][6] = String.valueOf(creditCards.get(i).getIsGranted());
            data[i][7] =  "Credit Card";

        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
        setVisible(true);
    }
}
