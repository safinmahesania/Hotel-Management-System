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

public final class UpdateEmployee extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    private final JPanel contentPane;
    private JTextField txtfirstname,txtlastname,txtage,txtsalary,txtphone,txtemail;
    JComboBox comboBox_id,comboBox1,comboBox2,txtgender;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateEmployee().setVisible(true);
            }
	});
    }

    public UpdateEmployee(){
        super("Update Employee");
                
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
		
	JLabel updateEmployee = new JLabel("Update Employee");
        updateEmployee.setBackground(new Color(0,32,63));
	updateEmployee.setFont(new Font("serif",Font.BOLD,36));
	updateEmployee.setBounds(275, 25, 440, 45);
        contentPane.add(updateEmployee);
                
        JLabel id = new JLabel("ID:");
	id.setBounds(50, 80, 100,30);
	contentPane.add(id);
                
        Choice txtid = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                txtid.add(rs.getString("id"));    
            }
        }catch(SQLException e){ }
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
        
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 480, 100,30);
        contentPane.add(email);
						
        txtemail = new JTextField();
        txtemail.setBounds(150, 485, 150, 20);
        contentPane.add(txtemail);
        txtemail.setColumns(10);
        
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
                String id = txtid.getSelectedItem();
                try{
                    ResultSet rs = c.s.executeQuery("select * from employee where id = '"+id+"'");
                    while(rs.next()){
                        txtfirstname.setText(rs.getString("firstname"));
                        txtlastname.setText(rs.getString("lastname"));
                        txtage.setText(rs.getString("age"));                        
                        txtgender.setSelectedItem(rs.getString("gender"));
                        comboBox2.setSelectedItem(rs.getString("job"));
                        txtsalary.setText(rs.getString("salary"));
                        txtphone.setText(rs.getString("phone"));
                        txtemail.setText(rs.getString("email"));
                    }
                }catch(SQLException e){ }
            }
        });

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
             
	        String s1 = txtid.getSelectedItem();
                String s2 = txtfirstname.getText();
                String s3 = txtlastname.getText();
                String s4 = txtage.getText();
                String s5 = (String) txtgender.getSelectedItem();
                String s6 = (String)comboBox2.getSelectedItem();
                String s7 = txtsalary.getText();
                String s8 = txtphone.getText();
                String s9 = txtemail.getText();
                
                try {
                    c.s.executeUpdate("update employee set firstname = '"+s2+"',lastname = '"+s3+"',age = '"+s4+"',gender = '"+s5+"',job = '"+s6+"',salary = '"+s7+"',phone = '"+s8+"',email = '"+s9+"' where id = '"+s1+"'");   		
                    JOptionPane.showMessageDialog(null, "Employee Updated!");
                    setVisible(false);
                } catch (SQLException ex) {
                        Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }       
        });
	
        btnUpdate.setBounds(50,550,120,30);
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
	
        btnBack.setBounds(180,550,120,30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}