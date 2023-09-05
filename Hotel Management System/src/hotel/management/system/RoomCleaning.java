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

public final class RoomCleaning extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private final JPanel contentPane;
    private JTextField txtroomnumber;
    JComboBox comboBoxBedType,comboBoxAvailability,comboBoxStatus;
    JRadioButton male,female;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoomCleaning().setVisible(true);
            }
	});
    }
    
    public RoomCleaning(){
        super("Room Cleaning");
                
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
		
	JLabel roomCleaning = new JLabel("Room Cleaning");
        roomCleaning.setBackground(new Color(0,32,63));
	roomCleaning.setFont(new Font("serif",Font.BOLD,36));
	roomCleaning.setBounds(275, 25, 440, 45);
        contentPane.add(roomCleaning);
        
        JLabel reserveID = new JLabel("Reservation ID:");
	reserveID.setBounds(50, 80, 100,30);
	contentPane.add(reserveID);
                
        Choice reservationID = new Choice();
        try{
            conn c = new conn();
                ResultSet rs1 = c.s.executeQuery("select reservation_id from reservation");
                while(rs1.next()){
                    reservationID.add(rs1.getString("reservation_id"));    
                }
            //}
        }catch(SQLException e){ }     
        reservationID.setBounds(170, 85, 150, 20);
        contentPane.add(reservationID);
                
        JLabel roomNumber = new JLabel("Room Number:");
	roomNumber.setBounds(50, 130, 100,30);
	contentPane.add(roomNumber);
		
	txtroomnumber = new JTextField();
	txtroomnumber.setBounds(170, 135, 150, 20);
	contentPane.add(txtroomnumber);
        txtroomnumber.setEditable(false);
	txtroomnumber.setColumns(10);
        
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
                String rNumber = reservationID.getSelectedItem();
                try{
                    ResultSet rs = c.s.executeQuery("select * from reservation where reservation_id = '"+rNumber+"'");
                    while(rs.next()){
                        txtroomnumber.setText(rs.getString("room_number"));
                    }
                }catch(SQLException e){ }
            }
        });

        JButton btnRequest = new JButton("Request");
        btnRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
             
	        String s1 = reservationID.getSelectedItem();
                String s2 = txtroomnumber.getText();
                
                try {
                    c.s.executeUpdate("update room set cleansing_status = 'Dirty' where room_number = '"+s2+"'");   		
                    JOptionPane.showMessageDialog(null, "Request Sent!");
                    setVisible(false);
                } catch (SQLException ex) {
                        Logger.getLogger(UpdateRoom.class.getName()).log(Level.SEVERE, null, ex);
                } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }       
        });
	
        btnRequest.setBounds(50,345,120,30);
        btnRequest.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRequest.setBackground(new Color(0,32,63));
        btnRequest.setForeground(Color.white);
        contentPane.add(btnRequest);
		
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