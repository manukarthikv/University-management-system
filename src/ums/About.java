
package ums;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class About extends JFrame{
    About(){
        setSize(700,500);
        setLocation(250,50);
         setLayout(null);
         getContentPane().setBackground(Color.WHITE );
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/gat222.png"));
        
              //scaling image
        Image i2=i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);//in i1 image is  threr and in i2 scaled image is there
        image.setBounds(350,0,300,200);
        add(image);
         JLabel heading=new JLabel("<html>University<br/>Managment System</html>");
        heading.setBounds(70,20,250,130);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading); 
        
        JLabel name=new JLabel("Project by Manu Karthik V");
        name.setBounds(70,220,550,40);
        name.setFont(new Font("serif",Font.BOLD,30));
        add(name); 
        
        JLabel rollno=new JLabel("USN-1GA20CS078");
        rollno.setBounds(70,280,550,40);
        rollno.setFont(new Font("serif",Font.PLAIN,30));
        add(rollno); 
        
        
        
        
        setVisible(true);
    
}
public static void main(String[]args){

        new About();//creating class object
}
}
