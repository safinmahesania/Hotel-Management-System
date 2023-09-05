package hotel.management.system;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewDriver extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private final JPanel contentPane;
    private JTable table;
    Choice choice;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewDriver viewDriver = new ViewDriver();
                viewDriver.setVisible(true);
            }
        });
    }
        
    public ViewDriver(){
        super("View Driver");
        
        setBounds(200,200,1518,700);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel viewDriver = new JLabel("View Driver");
        viewDriver.setBackground(new Color(0,32,63));
	viewDriver.setFont(new Font("serif",Font.BOLD,36));
	viewDriver.setBounds(650, 25, 440, 45);
        contentPane.add(viewDriver);
        
        JLabel id = new JLabel("ID");
	id.setBounds(80, 150, 100,30);
	contentPane.add(id);
        
        JLabel firstname = new JLabel("First Name");
	firstname.setBounds(220, 150, 100,30);
	contentPane.add(firstname);
        
        JLabel lastname = new JLabel("Last Name");
	lastname.setBounds(390, 150, 100,30);
	contentPane.add(lastname);
		
	JLabel age = new JLabel("Age");
	age.setBounds(570, 150, 100,30);
	contentPane.add(age);
		
	JLabel gender = new JLabel("Gender");
	gender.setBounds(720, 150, 100,30);
	contentPane.add(gender);

        JLabel job = new JLabel("Job");
	job.setBounds(900, 150, 100,30);
	contentPane.add(job);
        
        JLabel salary = new JLabel("Salary");
	salary.setBounds(1060, 150, 100,30);
	contentPane.add(salary);

        JLabel phone = new JLabel("Phone");
	phone.setBounds(1220, 150, 100,30);
	contentPane.add(phone);

        JLabel email = new JLabel("Email");
	email.setBounds(1400, 150, 100,30);
	contentPane.add(email);

        table = new JTable();
	table.setBounds(0, 180, 1500, 400);
        contentPane.add(table);
		
	JButton btnView = new JButton("View");
	btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL;
                SQL = "select * from employee where job = 'Driver'";
                try{
                    conn c = new conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (SQLException ee){}
            }
        });
	
        btnView.setBounds(650, 590, 120, 30);
        btnView.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnView.setBackground(new Color(0,32,63));
        btnView.setForeground(Color.white);
        contentPane.add(btnView);
		
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
	});
	
        btnBack.setBounds(800, 590, 120, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
        
        getContentPane().setBackground(Color.white);
    }
}