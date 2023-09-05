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
import javax.swing.JTextField;

public final class RemoveCustomer extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private final JPanel contentPane;
    private JTextField txtfirstname,txtlastname,txtage,txtemail,txtphone;
    JComboBox comboBox,txtgender;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RemoveCustomer().setVisible(true);
            }
	});
    }

    public RemoveCustomer(){
        super("Remove Customer");
                
	setBounds(600, 300, 650, 550);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/signup.png"));
        Image image = image_icon.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel foregroundimage = new JLabel(i);
        foregroundimage.setBounds(325,10,300,500);
        add(foregroundimage);
		
	JLabel removeCustomer = new JLabel("Remove Customer");
        removeCustomer.setBackground(new Color(0,32,63));
	removeCustomer.setFont(new Font("serif",Font.BOLD,36));
	removeCustomer.setBounds(40, 15, 300, 55);
	contentPane.add(removeCustomer);
                
        JLabel id = new JLabel("ID:");
	id.setBounds(50, 110, 100,30);
	contentPane.add(id);
                
        Choice txtid = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from account");
            while(rs.next()){
                txtid.add(rs.getString("id"));    
            }
        }catch(SQLException e){ }
        txtid.setBounds(150, 115, 150, 20);
	contentPane.add(txtid);
        	
	JLabel firstName = new JLabel("First Name:");
	firstName.setBounds(50, 150, 100,30);
	contentPane.add(firstName);
		
	txtfirstname = new JTextField();
	txtfirstname.setBounds(150, 155, 150, 20);
	contentPane.add(txtfirstname);
	txtfirstname.setColumns(10);
        
        JLabel lastName = new JLabel("Last Name:");
	lastName.setBounds(50, 190, 100,30);
	contentPane.add(lastName);
		
	txtlastname = new JTextField();
	txtlastname.setBounds(150, 195, 150, 20);
	contentPane.add(txtlastname);
	txtlastname.setColumns(10);

        JLabel age = new JLabel("Age:");
	age.setBounds(50, 230, 100,30);
	contentPane.add(age);
		
	txtage = new JTextField();
	txtage.setBounds(150, 235, 150, 20);
	contentPane.add(txtage);
	txtage.setColumns(10);

	JLabel gender = new JLabel("Gender:");
	gender.setBounds(50, 270, 100,30);
	contentPane.add(gender);
                
        String choice[] = {"","Male","Female"};
        txtgender = new JComboBox(choice);
        txtgender.setBackground(Color.WHITE);
        txtgender.setBounds(150,285,150,20);
        contentPane.add(txtgender);
                		
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 310, 100,30);
        contentPane.add(email);
						
        txtemail = new JTextField();
        txtemail.setBounds(150, 315, 150, 20);
        contentPane.add(txtemail);
        txtemail.setColumns(10);
        
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 350, 100,30);
        contentPane.add(phone);
						
        txtphone = new JTextField();
        txtphone.setBounds(150, 355, 150, 20);
        contentPane.add(txtphone);
        txtphone.setColumns(10);
        
        ImageIcon image_icon_tick = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image image_tick = image_icon_tick.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon tick = new ImageIcon(image_tick);
        JButton btnTick = new JButton(tick);
        btnTick.setBounds(310,115,20,20);
        add(btnTick);
                
        btnTick.addActionListener(new ActionListener(){                   
            @Override
            public void actionPerformed(ActionEvent ae){
                conn c = new conn();
                String id = txtid.getSelectedItem();
                try{
                    ResultSet rs = c.s.executeQuery("select * from account where id = '"+id+"'");
                    while(rs.next()){
                        txtfirstname.setText(rs.getString("firstname"));
                        txtlastname.setText(rs.getString("lastname"));
                        txtage.setText(rs.getString("age"));                        
                        txtgender.setSelectedItem(rs.getString("gender"));
                        txtemail.setText(rs.getString("email"));
                        txtphone.setText(rs.getString("phone"));
                    }
                }catch(SQLException e){ }
            }
        });

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
	            String s1 = txtid.getSelectedItem();
                    String q1 = "delete from account where id = '"+s1+"'";
                    c.s.executeUpdate(q1);	
                    JOptionPane.showMessageDialog(null, "Customer Removed");
                    setVisible(false);
                }catch(SQLException ee){
                    System.out.println(ee.getMessage());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
	
        btnRemove.setBounds(50,420,120,30);
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
	
        btnBack.setBounds(180,420,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.WHITE);
    }
}