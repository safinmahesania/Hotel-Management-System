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

public class ViewCustomer extends JFrame {
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
                new ViewCustomer().setVisible(true);
            }
        });
    }
        
    public ViewCustomer(){
        super("View Customer");
        
        setBounds(200,200,1518,700);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel viewCustomer = new JLabel("View Customer");
        viewCustomer.setBackground(new Color(0,32,63));
	viewCustomer.setFont(new Font("serif",Font.BOLD,36));
	viewCustomer.setBounds(650, 25, 440, 45);
        contentPane.add(viewCustomer);
        
	JLabel id = new JLabel("ID");
	id.setBounds(110, 150, 100,30);
	contentPane.add(id);
        
        JLabel firstname = new JLabel("First Name");
	firstname.setBounds(290, 150, 100,30);
	contentPane.add(firstname);
        
        JLabel lastname = new JLabel("Last Name");
	lastname.setBounds(510, 150, 100,30);
	contentPane.add(lastname);
		
	JLabel age = new JLabel("Age");
	age.setBounds(740, 150, 100,30);
	contentPane.add(age);
		
	JLabel gender = new JLabel("Gender");
	gender.setBounds(940, 150, 100,30);
	contentPane.add(gender);

        JLabel phone = new JLabel("Phone");
	phone.setBounds(1370, 150, 100,30);
	contentPane.add(phone);

        JLabel email = new JLabel("Email");
	email.setBounds(1160, 150, 100,30);
	contentPane.add(email);

        table = new JTable();
	table.setBounds(0, 180, 1500, 400);
        contentPane.add(table);
		
	JButton btnView = new JButton("View");
	btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from account";
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