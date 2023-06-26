package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.CreditCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayCreditCards extends JFrame {

    public DisplayCreditCards(ArrayList<BankCard> bankCards){
        super("Display Credit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnNames = {"Card Id", "Client Name", "Issue Bnak", "Bank Account", "Balance Amount", "CVC Number", "Interest Rate", "Expiration Date", "Card Type", "Credit Limit","Grace Period","Is Granted"};
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }
        String[][] data = new String[creditCards.size()][12];
        for (int i = 0; i < creditCards.size(); i++) {
            data[i][0] = String.valueOf(creditCards.get(i).getCardId());
            data[i][1] = String.valueOf(creditCards.get(i).getClientName());
            data[i][2] = String.valueOf(creditCards.get(i).getIssuerBank());
            data[i][3] = String.valueOf(creditCards.get(i).getBankAccount());
            data[i][4] = String.valueOf(creditCards.get(i).getBalanceAmount());
            data[i][5] = String.valueOf(creditCards.get(i).getCVCnumber());
            data[i][6] = String.valueOf(creditCards.get(i).getInterestRate());
            data[i][7] = String.valueOf(creditCards.get(i).getExpirationDate());
            data[i][8] =  "Credit Card";
            data[i][9] = String.valueOf(creditCards.get(i).getCreditLimit());
            data[i][10] = String.valueOf(creditCards.get(i).getGracePeriod());
            data[i][11] = String.valueOf(creditCards.get(i).getIsGranted());

        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
        setVisible(true);
    }
}
