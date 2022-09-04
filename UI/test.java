package OOP_Coffee_Shop.UI;

import OOP_Coffee_Shop.menu.Menu;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.LabelUI;
import javax.swing.JButton;

public class test extends JFrame implements ItemListener, ActionListener{
    JCheckBox checkBox1, checkBox2;
    JLabel label;
    JButton button;


    public test(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,500);
        this.setTitle("OOP Coffee Shop Order App");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(172,218,129));
        // ImageIcon image = new ImageIcon("logo.png");
        // this.setIconImage(image.getImage());

        label = new JLabel("Ordering System");
        label.setBounds(110,5,600,50);
        label.setFont(new Font("Maven Pro",Font.BOLD,22));

        Menu menu = Menu.generateMenu();
        for(int i=0;i<menu.drinkList.size();i++){
            new JCheckBox(menu.toString());
            setBounds(50,50,600,50);
            setBackground(new Color(172,218,129));
            setFont(new Font("Maven Pro",Font.BOLD,15));
        }
        //checkBox1 = new JCheckBox("Capuchino \t         60000VND");
        //checkBox1.setBounds(50,50,600,50);
        //checkBox1.setBackground(new Color(172,218,129));
        //checkBox1.setFont(new Font("Maven Pro",Font.BOLD,15));

        checkBox2 = new JCheckBox("Espresso \t          70000VND");
        checkBox2.setBounds(50,100,600,50);
        checkBox2.setBackground(new Color(172,218,129));
        checkBox2.setFont(new Font("Maven Pro",Font.BOLD,15));

        button = new JButton("Place your order");
        button.setBounds(50,400,500,50);
        button.setBackground(new Color(100,218,129));
        button.setFont(new Font("Maven Pro",Font.BOLD,15));

        button.addActionListener(this);
        //checkBox1.addItemListener(this);
        //checkBox2.addItemListener(this);
        this.add(label);        
        //this.add(checkBox1);
        this.add(checkBox2);
        this.add(button);

        this.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        // TODO Auto-generated method stub
        if(evt.getSource() == checkBox1){
            label.setText("Capuchino has been " + (evt.getStateChange() == 1 ? "checked"  : "unchecked"));
        }
        else if(evt.getSource() == checkBox2){
            label.setText("Espresso has been " + (evt.getStateChange() == 1 ? "checked"  : "unchecked"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double totalPrice = 0;
        String str = "Your order summary \n\n";
        // TODO Auto-generated method stub
        if(checkBox1.isSelected()){
            totalPrice += 60000;
            str += "Capuchino :  60000VND\n";
        }

        if(checkBox2.isSelected()){
            totalPrice += 70000;
            str += "Espresso :  70000VND\n";
        }

        str += "===================\n\n";
            
        JOptionPane.showMessageDialog(this, str + " Total: " + totalPrice + " VND");

    }     
}
