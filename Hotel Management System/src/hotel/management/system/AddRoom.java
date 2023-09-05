package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class AddRoom extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private final JPanel contentPane;
    private JTextField txtPrice;
    JLabel txtRoomNumber;
    JComboBox comboBoxBedType,comboBoxAvailability,comboBoxStatus;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddRoom().setVisible(true);
            }
	});
    }

    public int autoID(){
        int txtid;
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select MAX(room_number) from room");
            rs.next();
            rs.getInt("MAX(room_number)");
            if(rs.getInt("MAX(room_number)") == 0){
                txtid = 101;
                return txtid;
            }else{
                int id = rs.getInt("MAX(room_number)");
                id++;
                txtid = id;
                return txtid;
            }
        } catch (SQLException e) {}
        return 0;
    }
    
    public AddRoom(){
        super("Add Room");
                
	setBounds(530,200,900,450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room.jpg"));
        Image image = image_icon.getImage().getScaledInstance(500, 290,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel foregroundimage = new JLabel(i);
        foregroundimage.setBounds(340,45,500,370);
        add(foregroundimage);
		
	JLabel addRoom = new JLabel("Add Room");
        addRoom.setBackground(new Color(0,32,63));
	addRoom.setFont(new Font("serif",Font.BOLD,36));
	addRoom.setBounds(340, 25, 440, 45);
        contentPane.add(addRoom);
                
        JLabel roomNumber = new JLabel("Room Number");
	roomNumber.setBounds(50, 80, 100,30);
	contentPane.add(roomNumber);
                
        String ID = String.valueOf(autoID());
        JLabel txtRoomNumber = new JLabel(ID);
	txtRoomNumber.setForeground(Color.red);
        txtRoomNumber.setBounds(170, 85, 150, 20);
	contentPane.add(txtRoomNumber);
        	
	JLabel bedType = new JLabel("Bed Type:");
	bedType.setBounds(50, 130, 100,30);
	contentPane.add(bedType);
		
        comboBoxBedType = new JComboBox(new String[] {"","Single Bed","Double Bed"});
	comboBoxBedType.setBounds(170, 135, 150, 20);
        comboBoxBedType.setBackground(Color.WHITE);
	contentPane.add(comboBoxBedType);
        
        JLabel cleansingStatus = new JLabel("Cleansing Status:");
	cleansingStatus.setBounds(50, 180, 100,30);
	contentPane.add(cleansingStatus);
        
        comboBoxStatus = new JComboBox(new String[] {"","Clean","Dirty"});
	comboBoxStatus.setBounds(170,185, 150, 20);
        comboBoxStatus.setBackground(Color.WHITE);
	contentPane.add(comboBoxStatus);
		        
        JLabel availability = new JLabel("Availability:");
	availability.setBounds(50, 230, 100,30);
	contentPane.add(availability);
        
        comboBoxAvailability = new JComboBox(new String[] {"","Available","Under Maintainance"});
	comboBoxAvailability.setBounds(170, 235, 150, 20);
        comboBoxAvailability.setBackground(Color.WHITE);
	contentPane.add(comboBoxAvailability);
        
        JLabel price = new JLabel("Price:");
	price.setBounds(50, 280, 100,30);
	contentPane.add(price);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(170, 285, 150, 20);
        contentPane.add(txtPrice);
        txtPrice.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                             
	        String s1 = (String)txtRoomNumber.getText();
                String s2 = (String)comboBoxBedType.getSelectedItem();
                String s3 = (String)comboBoxStatus.getSelectedItem();
                String s4 = (String)comboBoxAvailability.getSelectedItem();
                String s5 = txtPrice.getText();
                
                try {
                    c.s.executeUpdate("insert into room values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");   		
                    JOptionPane.showMessageDialog(null, "Room Added Successfully");
                    setVisible(false);
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    
        btnAdd.setBounds(50,345,120,30);
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAdd.setBackground(new Color(0,32,63));
        btnAdd.setForeground(Color.white);
        contentPane.add(btnAdd);
		
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }); 
	
        btnBack.setBounds(200,345,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}