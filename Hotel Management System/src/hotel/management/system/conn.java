package hotel.management.system;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    PreparedStatement pst;

    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","123456");
            s = c.createStatement();              
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
        }  
    }  
}  