package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Services extends JFrame {
    private final JPanel contentPane;

    public static void main(String[] args) {
        new Services().setVisible(true);
    }
	
    public Services(){
        super("Services");
        
        setBounds(810, 350, 295, 250);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                        
        JLabel Services = new JLabel("Services");
	Services.setForeground(new Color(0,32,63));
        Services.setFont(new Font("serif",Font.BOLD,36));
	Services.setBounds(80, 20, 200, 30);
	contentPane.add(Services);
		
	JButton btnRentCar = new JButton("Rent a Car");
	btnRentCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RentCar().setVisible(true);
            }
        });

        btnRentCar.setBounds(40, 70, 200, 30);
        btnRentCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRentCar.setBackground(new Color(0,32,63));
        btnRentCar.setForeground(Color.WHITE);
  	contentPane.add(btnRentCar);
		
	JButton btnRoomCleaning = new JButton("Room Cleaning");
	btnRoomCleaning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RoomCleaning().setVisible(true);
            }
	});
	
        btnRoomCleaning.setBounds(40, 110, 200, 30);
        btnRoomCleaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRoomCleaning.setBackground(new Color(0,32,63));
        btnRoomCleaning.setForeground(Color.WHITE);
  	contentPane.add(btnRoomCleaning);
        	
        JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
	});
	
        btnBack.setBounds(40, 150, 200, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.WHITE);
  	contentPane.add(btnBack);
		
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }    
}