package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame{

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("Dashboard");
	
        setBackground(new Color(0,32,63));
        setForeground(Color.CYAN);
        setLayout(null); 

        ImageIcon image_icon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/dashboard.jpg"));
        Image image = image_icon.getImage().getScaledInstance(1320, 744,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image); 
	JLabel backgroundImage = new JLabel(i);
	backgroundImage.setBounds(0, 0, 1320, 744); 
        Component add = add(backgroundImage);
        
        ImageIcon image_icon_logo = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/dashboardlogo.png"));
        Image image_logo = image_icon_logo.getImage().getScaledInstance(252, 101,Image.SCALE_DEFAULT);
        ImageIcon logo = new ImageIcon(image_logo); 
	JLabel backgroundLogo = new JLabel(logo);
	backgroundLogo.setBounds(0, 230, 1320, 744); 
        backgroundImage.add(backgroundLogo);
        
        JLabel title = new JLabel("THE FAIRMONT GROUP WELCOMES YOU");
	//title.setForeground(new Color(173,240,209));
        title.setForeground(new Color(0,32,63));
        title.setFont(new Font("serif",Font.BOLD,40));
	title.setBounds(230, 20, 1000, 85);
	backgroundImage.add(title);
		
        JMenuBar menubar = new JMenuBar();
	setJMenuBar(menubar);
        menubar.setBackground(new Color(0,32,63));
		
        JMenu m1 = new JMenu("HOME");
        m1.setForeground(new Color(173,240,209));
	menubar.add(m1);
		
        JMenuItem logout = new JMenuItem("Home");
	m1.add(logout);
	
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
            }
	});
        
	JMenu m2 = new JMenu("ADMIN");
        m2.setForeground(new Color(173,240,209));
	menubar.add(m2);
        
        JMenuItem employee = new JMenuItem("Employees");
	m2.add(employee);
        
        employee.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                new Menu().setVisible(true);
                
            }
	});
        
        JMenuItem rooms = new JMenuItem("Rooms");
	m2.add(rooms);
        
        rooms.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                new Menu().setVisible(true);
            }
	});

        JMenuItem cars = new JMenuItem("Cars");
	m2.add(cars);
        
        cars.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                new Menu().setVisible(true);
            }
	});
        
        JMenuItem foods = new JMenuItem("Customer");
	m2.add(foods);
        
        foods.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                new Menu().setVisible(true);
            }
	});
        
        JMenu m3 = new JMenu("HOTEL MANAGEMENT");
        m3.setForeground(new Color(173,240,209));
	menubar.add(m3);
		
        JMenuItem reservation = new JMenuItem("Reservations");
	m3.add(reservation);
	
        reservation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                new ViewReservations().setVisible(true);
            }
	});
        
        JMenuItem rentCars = new JMenuItem("Rent A Car");
	m3.add(rentCars);
	
        rentCars.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                new ViewRentCar().setVisible(true);
            }
	});
        
        setSize(1320,800);
        setLocation(300, 125);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
