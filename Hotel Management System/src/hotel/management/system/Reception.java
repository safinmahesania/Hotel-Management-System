package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {
    private final JPanel contentPane;

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
	
    public Reception(){
        super("Reception");
        
        setBounds(530, 325, 780, 365);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/reception.jpg"));
        Image image = image_icon.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel backgroundImage = new JLabel(i);
        backgroundImage.setBounds(240,30,500,270);
        Component add = add(backgroundImage);
	
	JLabel labelReception = new JLabel("Reception");
        labelReception.setForeground(new Color(0,32,63));
	labelReception.setFont(new Font("serif",Font.BOLD,36));
	labelReception.setBounds(50, 10, 200, 50);
	contentPane.add(labelReception);

        JButton btnReserveRoom = new JButton("Reserve Room");
	btnReserveRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reservation().setVisible(true);
            }
        });
        
        btnReserveRoom.setBounds(20, 70, 200, 30);
        btnReserveRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReserveRoom.setBackground(new Color(0,32,63));
        btnReserveRoom.setForeground(Color.white);        
	contentPane.add(btnReserveRoom);
	
	JButton btnServices = new JButton("Services");
	btnServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Services().setVisible(true);
            }
	});
	
        btnServices.setBounds(20, 110, 200, 30);
        btnServices.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnServices.setBackground(new Color(0,32,63));
        btnServices.setForeground(Color.white);
	contentPane.add(btnServices);
        	
	JButton btnViewRooms = new JButton("View Rooms");
	btnViewRooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewRoom().setVisible(true);
            }
        });
	
        btnViewRooms.setBounds(20, 150, 200, 30);
        btnViewRooms.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnViewRooms.setBackground(new Color(0,32,63));
        btnViewRooms.setForeground(Color.white);
        contentPane.add(btnViewRooms);
		
	JButton btnCustomerInfo = new JButton("Customer Information");
	btnCustomerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCustomer().setVisible(true);
            }
	});
	
        btnCustomerInfo.setBounds(20, 190, 200, 30);             
        btnCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCustomerInfo.setBackground(new Color(0,32,63));
        btnCustomerInfo.setForeground(Color.white);
        contentPane.add(btnCustomerInfo);
		
        JButton btnCheckOut = new JButton("Check Out");
	btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckOut().setVisible(true);				
            }
	});
	
        btnCheckOut.setBounds(20, 230, 200, 30);
        btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCheckOut.setBackground(new Color(0,32,63));
        btnCheckOut.setForeground(Color.white);
        contentPane.add(btnCheckOut);
		
	JButton btnLogout = new JButton("Back");
	btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
	});
	
        btnLogout.setBounds(20, 270, 200, 30);
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLogout.setBackground(new Color(0,32,63));
        btnLogout.setForeground(Color.white);
        contentPane.add(btnLogout);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}