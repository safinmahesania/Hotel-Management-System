package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    JLabel backgroundImage;
    JButton btnNext;
        
    public HotelManagementSystem() {
        super("Hotel Management System");
        
        setSize(1366,430);
        setLayout(null);
        setLocation(300,300);

	backgroundImage = new JLabel("");
        btnNext = new JButton("Next");
                
        btnNext.setBackground(new Color(0,32,63));
        btnNext.setForeground(Color.white);
                
        ImageIcon image_icon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/home.jpg"));
        Image image = image_icon.getImage().getScaledInstance(1366, 390, Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        backgroundImage = new JLabel(i);
                
        JLabel title = new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setBounds(20,290,1500,100);
        title.setFont(new Font("serif",Font.BOLD,72));
        title.setForeground(Color.white);
        backgroundImage.add(title);
                
        btnNext.setBounds(1200, 320, 110, 40);
	backgroundImage.setBounds(0, 0, 1366, 390);
                
        backgroundImage.add(btnNext);
	add(backgroundImage);
 
        btnNext.addActionListener(this);
        setVisible(true);
    }
            
    @Override
    public void actionPerformed(ActionEvent ae){
        new Home().setVisible(true);
        this.setVisible(false);
    }
        
    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);			
    }
}