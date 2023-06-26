package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.components.AllButton;
import Coursework2.DebitCard;
import Coursework2.components.AllComboBox;
import Coursework2.components.AllLabel;
import Coursework2.components.AllTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WithdrawFromDebitCard extends JFrame {

    AllButton b1, b2,b3;

    AllComboBox c1, c2, c3;
    AllTextField t1, t2, t3;
    AllLabel l1, l2, l3, l4, l5;


    public WithdrawFromDebitCard(ArrayList<BankCard> bankCards){
        super("Withdraw from Debit Card");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);

        l1 = new AllLabel("Withdraw from Debit Card");
        l1.setFont(new Font("Arial",Font.BOLD,30));

        l2 = new AllLabel("Card Id");
        l3 = new AllLabel("Withdrawal Amount");
        l4 = new AllLabel("PIN Number");
        l5 = new AllLabel("Date of Withdrawal");

        t1 = new AllTextField("");
        t2 = new AllTextField("");
        t3 = new AllTextField("");


        //years
        c1 = new AllComboBox(new String[]{
                "select year", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024", "2025"});
        //months
        c2 = new AllComboBox(new String[]{
                "select month",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"});
        //days
        c3 = new AllComboBox(new String[]{"select day",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"});


        b1 = new AllButton("Withdraw");
        b2 = new AllButton("Clear");
        b3 = new AllButton("Display");

        //Withdraw button
        b1.addActionListener(e -> {
            try {
                String cardId = t1.getText();
                String withdrawalAmount = t2.getText();
                String pinNumber = t3.getText();
                String dateOfWithdrawal = c1.getSelectedItem() + "-" + c2.getSelectedItem() + "-" + c3.getSelectedItem();

                if (cardId.equals("") || withdrawalAmount.equals("") || dateOfWithdrawal.equals("") || pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    int card = Integer.parseInt(cardId);
                    int withdrawal = Integer.parseInt(withdrawalAmount);
                    int pin = Integer.parseInt(pinNumber);
                    boolean foundCard = false;
                    DebitCard debitCard = null;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof DebitCard) {
                            debitCard = (DebitCard) bankCard;
                            if (debitCard.getCardId() == card) {
                                foundCard = true;
                                break;
                            }
                        }
                    }

                    if (foundCard) {
                        withdraw(debitCard, pin, withdrawal, dateOfWithdrawal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Card not found");
                    }
                }
            }catch (Exception E){
                JOptionPane.showMessageDialog(null,"Please fill all the feildcorrectly");
            }
        });

        //Clear button
        b2.addActionListener(e -> {
            clear();
        });

        //Display button
        b3.addActionListener(e -> {
            new DisplayWithdraw(bankCards);
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(l1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(l2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(l3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(t2, gbc);


        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(l4, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(t3, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(l5, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(c1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(c2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(c3, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(b2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(b1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(b3, gbc);

        add(panel);
    }

//------------------------Method to withdraw money from debit card---------------
    public  void withdraw(DebitCard debitCard,int pin,int withdrawal,String dateOfWithdrawal) {
        if (debitCard.getPinNumber() == pin) {
            if (debitCard.getBalanceAmount() < withdrawal) {
                JOptionPane.showMessageDialog(null, "Insufficient Funds");
                return;
            }
            debitCard.withdraw(withdrawal, dateOfWithdrawal, pin);
            JOptionPane.showMessageDialog(null, "Withdrawal Successful");
            clear();
        }else {
            JOptionPane.showMessageDialog(null, "Incorrect Pin Number");
        }
    }

    public void clear(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        c1.setSelectedIndex(0);
        c2.setSelectedIndex(0);
        c3.setSelectedIndex(0);
    }

}
