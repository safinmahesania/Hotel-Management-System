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

public class ViewReservations extends JFrame {
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
                new ViewReservations().setVisible(true);
            }
        });
    }
        
    public ViewReservations(){
        super("View Reservations");
        
        setBounds(220,200,1518,700);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel viewReservation = new JLabel("View Reservation");
        viewReservation.setBackground(new Color(0,32,63));
	viewReservation.setFont(new Font("serif",Font.BOLD,36));
	viewReservation.setBounds(650, 25, 440, 45);
        contentPane.add(viewReservation);
        
        JLabel reservationID = new JLabel("Reservation ID");
	reservationID.setBounds(55, 150, 100,30);
	contentPane.add(reservationID);
        
        JLabel customerID = new JLabel("Customer ID");
	customerID.setBounds(245, 150, 100,30);
	contentPane.add(customerID);
        
        JLabel roomNumber = new JLabel("Room Number");
	roomNumber.setBounds(430, 150, 100,30);
	contentPane.add(roomNumber);
		
	JLabel firstName = new JLabel("First Name");
	firstName.setBounds(625, 150, 100,30);
	contentPane.add(firstName);
		
	JLabel lastName = new JLabel("Last Name");
	lastName.setBounds(810, 150, 100,30);
	contentPane.add(lastName);

        JLabel bedType = new JLabel("Bed Type");
	bedType.setBounds(1000, 150, 100,30);
	contentPane.add(bedType);
        
        JLabel phone = new JLabel("phone");
	phone.setBounds(1200, 150, 100,30);
	contentPane.add(phone);

        JLabel deposit = new JLabel("Deposit");
	deposit.setBounds(1380, 150, 100,30);
	contentPane.add(deposit);

        table = new JTable();
	table.setBounds(0, 180, 1500, 400);
        contentPane.add(table);
		
	JButton btnView = new JButton("View");
	btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from reservation";

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