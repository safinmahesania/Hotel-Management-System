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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class UpdateRoom extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private final JPanel contentPane;
    private JTextField txtprice;
    JComboBox comboBoxBedType,comboBoxAvailability,comboBoxStatus;
    JRadioButton male,female;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateRoom().setVisible(true);
            }
	});
    }

    public UpdateRoom(){
        super("Update Room");
                
	setBounds(530,200,900,450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room.jpg"));
        Image image = image_icon.getImage().getScaledInstance(500, 290,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel foregroundimage = new JLabel(i);
        foregroundimage.setBounds(360,45,500,370);
        add(foregroundimage);
		
	JLabel updateRoom = new JLabel("Update Employee");
        updateRoom.setBackground(new Color(0,32,63));
	updateRoom.setFont(new Font("serif",Font.BOLD,36));
	updateRoom.setBounds(275, 25, 440, 45);
        contentPane.add(updateRoom);
                
        JLabel roomNumber = new JLabel("Room Number:");
	roomNumber.setBounds(50, 80, 100,30);
	contentPane.add(roomNumber);
                	
        Choice txtRoomNumber = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while(rs.next()){
                txtRoomNumber.add(rs.getString("room_number"));    
            }
        }catch(SQLException e){ }
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
	        
        JLabel availability = new JLabel("Availability: ");
	availability.setBounds(50, 230, 100,30);
	contentPane.add(availability);
		
	comboBoxAvailability = new JComboBox(new String[] {"","Available","Occupied","Under Maintainance"});
	comboBoxAvailability.setBounds(170, 235, 150, 20);
        comboBoxAvailability.setBackground(Color.WHITE);
	contentPane.add(comboBoxAvailability);

        JLabel price = new JLabel("Price: ");
	price.setBounds(50, 280, 100,30);
	contentPane.add(price);
		
	txtprice = new JTextField();
	txtprice.setBounds(170, 285, 150, 20);
	contentPane.add(txtprice);
	txtprice.setColumns(10);
        
        ImageIcon image_icon_tick = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image image_tick = image_icon_tick.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon tick = new ImageIcon(image_tick);
        JButton btnTick = new JButton(tick);
        btnTick.setBounds(330,85,20,20);
        add(btnTick);
                
        btnTick.addActionListener(new ActionListener(){                   
            @Override
            public void actionPerformed(ActionEvent ae){
                conn c = new conn();
                String roomNumber = txtRoomNumber.getSelectedItem();
                try{
                    ResultSet rs = c.s.executeQuery("select * from room where room_number = '"+roomNumber+"'");
                    while(rs.next()){
                        comboBoxBedType.setSelectedItem(rs.getString("bed_type"));
                        comboBoxStatus.setSelectedItem(rs.getString("cleansing_status"));
                        comboBoxAvailability.setSelectedItem(rs.getString("availability"));                        
                        txtprice.setText(rs.getString("price"));
                    }
                }catch(SQLException e){ }
            }
        });

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
             
	        String s1 = txtRoomNumber.getSelectedItem();
                String s2 = (String) comboBoxBedType.getSelectedItem();
                String s3 = (String) comboBoxStatus.getSelectedItem();
                String s4 = (String) comboBoxAvailability.getSelectedItem();
                String s5 = txtprice.getText();
                
                try {
                    c.s.executeUpdate("update room set bed_type = '"+s2+"',cleansing_status = '"+s3+"',availability = '"+s4+"',price = '"+s5+"' where room_number = '"+s1+"'");   		
                    JOptionPane.showMessageDialog(null, "Room Updated!");
                    setVisible(false);
                } catch (SQLException ex) {
                        Logger.getLogger(UpdateRoom.class.getName()).log(Level.SEVERE, null, ex);
                } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }       
        });
	
        btnUpdate.setBounds(50,345,120,30);
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdate.setBackground(new Color(0,32,63));
        btnUpdate.setForeground(Color.white);
        contentPane.add(btnUpdate);
		
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }); 
	
        btnBack.setBounds(180,345,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}