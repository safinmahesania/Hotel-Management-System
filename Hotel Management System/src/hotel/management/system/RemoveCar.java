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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class RemoveCar extends JFrame {

    Connection conn;
    PreparedStatement pst;
    private final JPanel contentPane;
    private JTextField txtCarName,txtRent;
    JComboBox txtAvailability;
    JRadioButton male,female;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RemoveCar().setVisible(true);
            }
	});
    }

    public RemoveCar(){
        super("Remove Car");
                
	setBounds(530,200,900,400);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/car.jpg"));
        Image image = image_icon.getImage().getScaledInstance(500, 250,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel foregroundimage = new JLabel(i);
        foregroundimage.setBounds(340,80,500,250);
        add(foregroundimage);
		
	JLabel removeCar = new JLabel("Remove Car");
        removeCar.setBackground(new Color(0,32,63));
	removeCar.setFont(new Font("serif",Font.BOLD,36));
	removeCar.setBounds(350, 25, 440, 45);
        contentPane.add(removeCar);
                
        JLabel id = new JLabel("Car ID:");
	id.setBounds(50, 80, 100,30);
	contentPane.add(id);
                
        Choice txtid = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from car");
            while(rs.next()){
                txtid.add(rs.getString("carid"));    
            }
        }catch(SQLException e){ }
        txtid.setBounds(150, 85, 150, 20);
	contentPane.add(txtid);
        	
	JLabel carName = new JLabel("Car Name:");
	carName.setBounds(50, 130, 100,30);
	contentPane.add(carName);
		
	txtCarName = new JTextField();
	txtCarName.setBounds(150, 135, 150, 20);
	contentPane.add(txtCarName);
	txtCarName.setColumns(10);
        
        JLabel Availability = new JLabel("Availability:");
	Availability.setBounds(50, 180, 100,30);
	contentPane.add(Availability);

        txtAvailability = new JComboBox(new String[] {"","Available","Available Soon"});
	txtAvailability.setBounds(150,185, 150, 20);
        txtAvailability.setBackground(Color.WHITE);
	contentPane.add(txtAvailability);
        
        JLabel rent = new JLabel("Rent:");
	rent.setBounds(50, 230, 100,30);
	contentPane.add(rent);
		
	txtRent = new JTextField();
	txtRent.setBounds(150, 235, 150, 20);
	contentPane.add(txtRent);
	txtRent.setColumns(10);
        
        ImageIcon image_icon_tick = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image image_tick = image_icon_tick.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon tick = new ImageIcon(image_tick);
        JButton btnTick = new JButton(tick);
        btnTick.setBounds(310,85,20,20);
        add(btnTick);
                
        btnTick.addActionListener(new ActionListener(){                   
            @Override
            public void actionPerformed(ActionEvent ae){
                conn c = new conn();
                String carid = txtid.getSelectedItem();
                try{
                    ResultSet rs = c.s.executeQuery("select * from car where carid = '"+carid+"'");
                    while(rs.next()){
                        txtCarName.setText(rs.getString("car_name"));
                        txtAvailability.setSelectedItem(rs.getString("availability"));
                        txtRent.setText(rs.getString("rent"));
                    }
                }catch(SQLException e){ }
            }
        });

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
	        String s1 = txtid.getSelectedItem();
                
                try {
                    c.s.executeUpdate("delete from car where carid = '"+s1+"'");   		
                    JOptionPane.showMessageDialog(null, "Car Removed!");
                    setVisible(false);
                } catch (SQLException ex) {}

            }
        });
	
        btnRemove.setBounds(50,300,120,30);
        btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRemove.setBackground(new Color(0,32,63));
        btnRemove.setForeground(Color.white);
        contentPane.add(btnRemove);
		
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }); 
	
        btnBack.setBounds(180,300,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}