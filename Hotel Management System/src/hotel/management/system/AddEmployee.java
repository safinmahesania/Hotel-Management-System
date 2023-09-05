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

public final class AddEmployee extends JFrame {

    Connection conn;
    PreparedStatement pst;
    private final JPanel contentPane;
    private JTextField txtfirstname,txtlastname,txtage,txtsalary,txtphone,txtemail;
    JComboBox comboBox1,comboBox2,txtgender;
    JRadioButton male,female;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddEmployee().setVisible(true);
            }
	});
    }

    public int autoID(){
        int txtid;
        conn c = new conn();
        try {
            ResultSet rs = c.s.executeQuery("select MAX(id) from employee");
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
    
    public AddEmployee(){
        super("Add Employee");
                
	setBounds(530,200,900,700);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        ImageIcon image_icon  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/employee.jpg"));
        Image image = image_icon.getImage().getScaledInstance(516, 527,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel foregroundimage = new JLabel(i);
        foregroundimage.setBounds(280,80,630,530);
        add(foregroundimage);
		
	JLabel addEmployee = new JLabel("Add Employee");
        addEmployee.setBackground(new Color(0,32,63));
	addEmployee.setFont(new Font("serif",Font.BOLD,36));
	addEmployee.setBounds(275, 25, 440, 45);
        contentPane.add(addEmployee);
                
        JLabel id = new JLabel("ID:");
	id.setBounds(50, 80, 100,30);
	contentPane.add(id);
                
        String ID = String.valueOf(autoID());
        JLabel txtid = new JLabel(ID);
	txtid.setForeground(Color.red);
        txtid.setBounds(150, 85, 150, 20);
	contentPane.add(txtid);
        	
	JLabel firstname = new JLabel("First Name:");
	firstname.setBounds(50, 130, 100,30);
	contentPane.add(firstname);
		
	txtfirstname = new JTextField();
	txtfirstname.setBounds(150, 135, 150, 20);
	contentPane.add(txtfirstname);
	txtfirstname.setColumns(10);
        
        JLabel lastname = new JLabel("Last Name:");
	lastname.setBounds(50, 180, 100,30);
	contentPane.add(lastname);
		
	txtlastname = new JTextField();
	txtlastname.setBounds(150,185, 150, 20);
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
	gender.setBounds(50, 280, 100,30);
	contentPane.add(gender);
                
        String choice[] = {"","Male","Female"};
        txtgender = new JComboBox(choice);
        txtgender.setBackground(Color.WHITE);
        txtgender.setBounds(150,285,150,20);
        contentPane.add(txtgender);

        JLabel job = new JLabel("Job:");
        job.setBounds(50, 330, 150, 30);
        contentPane.add(job);
			
        String choices[] = {"","Front Desk Clerks","Driver","Housekeeping","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        comboBox2 = new JComboBox(choices);
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setBounds(150,335,150,20);
        contentPane.add(comboBox2);
        
	JLabel salary = new JLabel("Salary:");
	salary.setBounds(50, 380, 100,30);
	contentPane.add(salary);
        
        txtsalary = new JTextField();
        txtsalary.setBounds(150, 385, 150, 20);
        contentPane.add(txtsalary);
        txtsalary.setColumns(10);
		
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 430, 100,30);
        contentPane.add(phone);
        
        txtphone = new JTextField();
        txtphone.setBounds(150, 435, 150, 20);
        contentPane.add(txtphone);
        txtphone.setColumns(10);
		
        JLabel cnic = new JLabel("Email:");
        cnic.setBounds(50, 480, 100,30);
        contentPane.add(cnic);
						
        txtemail = new JTextField();
        txtemail.setBounds(150, 485, 150, 20);
        contentPane.add(txtemail);
        txtemail.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
             
	        String s1 = (String)ID;
                String s2 = txtfirstname.getText();
                String s3 = txtlastname.getText();
                String s4 = txtage.getText();
                String s5 = (String) txtgender.getSelectedItem();
                String s6 = (String)comboBox2.getSelectedItem();
                String s7 = txtsalary.getText();
                String s8 = txtphone.getText();
                String s9 = txtemail.getText();
                
                try {
                    String q1 = "insert into employee values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
                    c.s.executeUpdate(q1);	
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
	
        btnAdd.setBounds(50,550,120,30);
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
	
        btnBack.setBounds(180,550,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}