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

public final class AddCustomer extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private final JPanel contentPane;
    private JTextField txtfirstname,txtlastname,txtage,txtemail,txtphone;
    JComboBox txtgender;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddCustomer().setVisible(true);
            }
	});
    }

    public int autoID(){
        int txtid;
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select MAX(id) from account");
            rs.next();
            if(rs.getInt("MAX(id)") == 0){
                txtid = 101;
                return txtid;
            }else{
                int id = rs.getInt("MAX(id)");
                id++;
                txtid = id;
                return txtid;
            }
        } catch (SQLException e) {}
        return 0;
    }
    
    public AddCustomer(){
        super("Add Customer");
                
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
		
	JLabel addCustomer = new JLabel("Add Customer");
        addCustomer.setBackground(new Color(0,32,63));
	addCustomer.setFont(new Font("serif",Font.BOLD,36));
	addCustomer.setBounds(60, 15, 260, 53);
	contentPane.add(addCustomer);
                
        JLabel id = new JLabel("ID:");
	id.setBounds(50, 110, 100,30);
	contentPane.add(id);
                
        String ID = String.valueOf(autoID());
        JLabel txtid = new JLabel(ID);
	txtid.setForeground(Color.red);
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
        txtgender.setBounds(150,275,150,20);
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

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
             
                try{
	            String s1 = (String)ID;
                    String s2 = txtfirstname.getText();
                    String s3 = txtlastname.getText();
                    String s4 = txtage.getText();
                    String s5 = (String) txtgender.getSelectedItem();
                    String s6 = txtemail.getText();    
                    String s7 = txtphone.getText();
                    
                    String q1 = "insert into account values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
                    c.s.executeUpdate(q1);	
                    JOptionPane.showMessageDialog(null, "Customer Added");
                    setVisible(false);
                }catch(SQLException ee){
                    System.out.println(ee.getMessage());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
	
        btnAdd.setBounds(50,420,120,30);
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
	
        btnBack.setBounds(180,420,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.WHITE);
    }
}