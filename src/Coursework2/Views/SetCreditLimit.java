//package Coursework2.Views;
//
//import Coursework2.BankCard;
//import Coursework2.CreditCard;
//import Coursework2.components.MyCustomButton;
//import Coursework2.components.MyCustomLabel;
//import Coursework2.components.MyCustomTextField;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class SetCreditLimit extends JFrame {
//
//    MyCustomButton b1, b2;
//    MyCustomLabel  l1, l2, l3, l4;
//
//    MyCustomTextField t1, t2, t3;
//
//    public SetCreditLimit(ArrayList<BankCard> bankCards){
//        super("Set Credit Limit");
//        setSize(800, 500);
//        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.white);
//
//        l1 = new MyCustomLabel("Set Credit Limit");
//        l1.setFont(new Font("Arial",Font.BOLD,30));
//
//        l2 = new MyCustomLabel("Card Id");
//        l3 = new MyCustomLabel("New Credit Limit");
//        l4 = new MyCustomLabel("New Grace Period");
//
//        t1 = new MyCustomTextField("");
//        t2 = new MyCustomTextField("");
//        t3 = new MyCustomTextField("");
//
//        b1 = new MyCustomButton("Set");
//        b2 = new MyCustomButton("Clear");
//
//        b1.addActionListener(e -> {
//            String cardId = t1.getText();
//            String creditLimit = t2.getText();
//            String gracePeriod = t3.getText();
//            if(cardId.equals("") || creditLimit.equals("") || gracePeriod.equals("")){
//                JOptionPane.showMessageDialog(null,"Please fill all the fields");
//            }else{
//                int card = Integer.parseInt(cardId);
//                int credit = Integer.parseInt(creditLimit);
//                int grace = Integer.parseInt(gracePeriod);
//                boolean foundCard = false;
//                CreditCard creditCard = null;
//                for(BankCard bankCard: bankCards){
//                    if(bankCard instanceof CreditCard){
//                        creditCard = (CreditCard) bankCard;
//                        if(creditCard.getCardId() == card){
//                            foundCard = true;
//                            break;
//                        }
//                    }
//                }
//
//                if(foundCard){
//                    creditLimit(creditCard,credit, grace);
//                    JOptionPane.showMessageDialog(null,"Successfully Set Credit Limit");
//                    clear();
//                }else{
//                    JOptionPane.showMessageDialog(null,"Card not found");
//                }
//            }
//        });
//
//        b2.addActionListener(e -> {
//            clear();
//        });
//
//        GridBagLayout gbl = new GridBagLayout();
//        GridBagConstraints gbc = new GridBagConstraints();
//        panel.setLayout(gbl);
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.anchor = GridBagConstraints.CENTER;
//        panel.add(l1, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 1;
//        panel.add(l2, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        panel.add(t1, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        panel.add(l3, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        panel.add(t2, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        panel.add(l4, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 3;
//        panel.add(t3, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        panel.add(b1, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 4;
//        panel.add(b2, gbc);
//
//        add(panel);
//    }
//
//    public void creditLimit(CreditCard creditCard, int credit, int grace){
//        if(credit <= 2.5*creditCard.getBalanceAmount()){
//            creditCard.setCreditLimit(credit, grace);
//        }
//    }
//    public void clear(){
//        t1.setText("");
//        t2.setText("");
//        t3.setText("");
//    }
//}


package Coursework2.Views;

import Coursework2.BankCard;
import Coursework2.CreditCard;
import Coursework2.DebitCard;
import Coursework2.components.AllButton;
import Coursework2.components.AllLabel;
import Coursework2.components.AllTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SetCreditLimit extends JFrame {

    AllButton b1, b2, b3;
    AllLabel  l1, l2, l3, l4;

    AllTextField t1, t2, t3;

    public SetCreditLimit(ArrayList<BankCard> bankCards){
        super("Set Credit Limit");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);

        l1 = new AllLabel("Set Credit Limit");
        l1.setFont(new Font("Arial",Font.BOLD,30));

        l2 = new AllLabel("Card Id");
        l3 = new AllLabel("New Credit Limit");
        l4 = new AllLabel("New Grace Period");

        t1 = new AllTextField("");
        t2 = new AllTextField("");
        t3 = new AllTextField("");

        b1 = new AllButton("Set");
        b2 = new AllButton("Clear");
        b3 = new AllButton("Display");

        // set button
        b1.addActionListener(e -> {
            try {
                String cardId = t1.getText();
                String creditLimit = t2.getText();
                String gracePeriod = t3.getText();
                if (cardId.equals("") || creditLimit.equals("") || gracePeriod.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    int card = Integer.parseInt(cardId);
                    int credit = Integer.parseInt(creditLimit);
                    int grace = Integer.parseInt(gracePeriod);
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
                        creditLimit(creditCard, credit, grace);
                        JOptionPane.showMessageDialog(null, "Successfully Set Credit Limit");
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Card not found");
                    }
                }
            }catch (Exception E){
                JOptionPane.showMessageDialog(null,"Please fill the form correctly");
            }
            });

        //clear button
        b2.addActionListener(e -> {
            clear();
        });

        //display button
        b3.addActionListener(e -> {
            new DisplayCreditLimit(bankCards);
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
        panel.add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(l3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(t2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(l4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(t3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(b2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(b3, gbc);

        add(panel);
    }

//------------------------Method for setting cedit limit---------------------
    public void creditLimit(CreditCard creditCard, int credit, int grace){
        if(credit <= 2.5*creditCard.getBalanceAmount()){
            creditCard.setCreditLimit(credit, grace);
        }
    }

    public void clear(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
    }
}
