package Coursework2.components;

import javax.swing.*;
import java.awt.*;

public class AllComboBox extends JComboBox {

    public AllComboBox(String[] items){
        super(items);
        setFont(new java.awt.Font("Arial", 0, 15));
        setForeground(Color.black);
        setBackground(Color.white);
        setMaximumRowCount(5);
    }
}
