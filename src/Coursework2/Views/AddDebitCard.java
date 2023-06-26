package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.DebitCard;
import Coursework2.components.AllButton;
import Coursework2.components.AllLabel;
import Coursework2.components.AllTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddDebitCard extends JFrame {
    AllTextField t1, t2, t3, t4, t5, t6;
    AllButton b1, b2, b3;
    AllLabel l1, l2, l3, l4, l5, l6, l7;
    public AddDebitCard(ArrayList<BankCard> bankCards){
        super("Add Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);


        JPanel panel = new JPanel();
        panel.setBackground(Color.white);

//-----------------------Setting all labels-------------------------
        l1 = new AllLabel("Add Debit Card");
        l1.setFont(new Font("Arial", Font.BOLD,30));

        l2 = new AllLabel("Balance Amount");
        l3 = new AllLabel("Card Id");
        l4 = new AllLabel("Bank Account");
        l5 = new AllLabel("Issue Bank");
        l6 = new AllLabel("Client Name");
        l7 = new AllLabel("Pin Number");

//----------------Setting all text fields---------------------------
        t1 = new AllTextField("");
        t2 = new AllTextField("");
        t3 = new AllTextField("");
        t4 = new AllTextField("");
        t5 = new AllTextField("");
        t6 = new AllTextField("");

//--------------------Adding buttons --------------------------------
        b1 = new AllButton("Add");
        b2 = new AllButton("Clear");
        b3 = new AllButton("Display");

        b1.addActionListener(e -> {
            try {
                String balanceAmount = t1.getText();
                String cardId = t2.getText();
                String bankAccount = t3.getText();
                String issueBank = t4.getText();
                String clientName = t5.getText();
                String pinNumber = t6.getText();

                if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issueBank.equals("") || clientName.equals("") || pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    double balance = Double.parseDouble(balanceAmount);
                    int card = Integer.parseInt(cardId);
                    int pin = Integer.parseInt(pinNumber);
                    DebitCard debitCard = new DebitCard(card, issueBank, bankAccount, balanceAmount, clientName, pin);
                    bankCards.add(debitCard);
                    JOptionPane.showMessageDialog(null, "Debit Card added successfully");
                    clear();
                }
            }catch(Exception E){
                JOptionPane.showMessageDialog(null,"Please fill all the fields correctly");
                }

        });

        b2.addActionListener(e -> {
            clear();
        });

        b3.addActionListener(e -> {
            new DisplayDebitCards(bankCards);
        });


//-----------------------------Setting up Gbc for AddDebitCard--------------------------
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
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
        panel.add(t1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(l3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(t2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(l4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(t3, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(l5, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(t4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(l6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(t5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(l7, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(t6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(b1, gbc);


        gbc.gridx = 2;
        gbc.gridy = 8;
        panel.add(b2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 8;
        panel.add(b3, gbc);

        add(panel);
    }

    public void clear() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
    }
}
