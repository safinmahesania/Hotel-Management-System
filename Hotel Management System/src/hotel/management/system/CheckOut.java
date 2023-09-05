package hotel.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField txtRoomNumber,txtCustomerID,txtfirstname,txtlastname,txtbedtype,txtamount,txtphone;
    Choice reservationID;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckOut().setVisible(true);
            }
	});
    }

    public CheckOut(){
        super("Check Out");
        
	setBounds(480,200,990,670);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/checkout.jpg"));
        Image image = image_icon.getImage().getScaledInstance(750, 500,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel label = new JLabel(i);
        label.setBounds(350,100,600,500);
        add(label);
		
	JLabel checkOut = new JLabel("Check Out");
        checkOut.setBackground(new Color(0,32,63));
	checkOut.setFont(new Font("serif",Font.BOLD,36));
	checkOut.setBounds(370, 25, 440, 45);
        contentPane.add(checkOut);
       
        JLabel reserveID = new JLabel("Reservation ID:");
	reserveID.setBounds(50, 100, 100,30);
	contentPane.add(reserveID);
                
        reservationID = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from reservation");
            while(rs.next()){
                reservationID.add(rs.getString("reservation_id"));    
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
		
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 350, 150, 30);
        contentPane.add(phone);
       
        txtphone = new JTextField();
        txtphone.setBounds(170, 355, 150, 20);
        contentPane.add(txtphone);
        txtphone.setEditable(false);
        txtphone.setColumns(10);
        
        JLabel bedType = new JLabel("Bed Type:");
        bedType.setBounds(50, 400, 100,30);
        contentPane.add(bedType);
		
        txtbedtype = new JTextField();
        txtbedtype.setBounds(170, 405, 150, 20);
        contentPane.add(txtbedtype);
        txtbedtype.setEditable(false);
        txtbedtype.setColumns(10);
        
        JLabel remainingAmount = new JLabel("Pending Amount");
        remainingAmount.setBounds(50, 450, 100,30);
        contentPane.add(remainingAmount);
		
        txtamount = new JTextField();
        txtamount.setBounds(170, 455, 150, 20);
        contentPane.add(txtamount);
        txtamount.setEditable(false);
        txtamount.setColumns(10);
	
        JButton btnAutoFill = new JButton("Auto Fill");
        btnAutoFill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               conn c = new conn();
                String ID = reservationID.getSelectedItem();
                String radio;                
                try{
                    ResultSet rs = c.s.executeQuery("select * from reservation where reservation_id = '"+ID+"'");
                    rs.next();
                    txtRoomNumber.setText(rs.getString("room_number"));
                    txtCustomerID.setText(rs.getString("customer_id"));
                    txtfirstname.setText(rs.getString("firstname"));
                    txtlastname.setText(rs.getString("lastname"));
                    txtphone.setText(rs.getString("phone"));
                    txtbedtype.setText(rs.getString("bed_type"));
                    String paid = rs.getString("deposit");
                    String rno = txtRoomNumber.getText();

                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+rno);
                    rs2.next();
                    String total = rs2.getString("price");
                    int pending =  Integer. parseInt(total) - Integer. parseInt(paid);
                    txtamount.setText(Integer.toString(pending));
                }catch(SQLException ex){}
            }
        });
	
        btnAutoFill.setBounds(125, 525, 120, 30);
        btnAutoFill.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAutoFill.setBackground(new Color(0,32,63));
        btnAutoFill.setForeground(Color.white);
        contentPane.add(btnAutoFill);
		
        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
 
                String s1 = reservationID.getSelectedItem();
                String s3 = txtRoomNumber.getText();
                try{                        
                    String q1 = "delete from reservation where reservation_id = "+s1;
                    String q2 = "update room set availability = 'Available' where room_number = "+s3;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Successfully Checked Out!");
                    setVisible(false);
                }catch(SQLException e1){}
            }
        }); 
	
        btnCheckOut.setBounds(50, 565, 120, 30);
        btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCheckOut.setBackground(new Color(0,32,63));
        btnCheckOut.setForeground(Color.white);
        contentPane.add(btnCheckOut);
        
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