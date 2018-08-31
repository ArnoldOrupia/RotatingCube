/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotating_cube;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jecihjoy
 */
public class CustomButtonPanel extends JPanel {
    
    public static JButton animateButton;
    double count = 62.84;

    public CustomButtonPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        setSize(750,100);
        
        animateButton = new JButton("Start Animation X 0.5 ");
        animateButton.setBackground(Color.decode("#1e90ff"));
        animateButton.setForeground(Color.WHITE);
        animateButton.setFont(new Font("serif", Font.BOLD, 16));
        animateButton.setBounds(230,20,250, 40);
         add(animateButton);
         
         animateButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                MainScreen.updatePanel(new RotateCube(500 - count));       
            }
        });
        
        repaint();
        setVisible(true);
    }
    
    
}
