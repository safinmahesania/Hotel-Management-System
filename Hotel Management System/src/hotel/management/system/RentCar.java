package hotel.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RentCar extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField txtRoomNumber,txtCustomerID,txtcustomername,txtcustomerPhone,txtcarname,txtdrivername,txtdriverphone,txtrent;
    JRadioButton male,female;
    Choice reservationID,driverID,carID;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RentCar().setVisible(true);
            }
	});
    }
    
    public RentCar(){
        super("Rent Car");
       
        setBounds(480,100,990,850);
        contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        /*ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/"));
        Image image = image_icon.getImage().getScaledInstance(750, 500,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel label = new JLabel(i);
        label.setBounds(350,100,600,500);
        add(label);*/
		
	JLabel rentcar = new JLabel("Rent a Car");
        rentcar.setBackground(new Color(0,32,63));
	rentcar.setFont(new Font("serif",Font.BOLD,36));
	rentcar.setBounds(370, 25, 440, 45);
        contentPane.add(rentcar);
        
        JLabel reserveID = new JLabel("Reservation ID:");
	reserveID.setBounds(50, 100, 100,30);
	contentPane.add(reserveID);
                
        reservationID = new Choice();
        try{
            conn c = new conn();
                ResultSet rs1 = c.s.executeQuery("Select * from reservation where (select count(*) from rentcar where reservation.reservation_id = rentcar.reservation_id) = 0");
                while(rs1.next()){
                    reservationID.add(rs1.getString("reservation_id"));    
                }
        }catch(SQLException e){ }     
        reservationID.setBounds(170, 105, 150, 20);
        contentPane.add(reservationID);
        	
	JLabel CustomerID = new JLabel("Customer ID:");
	CustomerID.setBounds(50, 150, 100,30);
	contentPane.add(CustomerID);
        
        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(170, 155, 150, 20);
        contentPane.add(txtCustomerID);
        txtCustomerID.setEditable(false);
        txtCustomerID.setColumns(10);        
        
        JLabel room_number = new JLabel("Room Reserved:");
	room_number.setBounds(50, 200, 100,30);
	contentPane.add(room_number);
		
        txtRoomNumber = new JTextField();
        txtRoomNumber.setBounds(170, 205, 150, 20);
        contentPane.add(txtRoomNumber);
        txtRoomNumber.setEditable(false);
        txtRoomNumber.setColumns(10);
        
	JLabel customerName = new JLabel("Customer Name:");
	customerName.setBounds(50, 250, 100,30);
	contentPane.add(customerName);
        
        txtcustomername = new JTextField();
        txtcustomername.setBounds(170, 255, 150, 20);
        contentPane.add(txtcustomername);
        txtcustomername.setEditable(false);
        txtcustomername.setColumns(10);
                                
	JLabel customerPhone = new JLabel("Customer Phone:");
	customerPhone.setBounds(50, 300, 100,30);
	contentPane.add(customerPhone);
        
        txtcustomerPhone = new JTextField();
        txtcustomerPhone.setBounds(170, 305, 150, 20);
        contentPane.add(txtcustomerPhone);
        txtcustomerPhone.setEditable(false);
        txtcustomerPhone.setColumns(10);
        
        JLabel carid = new JLabel("Car ID:");
        carid.setBounds(50, 350, 100,30);
        contentPane.add(carid);
		
        carID = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from car where availability = 'Available'");
            while(rs.next()){
                carID.add(rs.getString("carid"));    
            }
        }catch(SQLException e){ }     
        carID.setBounds(170, 355, 150, 20);
        contentPane.add(carID);
        
        JLabel carname = new JLabel("Car Name:");
        carname.setBounds(50, 400, 100,30);
        contentPane.add(carname);
		
        txtcarname = new JTextField();
        txtcarname.setBounds(170, 405, 150, 20);
        contentPane.add(txtcarname);
        txtcarname.setEditable(false);
        txtcarname.setColumns(10);
        
        JLabel availableDriver = new JLabel("Driver:");
	availableDriver.setBounds(50, 450, 100,30);
	contentPane.add(availableDriver);
                
        driverID = new Choice();
        try{
            conn c = new conn();
                ResultSet rs1 = c.s.executeQuery("Select * from employee where job = 'Driver' and (select count(*) from rentcar where employee.id = rentcar.driver_id) = 0");
                while(rs1.next()){
                    driverID.add(rs1.getString("id"));    
                }
        }catch(SQLException e){ }     
        driverID.setBounds(170, 455, 150, 20);
        contentPane.add(driverID);
        
        JLabel driverName = new JLabel("Driver Name");
        driverName.setBounds(50, 500, 100,30);
        contentPane.add(driverName);
		
        txtdrivername = new JTextField();
        txtdrivername.setBounds(170, 505, 150, 20);
        contentPane.add(txtdrivername);
        txtdrivername.setEditable(false);
        txtdrivername.setColumns(10);
        
        JLabel driverPhoneNo = new JLabel("Driver Phone:");
        driverPhoneNo.setBounds(50, 550, 100,30);
        contentPane.add(driverPhoneNo);
		
        txtdriverphone = new JTextField();
        txtdriverphone.setBounds(170, 555, 150, 20);
        contentPane.add(txtdriverphone);
        txtdriverphone.setEditable(false);
        txtdriverphone.setColumns(10);
        
        JLabel carRent = new JLabel("Car Rent");
        carRent.setBounds(50, 600, 100,30);
        contentPane.add(carRent);
		
        txtrent = new JTextField();
        txtrent.setBounds(170, 605, 150, 20);
        contentPane.add(txtrent);
        txtrent.setEditable(false);
        txtrent.setColumns(10);
	
        JButton btnAutoFill = new JButton("Auto Fill");
        btnAutoFill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               conn c = new conn();
                String ID = reservationID.getSelectedItem();
                String carid = carID.getSelectedItem();
                String driverid = driverID.getSelectedItem();
                String fname,lname,fullname;
                try{
                    ResultSet rs = c.s.executeQuery("select * from reservation where reservation_id = '"+ID+"'");
                    rs.next();
                    txtRoomNumber.setText(rs.getString("room_number"));
                    txtCustomerID.setText(rs.getString("customer_id"));
                    fname = rs.getString("firstname");
                    lname = rs.getString("lastname");
                    fullname = fname + " " + lname;
                    txtcustomername.setText(fullname);
                    txtcustomerPhone.setText(rs.getString("phone"));
                    ResultSet rs1 = c.s.executeQuery("select * from car where carid = "+carid);
                    rs1.next();
                    txtcarname.setText(rs1.getString("car_name"));
                    txtrent.setText(rs1.getString("rent"));
                    ResultSet rs2 = c.s.executeQuery("select * from employee where id = "+driverid);
                    rs2.next();
                    fname = rs2.getString("firstname");
                    lname = rs2.getString("lastname");
                    fullname = fname + " " + lname;
                    txtdrivername.setText(fullname);
                    txtdriverphone.setText(rs2.getString("phone"));
                }catch(SQLException ex){}
            }
        });
	
        btnAutoFill.setBounds(125, 660, 120, 30);
        btnAutoFill.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAutoFill.setBackground(new Color(0,32,63));
        btnAutoFill.setForeground(Color.white);
        contentPane.add(btnAutoFill);
		
        JButton viewDriver = new JButton("View Drivers");
        viewDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewDriver().setVisible(true);
            }
        }); 
	
        viewDriver.setBounds(50, 700, 120, 30);
        viewDriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
        viewDriver.setBackground(new Color(0,32,63));
        viewDriver.setForeground(Color.white);
        contentPane.add(viewDriver);
        
        JButton btnviewcar = new JButton("View Cars");
        btnviewcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCar().setVisible(true);
            }
        }); 
	
        btnviewcar.setBounds(200, 700, 120, 30);
        btnviewcar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnviewcar.setBackground(new Color(0,32,63));
        btnviewcar.setForeground(Color.white);
        contentPane.add(btnviewcar);
        
        JButton btnRent = new JButton("Rent");
        btnRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                String s1 = reservationID.getSelectedItem();
                String s2 = txtCustomerID.getText();
                String s3 = txtRoomNumber.getText();
                String s4 = txtcustomername.getText();
                String s5 = txtcustomerPhone.getText();
                String s6 = carID.getSelectedItem();
                String s7 = txtcarname.getText();        
                String s8 = driverID.getSelectedItem();
                String s9 = txtdrivername.getText();
                String s10 = txtdriverphone.getText();
                String s11 = txtrent.getText();

                try{                     
                    c.s.executeUpdate("insert into rentcar values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"')");
                    c.s.executeUpdate("update car set availability = 'Booked' where carid = "+s6);
                    JOptionPane.showMessageDialog(null, "Car Rent Successfull");
                    setVisible(false);
                }catch(SQLException e1){}
            }
        }); 
	
        btnRent.setBounds(50, 740, 120, 30);
        btnRent.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRent.setBackground(new Color(0,32,63));
        btnRent.setForeground(Color.white);
        contentPane.add(btnRent);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }); 
	
        btnClose.setBounds(200, 740, 120, 30);
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnClose.setBackground(new Color(0,32,63));
        btnClose.setForeground(Color.white);
        contentPane.add(btnClose);
                
        getContentPane().setBackground(Color.white);
    }
}