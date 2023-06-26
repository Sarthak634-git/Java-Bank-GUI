package Coursework2.components;
import javax.swing.*;

public class AllTextField extends JTextField {

    public AllTextField(String text){
        super(text);
        setColumns(15);
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}
