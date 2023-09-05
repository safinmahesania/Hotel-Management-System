package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {
    private final JPanel contentPane;

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
	
    public Menu(){
        super("Menu");
        
        setBounds(450, 300, 1015, 380);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
                        
        JLabel labelMenu = new JLabel("MENU");
	labelMenu.setForeground(new Color(0,32,63));
        labelMenu.setFont(new Font("serif",Font.BOLD,36));
	labelMenu.setBounds(443, 20, 200, 30);
	contentPane.add(labelMenu);
        
        JLabel labelEmployee = new JLabel("EMPLOYEE");
	labelEmployee.setForeground(new Color(0,32,63));
        labelEmployee.setFont(new Font("serif",Font.BOLD,30));
	labelEmployee.setBounds(50, 70, 200, 30);
	contentPane.add(labelEmployee);
        
        JButton btnAddEmployee = new JButton("Add Employee");
	btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee().setVisible(true);
            }
        });

        btnAddEmployee.setBounds(40, 110, 200, 30);
        btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddEmployee.setBackground(new Color(0,32,63));
        btnAddEmployee.setForeground(Color.WHITE);
  	contentPane.add(btnAddEmployee);
		
	JButton btnUpdateEmployee = new JButton("Update Employee");
	btnUpdateEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateEmployee().setVisible(true);
            }
	});
	
        btnUpdateEmployee.setBounds(40, 150, 200, 30);
        btnUpdateEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdateEmployee.setBackground(new Color(0,32,63));
        btnUpdateEmployee.setForeground(Color.WHITE);
  	contentPane.add(btnUpdateEmployee);
        	
	JButton btnRemoveEmployee = new JButton("Remove Employee");
	btnRemoveEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee().setVisible(true);
            }
        });
	
        btnRemoveEmployee.setBounds(40, 190, 200, 30);
        btnRemoveEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRemoveEmployee.setBackground(new Color(0,32,63));
        btnRemoveEmployee.setForeground(Color.WHITE);
  	contentPane.add(btnRemoveEmployee);
		
	JButton btnViewEmployee = new JButton("View Employee");
	btnViewEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee().setVisible(true);
            }
	});
        
               btnViewEmployee.setBounds(40, 230, 200, 30);                
        btnViewEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnViewEmployee.setBackground(new Color(0,32,63));
        btnViewEmployee.setForeground(Color.WHITE);
  	contentPane.add(btnViewEmployee);
        
        JLabel labelRoom = new JLabel("ROOM");
	labelRoom.setForeground(new Color(0,32,63));
        labelRoom.setFont(new Font("serif",Font.BOLD,30));
	labelRoom.setBounds(330, 70, 200, 30);
	contentPane.add(labelRoom);
				
	JButton btnAddRoom = new JButton("Add Room");
	btnAddRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddRoom().setVisible(true);
            }
        });

        btnAddRoom.setBounds(280, 110, 200, 30);
        btnAddRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddRoom.setBackground(new Color(0,32,63));
        btnAddRoom.setForeground(Color.WHITE);
  	contentPane.add(btnAddRoom);
		
	JButton btnUpdateRoom = new JButton("Update Room");
	btnUpdateRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateRoom().setVisible(true);
            }
	});
	
        btnUpdateRoom.setBounds(280, 150, 200, 30);
        btnUpdateRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdateRoom.setBackground(new Color(0,32,63));
        btnUpdateRoom.setForeground(Color.WHITE);
  	contentPane.add(btnUpdateRoom);
        	
	JButton btnRemoveRoom = new JButton("Remove Room");
	btnRemoveRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveRoom().setVisible(true);
            }
        });
	
        btnRemoveRoom.setBounds(280, 190, 200, 30);
        btnRemoveRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRemoveRoom.setBackground(new Color(0,32,63));
        btnRemoveRoom.setForeground(Color.WHITE);
  	contentPane.add(btnRemoveRoom);
		
	JButton btnViewRoom = new JButton("View Room");
	btnViewRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewRoom().setVisible(true);
            }
	});
	
        btnViewRoom.setBounds(280, 230, 200, 30);                
        btnViewRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnViewRoom.setBackground(new Color(0,32,63));
        btnViewRoom.setForeground(Color.WHITE);
  	contentPane.add(btnViewRoom);

        JLabel labelCar = new JLabel("CAR");
	labelCar.setForeground(new Color(0,32,63));
        labelCar.setFont(new Font("serif",Font.BOLD,30));
	labelCar.setBounds(585, 70, 200, 30);
	contentPane.add(labelCar);
        
        JButton btnAddCar = new JButton("Add Car");
	btnAddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCar().setVisible(true);
            }
        });

        btnAddCar.setBounds(520, 110, 200, 30);
        btnAddCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddCar.setBackground(new Color(0,32,63));
        btnAddCar.setForeground(Color.WHITE);
  	contentPane.add(btnAddCar);
		
	JButton btnUpdateCar = new JButton("Update Car");
	btnUpdateCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateCar().setVisible(true);
            }
	});
	
        btnUpdateCar.setBounds(520, 150, 200, 30);
        btnUpdateCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdateCar.setBackground(new Color(0,32,63));
        btnUpdateCar.setForeground(Color.WHITE);
  	contentPane.add(btnUpdateCar);
        	
	JButton btnRemoveCar = new JButton("Remove Car");
	btnRemoveCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveCar().setVisible(true);
            }
        });
	
        btnRemoveCar.setBounds(520, 190, 200, 30);
        btnRemoveCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRemoveCar.setBackground(new Color(0,32,63));
        btnRemoveCar.setForeground(Color.WHITE);
  	contentPane.add(btnRemoveCar);
		
	JButton btnViewCar = new JButton("View Car");
	btnViewCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCar().setVisible(true);
            }
	});
	
        btnViewCar.setBounds(520, 230, 200, 30);                
        btnViewCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnViewCar.setBackground(new Color(0,32,63));
        btnViewCar.setForeground(Color.WHITE);
  	contentPane.add(btnViewCar);
        
        JLabel labelCustomer = new JLabel("Customer");
	labelCustomer.setForeground(new Color(0,32,63));
        labelCustomer.setFont(new Font("serif",Font.BOLD,30));
	labelCustomer.setBounds(815, 70, 200, 30);
	contentPane.add(labelCustomer);
		
        JButton btnAddCustomer = new JButton("Add Customer");
	btnAddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomer().setVisible(true);
            }
        });

        btnAddCustomer.setBounds(760, 110, 200, 30);
        btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddCustomer.setBackground(new Color(0,32,63));
        btnAddCustomer.setForeground(Color.WHITE);
  	contentPane.add(btnAddCustomer);
		
	JButton btnUpdateCustomer = new JButton("Update Customer");
	btnUpdateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateCustomer().setVisible(true);
            }
	});
	
        btnUpdateCustomer.setBounds(760, 150, 200, 30);
        btnUpdateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdateCustomer.setBackground(new Color(0,32,63));
        btnUpdateCustomer.setForeground(Color.WHITE);
  	contentPane.add(btnUpdateCustomer);
        	
	JButton btnRemoveCustomer = new JButton("Remove Customer");
	btnRemoveCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveCustomer().setVisible(true);
            }
        });
	
        btnRemoveCustomer.setBounds(760, 190, 200, 30);
        btnRemoveCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRemoveCustomer.setBackground(new Color(0,32,63));
        btnRemoveCustomer.setForeground(Color.WHITE);
  	contentPane.add(btnRemoveCustomer);
		
	JButton btnViewCustomer = new JButton("View Customer");
	btnViewCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCustomer().setVisible(true);
            }
	});
	
        btnViewCustomer.setBounds(760, 230, 200, 30);                
        btnViewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnViewCustomer.setBackground(new Color(0,32,63));
        btnViewCustomer.setForeground(Color.WHITE);
  	contentPane.add(btnViewCustomer);
        
        JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
	});
	
        btnBack.setBounds(400, 280, 200, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBackground(new Color(0,32,63));
        btnBack.setForeground(Color.WHITE);
  	contentPane.add(btnBack);
        
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }    
}