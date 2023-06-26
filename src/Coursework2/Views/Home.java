package Coursework2.Views;

import javax.swing.*;

import Coursework2.BankCard;
import Coursework2.components.AllButton;

import java.awt.*;
import java.util.ArrayList;


public class Home extends JFrame {
    ArrayList<BankCard> bankCards = new ArrayList<>();
    AllButton b1, b2, b3, b4, b5, b6;
    public Home(){
//-------------------CALL the superclass constructor of JFrame----------------------------
        super("SBK Bank");
        JFrame f = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
//        setResizable(false);

//-------------------------Creating JPanel-----------------------------------
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);

//---------------------------------header and label---------------------------
        JPanel header = new JPanel();
        header.setBackground(new java.awt.Color(0, 204, 153));
        header.setBounds(10,10,770,60);

        JLabel hlabel = new JLabel("SBK Bank");
        hlabel.setFont(new Font("Arial",Font.BOLD,40));
        hlabel.setBounds(450,5,200,10);
        hlabel.setForeground(Color.white);
        header.add(hlabel);

//--------------------------Setting image---------------------------------------
        JLabel imgLabel = new JLabel(new ImageIcon("D:\\Informatics\\Second Semester CourseWork\\22069078-Sarthak-Thapa\\Development\\src\\Coursework2\\real.png"));
        imgLabel.setBounds(10,60,400, 400);
        panel.add(imgLabel);

        JLabel head = new JLabel("Welcome");
        head.setFont(new Font("Arial",Font.BOLD,30));
        head.setBounds(515,80,200,40);
        panel.add(head);

//------------------Setting up buttons------------------------------------------------
        b1 = new AllButton("Add Debit Card");
        b1.setBounds(415,130,180,50);

        b2 = new AllButton("Add Credit Card");
        b2.setBounds(600,130,180,50);

        b3 = new AllButton("Withdraw from Debit Card");
        b3.setBounds(505,270,200,50);

        b4 = new AllButton("Set the credit limit");
        b4.setBounds(415,200,180,50);

        b5 = new AllButton("Cancel credit card");
        b5.setBounds(600,200,180,50);

        b6 = new AllButton("Display");
        b6.setBounds(505,340,200,50);

//-----------------------------Adding action listener to the button------------------
        b1.addActionListener(e -> {
            new AddDebitCard(bankCards);
        });

        b2.addActionListener(e -> {
            new AddCreditCard(bankCards);
        });

        b3.addActionListener(e -> {
            new WithdrawFromDebitCard(bankCards);
        });

        b4.addActionListener(e -> {
            new SetCreditLimit(bankCards);
        });

        b5.addActionListener(e -> {
            new CancelCreditCard(bankCards);
        });

        b6.addActionListener(e -> {
            new Display(bankCards);
        });

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        setVisible(true);
        panel.add(header);
        add(panel);

    }
}
