
package ums;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){//default constructor
        try{
            //step1 register the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step 2 connection string,driver manager is a class
            c=DriverManager.getConnection("jdbc:mysql:///ums","root","Manu12345");
            //step 3 creating statments
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
