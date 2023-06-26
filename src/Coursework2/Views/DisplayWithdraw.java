package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayWithdraw extends JFrame {

    public DisplayWithdraw (ArrayList<BankCard> bankCards){
        super("Display Money Withdraw");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnNames = {"Card Id", "Balance", "Client Name","Pin","Date Of Withdraw", "Has Withdrawn"};
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        String[][] data = new String[debitCards.size()][6];
        for (int i = 0; i < debitCards.size(); i++) {
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][2] = String.valueOf(debitCards.get(i).getClientName());
            data[i][3] = String.valueOf(debitCards.get(i).getPinNumber());
            data[i][4] = String.valueOf(debitCards.get(i).getDateOfWithdrawal());
            data[i][5] = String.valueOf(debitCards.get(i).getHasWithdrawn());
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}
