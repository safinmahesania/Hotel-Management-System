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

public class ViewCar extends JFrame {
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
                new ViewCar().setVisible(true);
            }
        });
    }
        
    public ViewCar(){
        super("View Car");
        
        setBounds(530,200,900,450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        JLabel viewCars = new JLabel("View Cars");
        viewCars.setBackground(new Color(0,32,63));
	viewCars.setFont(new Font("serif",Font.BOLD,36));
	viewCars.setBounds(350, 25, 440, 45);
        contentPane.add(viewCars);
        		
	JCheckBox checkAvailable = new JCheckBox("Only display Available");
	checkAvailable.setBounds(150, 110, 200,30);
        checkAvailable.setBackground(Color.WHITE);
	contentPane.add(checkAvailable);
        
        JLabel labelCarID = new JLabel("Car ID");
	labelCarID.setBounds(100, 150, 100,30);
	contentPane.add(labelCarID);
        
        JLabel labelCarName = new JLabel("Car Name");
	labelCarName.setBounds(300, 150, 100,30);
	contentPane.add(labelCarName);
        
        JLabel labelAvailability = new JLabel("Availability");
	labelAvailability.setBounds(525, 150, 100,30);
	contentPane.add(labelAvailability);
		
	JLabel labelPrice = new JLabel("Price");
	labelPrice.setBounds(760, 150, 100,30);
	contentPane.add(labelPrice);
		        
        table = new JTable();
	table.setBounds(0, 180, 885, 170);
        contentPane.add(table);
		
	JButton btnView = new JButton("View");
	btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL;
                String SQL2;
                    SQL = "select * from car";
                    SQL2 = "select * from car where availability = 'Available'";
                try{
                    conn c = new conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(checkAvailable.isSelected()){
                        rs = c.s.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                }catch (SQLException ee){}
            }
        });
	
        btnView.setBounds(300, 350, 120, 30);
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
	
        btnBack.setBounds(450, 350, 120, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
                
        getContentPane().setBackground(Color.white);
    }
}