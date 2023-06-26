package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.CreditCard;
import Coursework2.components.AllButton;
import Coursework2.components.AllComboBox;
import Coursework2.components.AllLabel;
import Coursework2.components.AllTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCreditCard extends JFrame {
    AllTextField t1, t2, t3, t4, t5, t6, t7, t8;
    AllComboBox c1, c2, c3;
    AllLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    AllButton b1, b2, b3;
    public AddCreditCard(ArrayList<BankCard> bankCards){
        super("Add Credit Card");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        l1 = new AllLabel("Add Credit Card");
        l1.setFont(new Font("Arial",Font.BOLD,30));

        l2 = new AllLabel("Card Id");
        l3 = new AllLabel("Client Name");
        l4 = new AllLabel("Issue Bank");
        l5 = new AllLabel("Bank Account");
        l6 = new AllLabel("Balance Amount");
        l7 = new AllLabel("CVC Number");
        l8 = new AllLabel("Interest Rate");
        l9 = new AllLabel("Expiration Date");

        t1 = new AllTextField("");
        t2 = new AllTextField("");
        t3 = new AllTextField("");
        t4 = new AllTextField("");
        t5 = new AllTextField("");
        t6 = new AllTextField("");
        t7 = new AllTextField("");
        t8 = new AllTextField("");

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

        //buttons
        b1 = new AllButton("Add");
        b2 = new AllButton("Clear");
        b3 = new AllButton("Display");



        //add button
        b1.addActionListener(e -> {
            try {
                String cardId = t1.getText();
                String clientName = t2.getText();
                String issueBank = t3.getText();
                String bankAccount = t4.getText();
                String balanceAmount = t5.getText();
                String cvcNumber = t6.getText();
                String interestRate = t7.getText();

                if (cardId.equals("") || clientName.equals("") || issueBank.equals("") || bankAccount.equals("") || balanceAmount.equals("") || cvcNumber.equals("") || interestRate.equals("")
                        || c1.getSelectedItem().equals("select year") || c2.getSelectedItem().equals("select month") || c3.getSelectedItem().equals("select day")
                ) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    int card = Integer.parseInt(cardId);
                    double balance = Double.parseDouble(balanceAmount);
                    int cvc = Integer.parseInt(cvcNumber);
                    double interest = Double.parseDouble(interestRate);
                    String expirationDate = c1.getSelectedItem() + "-" + c2.getSelectedItem() + "-" + c3.getSelectedItem();
                    CreditCard creditCard = new CreditCard(card, clientName, issueBank, bankAccount, balance, cvc, interest, expirationDate);
                    bankCards.add(creditCard);
                    JOptionPane.showMessageDialog(null, "Credit Card added successfully");
                    clear();
                }
            }catch(Exception E){
                JOptionPane.showMessageDialog(null,"Please fill all the field correctly");
            }
        });

        //clear button
        b2.addActionListener(e -> {
            clear();
        });

        //Display Button
        b3.addActionListener(e -> {
            new DisplayCreditCards(bankCards);
        });


//----------------------------Setting gbc for AddCreditCard GUI-----------------------
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

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(l3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(t2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(l4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(t3, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(l5, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(t4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(l6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(t5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(l7, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(t6, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(l8, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(t7, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(l9, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(c1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(c2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(c3, gbc);


        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(b1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(b2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(b3, gbc);

        add(panel);
    }

    public void clear(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        c1.setSelectedIndex(0);
        c2.setSelectedIndex(0);
        c3.setSelectedIndex(0);
    }
}
