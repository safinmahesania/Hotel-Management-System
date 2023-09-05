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

public class ViewRoom extends JFrame {
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
                ViewRoom viewRoom = new ViewRoom();
                viewRoom.setVisible(true);
            }
        });
    }
        
    public ViewRoom(){
        super("View Room");
        
        setBounds(530,200,900,450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                
        JLabel viewRoom = new JLabel("View Rooms");
        viewRoom.setBackground(new Color(0,32,63));
	viewRoom.setFont(new Font("serif",Font.BOLD,36));
	viewRoom.setBounds(350, 25, 440, 45);
        contentPane.add(viewRoom);
        
	JLabel labelRoomBedType = new JLabel("Bed Type:");
	labelRoomBedType.setBounds(150, 110, 100,30);
	contentPane.add(labelRoomBedType);
        
        choice = new Choice();
        choice.add("All");
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(250, 115, 150, 20);
	contentPane.add(choice);
		
	JCheckBox checkAvailable = new JCheckBox("Only display Available");
	checkAvailable.setBounds(500, 110, 200,30);
        checkAvailable.setBackground(Color.WHITE);
	contentPane.add(checkAvailable);
        
        JLabel labelRoomNumber = new JLabel("Room Number");
	labelRoomNumber.setBounds(50, 150, 100,30);
	contentPane.add(labelRoomNumber);
        
        JLabel labelBedType = new JLabel("Bed Type");
	labelBedType.setBounds(240, 150, 100,30);
	contentPane.add(labelBedType);
        
        JLabel labelCleanStatus = new JLabel("Clean Status");
	labelCleanStatus.setBounds(400, 150, 100,30);
	contentPane.add(labelCleanStatus);
		
	JLabel labelRoomAvailable = new JLabel("Availability");
	labelRoomAvailable.setBounds(590, 150, 100,30);
	contentPane.add(labelRoomAvailable);
		
	JLabel labelPrice = new JLabel("Price");
	labelPrice.setBounds(780, 150, 100,30);
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
                if("All".equals(choice.getSelectedItem())){
                    SQL = "select * from Room";
                    SQL2 = "select * from Room where availability = 'Available'";
                }else{
                    SQL = "select * from Room where bed_type = '"+choice.getSelectedItem()+"'";
                    SQL2 = "select * from Room where availability = 'Available' AND bed_type = '"+choice.getSelectedItem()+"'";
                }

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