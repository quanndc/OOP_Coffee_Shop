package OOP_Coffee_Shop.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;
import OOP_Coffee_Shop.menu.Menu;


public class OrderSuggestion implements ChangeListener {
    public OrderSuggestion() {
        JFrame frame = new JFrame("Recommended System");
        java.util.List<String> tastes = Arrays.asList("Sweet", "Bitter", "Salty", "Sour");

        java.util.List<Double> tasteValues = Arrays.asList(0.0,0.0,0.0,0.0);
        
        frame.setSize(420,420);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        for (int i = 0; i < tastes.size(); i++) {
            JPanel panel = new JPanel();
            panel.setBounds(10,i*100,100,70);
            JLabel label = new JLabel();
            label.setText(tastes.get(i));
            JSlider slider = new JSlider(0, 10,0);
            slider.setPreferredSize(new Dimension(300, 50));
            slider.setPaintTicks(true);
            slider.setMinorTickSpacing(1);

            slider.setPaintTrack(true);
            slider.setMajorTickSpacing(10);

            slider.setPaintLabels(true);

            slider.setOrientation(SwingConstants.HORIZONTAL);
            slider.setName(tastes.get(i));
            panel.add(slider);
            panel.add(label);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider slider = ((JSlider) e.getSource());
                    switch(slider.getName()){
                        case "Sweet":
                            tasteValues.set(0, slider.getValue()*1.0);
                            break;
                        case "Bitter":
                            tasteValues.set(1, slider.getValue()*1.0);
                            break;
                        case "Salty":
                            tasteValues.set(2, slider.getValue()*1.0);
                            break;
                        case "Sour":
                            tasteValues.set(3, slider.getValue()*1.0);
                    }
                }
                
            });
            frame.add(panel);
        }
        frame.setVisible(true);

        OOP_Coffee_Shop.menu.Menu menu = Menu.generateMenu();
        JButton button = new JButton("Get suggestion");
        button.setBounds(50,400,500,50);
        button.setBackground(new Color(100,218,129));
        button.setFont(new Font("Maven Pro",Font.BOLD,15));
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your suggestion is: \n");
            }
        });
        frame.add(button);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

}
