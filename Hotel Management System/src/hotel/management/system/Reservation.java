package hotel.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservation extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField txtfirstname,txtlastname,txtbedtype,txtphone,txtdeposit;
    JComboBox comboBox;
    Choice customerID,roomNumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Reservation().setVisible(true);
            }
	});
    }

    public static int autoID(){
        int txtid;
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select MAX(reservation_id) from reservation");
            rs.next();
            rs.getString("MAX(reservation_id)");
            if(rs.getInt("MAX(reservation_id)") == 0){
                txtid = 101;
                return txtid;
            }else{
                int id = rs.getInt("MAX(reservation_id)");
                id++;
                txtid = (int)id;
                return txtid;
            }
        } catch (SQLException ex) {}
        return 0;
    }
    
    public Reservation(){
        super("Reservation");
        
	setBounds(480,200,990,670);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/reservation.jpg"));
        Image image = image_icon.getImage().getScaledInstance(750, 500,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel label = new JLabel(i);
        label.setBounds(350,100,600,500);
        add(label);
		
	JLabel reservation = new JLabel("Reservation");
        reservation.setBackground(new Color(0,32,63));
	reservation.setFont(new Font("serif",Font.BOLD,36));
	reservation.setBounds(350, 25, 440, 45);
        contentPane.add(reservation);
       
        JLabel reservationID = new JLabel("Reservation ID:");
	reservationID.setBounds(50, 100, 100,30);
	contentPane.add(reservationID);
                
        String reserveID = String.valueOf(autoID());
        JLabel txtid = new JLabel(reserveID);
	txtid.setForeground(Color.red);
        txtid.setBounds(170, 105, 150, 20);
	contentPane.add(txtid);
        	
	JLabel CustomerID = new JLabel("Customer ID:");
	CustomerID.setBounds(50, 150, 100,30);
	contentPane.add(CustomerID);
        
        customerID = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("Select * from account where (select count(*) from reservation where account.id = reservation.reservation_id) = 0 ");
            while(rs.next()){
                customerID.add(rs.getString("id"));    
            }
        }catch(SQLException e){ }     
        customerID.setBounds(170, 155, 150, 20);
        contentPane.add(customerID);        
        
        JLabel room_number = new JLabel("Available Rooms:");
	room_number.setBounds(50, 200, 100,30);
	contentPane.add(room_number);
		
        roomNumber = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available'");
            while(rs.next()){
                roomNumber.add(rs.getString("room_number"));    
            }
        }catch(SQLException e){ }     
        roomNumber.setBounds(170, 205, 150,20);
        contentPane.add(roomNumber);
        
	JLabel firstname = new JLabel("First Name:");
	firstname.setBounds(50, 250, 100,30);
	contentPane.add(firstname);
        
        txtfirstname = new JTextField();
        txtfirstname.setBounds(170, 255, 150, 20);
        contentPane.add(txtfirstname);
        txtfirstname.setEditable(false);
        txtfirstname.setColumns(10);
                                
	JLabel lastname = new JLabel("Last Name:");
	lastname.setBounds(50, 300, 100,30);
	contentPane.add(lastname);
        
        txtlastname = new JTextField();
        txtlastname.setBounds(170, 305, 150, 20);
        contentPane.add(txtlastname);
        txtlastname.setEditable(false);
        txtlastname.setColumns(10);
        
        JLabel bedType = new JLabel("Bed Type:");
        bedType.setBounds(50, 350, 100,30);
        contentPane.add(bedType);
		
        txtbedtype = new JTextField();
        txtbedtype.setBounds(170, 355, 150, 20);
        contentPane.add(txtbedtype);
        txtbedtype.setEditable(false);
        txtbedtype.setColumns(10);
        
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 400, 100,30);
        contentPane.add(phone);
		
        txtphone = new JTextField();
        txtphone.setBounds(170, 405, 150, 20);
        contentPane.add(txtphone);
        txtphone.setEditable(false);
        txtphone.setColumns(10);
        
        JLabel deposit = new JLabel("Deposit:");
        deposit.setBounds(50, 450, 100,30);
        contentPane.add(deposit);
		
        txtdeposit = new JTextField();
        txtdeposit.setBounds(170, 455, 150, 20);
        contentPane.add(txtdeposit);
        txtdeposit.setColumns(10);
	
        JButton btnAutoFill = new JButton("Auto Fill");
        btnAutoFill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               conn c = new conn();
                String custID = customerID.getSelectedItem();
                String roomID = roomNumber.getSelectedItem();
                try{
                    ResultSet rs = c.s.executeQuery("select * from account where id = '"+custID+"'");
                    rs.next();
                    txtfirstname.setText(rs.getString("firstname"));
                    txtlastname.setText(rs.getString("lastname"));
                    txtphone.setText(rs.getString("phone"));
                    ResultSet rs1 = c.s.executeQuery("select * from room where room_number = '"+roomID+"'");
                    rs1.next();
                    txtbedtype.setText(rs1.getString("bed_type"));
                }catch(SQLException ex){}
            }
        });
	
        btnAutoFill.setBounds(125, 525, 120, 30);
        btnAutoFill.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAutoFill.setBackground(new Color(0,32,63));
        btnAutoFill.setForeground(Color.white);
        contentPane.add(btnAutoFill);
		
        JButton btnReserve = new JButton("Reserve");
        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                String s1 = reserveID;
                String s2 = customerID.getSelectedItem();
                String s3 = roomNumber.getSelectedItem();
                String s4 = txtfirstname.getText();
                String s5 = txtlastname.getText();
                String s6 = txtbedtype.getText();
                String s7 = txtphone.getText();
                String s8 = txtdeposit.getText();

                try{
                    String q1 = "insert into reservation values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                    String q2 = "update room set availability = 'Occupied' where room_number = "+s3;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Reserved!");
                    setVisible(false);                 
                }catch(SQLException ez){}
            }
        }); 
	
        btnReserve.setBounds(50, 565, 120, 30);
        btnReserve.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReserve.setBackground(new Color(0,32,63));
        btnReserve.setForeground(Color.white);
        contentPane.add(btnReserve);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }); 
	
        btnBack.setBounds(200, 565, 120, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}