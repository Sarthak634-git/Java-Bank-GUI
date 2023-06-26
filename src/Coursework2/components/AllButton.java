package Coursework2.components;

import javax.swing.*;
import java.awt.*;

public class AllButton extends JButton {

    public AllButton(String text){
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(true);
        setFont(new java.awt.Font("Arial", 0, 15));
        setForeground(Color.white);
        setBackground(new java.awt.Color(0, 204, 153));
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}
