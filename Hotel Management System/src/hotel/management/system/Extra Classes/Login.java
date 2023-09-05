package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel username,password;
    JTextField txtusername;
    JPasswordField txtpassword;
    JButton btnLogin,btnSignup,btnClose;

    Login(){
        super("Login");

        setLayout(null);

        JLabel title = new JLabel("LOGIN");
        title.setBounds(110,5,150,30);
        title.setForeground(new Color(0,32,63));
        title.setFont(new Font("serif",Font.BOLD,36));
        add(title);
        
        username = new JLabel("Username");
        username.setBounds(40,260,100,30);
        add(username);
        
        txtusername=new JTextField();
        txtusername.setBounds(150,265, 150, 20);
        add(txtusername);

        password = new JLabel("Password");
        password.setBounds(40,310,100,30);
        add(password);
 
        txtpassword=new JPasswordField();
        txtpassword.setBounds(150,315, 150, 20);
        add(txtpassword);
        
        ImageIcon image_icon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.png"));
        Image image = image_icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i =  new ImageIcon(image);
        JLabel backgroundImage = new JLabel(i);
        backgroundImage.setBounds(75,50,200,200);
        add(backgroundImage);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(40,360,120,30);
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLogin.setBackground(new Color(0,32,63));
        btnLogin.setForeground(Color.WHITE);
        add(btnLogin);
        
        btnSignup = new JButton("Sign Up");
        btnSignup.setBounds(180,360,120,30);
        btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSignup.setBackground(new Color(0,32,63));
        btnSignup.setForeground(Color.WHITE);
        add(btnSignup);

        btnClose = new JButton("Close");
        btnClose.setBounds(110,400,120,30);
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnClose.setBackground(new Color(0,32,63));
        btnClose.setForeground(Color.WHITE);
        add(btnClose);

        btnLogin.addActionListener(this);
        btnSignup.addActionListener(this);
        btnClose.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(360,500);
        setLocation(780,300);
    }

    @Override
    public void actionPerformed(ActionEvent action){
        if(action.getSource()==btnLogin){
            conn c = new conn();
            String username = txtusername.getText();
            String password = txtpassword.getText();
            
            String str = "select * from account where username = '"+username+"' and password = '"+password+"'";
            
            if("admin".equals(username)|| "admin".equals(password)){
                try{
                    ResultSet rs = c.s.executeQuery(str); 
                    if(rs.next()){ 
                        new Dashboard().setVisible(true);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                }catch(HeadlessException | SQLException e){
                    System.out.print(e);
                }
            }
            else if(!"admin".equals(username) || !"admin".equals(password)){
                try{
                    ResultSet rs = c.s.executeQuery(str); 
                    if(rs.next()){ 
                        new Reception().setVisible(true);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                }catch(HeadlessException | SQLException e){
                    System.out.print(e);
                }
            }
        }
        else if(action.getSource()==btnSignup){
            new AddCustomer().setVisible(true);
        }else if(action.getSource()==btnClose){
            System.exit(0);
        }
    }
    
    public static void main(String[] arg){
        Login login = new Login();
    }
}