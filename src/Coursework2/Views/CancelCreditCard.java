package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.CreditCard;
import Coursework2.components.AllButton;
import Coursework2.components.AllLabel;
import Coursework2.components.AllTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CancelCreditCard extends JFrame {
    AllLabel l1, l2;
    AllButton b1, b2, b3;
    AllTextField t1;
    public CancelCreditCard(ArrayList<BankCard>bankCards){
        super("Cancel Credit Card");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);

        //Adding Labels
        l1 = new AllLabel("Cancel Credit Card");
        l1.setFont(new Font("Arial",Font.BOLD,30));

        l2 = new AllLabel("Card Id");

        //Text Field
        t1 = new AllTextField("");

        //Buttons
        b1 = new AllButton("Submit");
        b2 = new AllButton("Clear");
        b3 = new AllButton("Display");

        //Submit Button
        b1.addActionListener(e -> {

            try {
                String cardId = t1.getText();

                if (cardId.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the field");
                } else {
                    int card = Integer.parseInt(cardId);

                    boolean foundCard = false;
                    CreditCard creditCard = null;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof CreditCard) {
                            creditCard = (CreditCard) bankCard;
                            if (creditCard.getCardId() == card) {
                                foundCard = true;
                                break;
                            }
                        }
                    }

                    if (foundCard) {
                        cancelCreditCard(creditCard);
                        JOptionPane.showMessageDialog(null, "Credit Card successfully cancelled");
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Card not found.");
                    }
                }
            }catch (Exception E){
                JOptionPane.showMessageDialog(null, "Please fill form correctly");
            }
        });

        //Clear Button
        b2.addActionListener(e -> {
            clear();
        });

        //Display Button
        b3.addActionListener(e -> {
            new DisplayCancleCredit(bankCards);
        });

//----------------------Setting gbc for CancelCreditCard GUI -----------------------
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
        panel.add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(b2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(b3, gbc);

        add(panel);
    }

//------------------Method to cancel credit card-----------------------------
    public void cancelCreditCard(CreditCard creditCard){

        creditCard.cancelCreditCard();
    }

//-----------------Method to clear all fields----------------------------------
    public void clear(){
        t1.setText("");
    }
}
