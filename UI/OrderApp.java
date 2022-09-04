package OOP_Coffee_Shop.UI;

import OOP_Coffee_Shop.drinks.Drinks;
import OOP_Coffee_Shop.menu.Menu;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OrderApp extends JFrame {
    JLabel label1;
    JLabel label2;
    JButton purchaseButton;
    JButton suggestButton;
    JFrame frame = new JFrame("OOP Coffee Shop Order App");

    public OrderApp() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(172, 218, 129));

        label1 = new JLabel("Ordering System");
        label1.setBounds(10, 5, 600, 50);
        label1.setFont(new Font("Maven Pro", Font.BOLD, 22));

        label2 = new JLabel("Recommeded System");
        label2.setBounds(500, 5, 400, 50);
        label2.setFont(new Font("Maven Pro", Font.BOLD, 22));
        ArrayList<String> tastes = new ArrayList<>();
        tastes.add("Sweet");
        tastes.add("Bitter");
        tastes.add("Salty");
        tastes.add("Sour");
        java.util.List<Double> tasteValues = Arrays.asList(0.0, 0.0, 0.0, 0.0);

        for (int i = 0; i < tastes.size(); i++) {
            JPanel panel = new JPanel();
            panel.setBounds(450, 50 + 50 * i, 300, 50);
            JLabel label = new JLabel();
            label.setText(tastes.get(i));
            JSlider slider = new JSlider(0, 10, 0);
            slider.setPreferredSize(new Dimension(200, 50));
            slider.setBackground(new Color(172, 218, 129));
            slider.setPaintTicks(true);
            slider.setMinorTickSpacing(1);

            slider.setPaintTrack(true);
            slider.setMajorTickSpacing(10);

            slider.setPaintLabels(true);
            slider.setFont(new Font("Maven Pro", Font.BOLD, 15));
            label.setFont(new Font("Maven Pro", Font.BOLD, 15));

            slider.setOrientation(SwingConstants.HORIZONTAL);
            slider.setName(tastes.get(i));
            panel.add(slider);
            panel.add(label);
            panel.setBackground(new Color(172, 218, 129));
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider slider = ((JSlider) e.getSource());
                    switch (slider.getName()) {
                        case "Sweet":
                            tasteValues.set(0, slider.getValue() * 1.0);
                            break;
                        case "Bitter":
                            tasteValues.set(1, slider.getValue() * 1.0);
                            break;
                        case "Salty":
                            tasteValues.set(2, slider.getValue() * 1.0);
                            break;
                        case "Sour":
                            tasteValues.set(3, slider.getValue() * 1.0);
                    }
                }
            });
            frame.add(panel);
        }

        OOP_Coffee_Shop.menu.Menu menu = Menu.generateMenu();
        suggestButton = new JButton("Get suggestion");
        suggestButton.setBounds(450, 400, 300, 40);
        suggestButton.setBackground(new Color(100, 218, 129));
        suggestButton.setFont(new Font("Maven Pro", Font.BOLD, 15));
        suggestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<Distance> distances = new ArrayList<>();
                for (Drinks drink : menu.drinkList) {
                    distances.add(new Distance(Math.sqrt(Math.pow(drink.getSweetLevel() - tasteValues.get(0), 2.0)
                            + Math.pow(drink.getBitterLevel() - tasteValues.get(1), 2.0) +
                            Math.pow(drink.getSaltyLevel() - tasteValues.get(2), 2.0) +
                            Math.pow(drink.getSourLevel() - tasteValues.get(3), 2.0)), drink));
                }

                distances.sort(new Comparator<Distance>() {
                    @Override
                    public int compare(Distance o1, Distance o2) {
                        if(o1.getDistances() < o2.getDistances()){
                            return -1;
                        }
                        else if(o1.getDistances() > o2.getDistances()){
                            return 1;
                        }
                        return 0;
                    }
                });
                JOptionPane.showMessageDialog(null, "Your suggestion is: \n" 
                                            + distances.get(0).getDrink().getName() 
                                            + "     " 
                                            + distances.get(0).getDrink().totalPrice()
                                            + " VND");
                                            
    }});

        ArrayList<Drinks> cart = new ArrayList();
        for (int j = 0; j < menu.drinkList.size(); j++) {
            DrinkCheckbox checkBoxDrink = new DrinkCheckbox(menu.drinkList.get(j));
            checkBoxDrink.setBounds(10, 50 + 50 * j, 230, 50);
            checkBoxDrink.setBackground(new Color(172, 218, 129));
            checkBoxDrink.setFont(new Font("Maven Pro", Font.BOLD, 15));
            checkBoxDrink.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    DrinkCheckbox checkbox = (DrinkCheckbox) e.getSource();
                    if (e.getStateChange() == e.SELECTED) {
                        cart.add(checkbox.getDrink());
                    } else {
                        cart.remove(checkbox.getDrink());
                    }
                }
            });
            frame.add(checkBoxDrink);
        }

        purchaseButton = new JButton("Place your order");
        purchaseButton.setBounds(10, 400, 300, 40);
        purchaseButton.setBackground(new Color(100, 218, 129));
        purchaseButton.setFont(new Font("Maven Pro", Font.BOLD, 15));
        purchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                String recipt = "";
                for (int i = 0; i < cart.size(); i++) {
                    recipt += cart.get(i).getName() + "     \t" + cart.get(i).totalPrice() + " VND" + "\n";
                    total += cart.get(i).totalPrice();
                }
                recipt += "Total:       " + total + " VND";
                JOptionPane.showMessageDialog(null, recipt);
            }
        });

        frame.add(label1);
        frame.add(label2);
        frame.add(purchaseButton);
        frame.add(suggestButton);
        frame.setIconImage(new ImageIcon("D:/Tu_Hoc_JAVA/OOP_Coffee_Shop/logo.png").getImage());
        frame.setVisible(true);
    }
}
