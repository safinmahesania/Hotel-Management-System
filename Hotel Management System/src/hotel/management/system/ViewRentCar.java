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

public class ViewRentCar extends JFrame {
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
                new ViewRentCar().setVisible(true);
            }
        });
    }
        
    public ViewRentCar(){
        super("View Rent Car");
        
        setBounds(220,200,1518,700);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel viewRentCar = new JLabel("View Rent Car");
        viewRentCar.setBackground(new Color(0,32,63));
	viewRentCar.setFont(new Font("serif",Font.BOLD,36));
	viewRentCar.setBounds(650, 25, 440, 45);
        contentPane.add(viewRentCar);
        
        JLabel reservationID = new JLabel("Reservation ID");
	reservationID.setBounds(25, 150, 100,30);
	contentPane.add(reservationID);
        
        JLabel customerID = new JLabel("Customer ID");
	customerID.setBounds(170, 150, 100,30);
	contentPane.add(customerID);
        
        JLabel roomNumber = new JLabel("Room Number");
	roomNumber.setBounds(300, 150, 100,30);
	contentPane.add(roomNumber);
		
	JLabel customerName = new JLabel("Customer Name");
	customerName.setBounds(425, 150, 100,30);
	contentPane.add(customerName);
		
	JLabel customerPhone = new JLabel("Customer Phone");
	customerPhone.setBounds(560, 150, 100,30);
	contentPane.add(customerPhone);

        JLabel carID = new JLabel("Car ID");
	carID.setBounds(730, 150, 100,30);
	contentPane.add(carID);
        
        JLabel carName = new JLabel("Car Name");
	carName.setBounds(860, 150, 100,30);
	contentPane.add(carName);

        JLabel driverID = new JLabel("Driver ID");
	driverID.setBounds(1000, 150, 100,30);
	contentPane.add(driverID);

        JLabel driverName = new JLabel("Driver Name");
	driverName.setBounds(1120, 150, 100,30);
	contentPane.add(driverName);

        JLabel driverPhone = new JLabel("Driver Phone");
	driverPhone.setBounds(1255, 150, 100,30);
	contentPane.add(driverPhone);
        
        JLabel rent = new JLabel("Rent");
	rent.setBounds(1410, 150, 100,30);
	contentPane.add(rent);
        
        table = new JTable();
	table.setBounds(0, 180, 1500, 400);
        contentPane.add(table);
		
	JButton btnView = new JButton("View");
	btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from rentcar";

                try{
                    conn c = new conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (SQLException ee){}
            }
        });
	
        btnView.setBounds(630, 590, 120, 30);
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
	
        btnBack.setBounds(780, 590, 120, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.white);
        contentPane.add(btnBack);
        
        getContentPane().setBackground(Color.white);
    }
}