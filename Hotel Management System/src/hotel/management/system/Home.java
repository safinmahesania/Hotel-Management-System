package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame {
    private final JPanel contentPane;

    public static void main(String[] args) {
        new Home().setVisible(true);
    }
	
    public Home(){
        super("Home");
        
        setBounds(810, 350, 295, 250);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                        
        JLabel title = new JLabel("Home");
	title.setForeground(new Color(0,32,63));
        title.setFont(new Font("serif",Font.BOLD,36));
	title.setBounds(80, 20, 200, 30);
	contentPane.add(title);
		
	JButton btnDashboard = new JButton("Dashboard");
	btnDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
            }
        });

        btnDashboard.setBounds(40, 70, 200, 30);
        btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDashboard.setBackground(new Color(0,32,63));
        btnDashboard.setForeground(Color.WHITE);
  	contentPane.add(btnDashboard);
		
	JButton btnReception = new JButton("Reception");
	btnReception.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
            }
	});
	
        btnReception.setBounds(40, 110, 200, 30);
        btnReception.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReception.setBackground(new Color(0,32,63));
        btnReception.setForeground(Color.WHITE);
  	contentPane.add(btnReception);
        	
        JButton btnClose = new JButton("Close");
	btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HotelManagementSystem().setVisible(true);				
                setVisible(false);
            }
	});
	
        btnClose.setBounds(40, 150, 200, 30);
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnClose.setBackground(new Color(0,32,63));
        btnClose.setForeground(Color.WHITE);
  	contentPane.add(btnClose);
		
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }    
}