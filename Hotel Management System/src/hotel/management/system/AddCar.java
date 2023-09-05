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

public final class AddCar extends JFrame {

    Connection conn;
    PreparedStatement pst;
    private final JPanel contentPane;
    private JTextField txtCarName,txtRent;
    JComboBox txtAvailability;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddCar().setVisible(true);
            }
	});
    }

    public int autoID(){
        int txtid;
        conn c = new conn();
        try {
            ResultSet rs = c.s.executeQuery("select MAX(carid) from car");
            rs.next();
            if(rs.getInt("MAX(carid)") == 0){
                txtid = 101;
                return txtid;
            }else{
                int id = rs.getInt("MAX(carid)");
                id++;
                txtid = id;
                return txtid;
            }
        } catch (SQLException e) {}
        return 0;
    }
    
    public AddCar(){
        super("Add Car");
                
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
		
	JLabel addCar = new JLabel("Add Car");
        addCar.setBackground(new Color(0,32,63));
	addCar.setFont(new Font("serif",Font.BOLD,36));
	addCar.setBounds(350, 25, 440, 45);
        contentPane.add(addCar);
                
        JLabel id = new JLabel("ID:");
	id.setBounds(50, 80, 100,30);
	contentPane.add(id);
                
        String ID = String.valueOf(autoID());
        JLabel txtid = new JLabel(ID);
	txtid.setForeground(Color.red);
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

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
	        String s1 = ID;
                String s2 = txtCarName.getText();
                String s3 = (String) txtAvailability.getSelectedItem();
                String s4 = txtRent.getText();
                
                try {
                    c.s.executeUpdate("insert into car values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");   		
                    JOptionPane.showMessageDialog(null, "Car Added Successfully");
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(AddCar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
	
        btnAdd.setBounds(50,300,120,30);
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
	
        btnBack.setBounds(180,300,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}