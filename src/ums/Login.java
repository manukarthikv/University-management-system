
package ums;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{//because we need to use an event
    JButton  login,cancel;
    JTextField tfusername,tfpassword;
    Login(){//constructor
        getContentPane().setBackground(Color.WHITE );//for colour
        setLayout(null);
        
        
        JLabel iblusername = new JLabel ("username");
        iblusername.setBounds(40,20,100,20);
        add(iblusername);
        
         tfusername =new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel iblpassword=new JLabel("password");
        iblpassword.setBounds(40,70,100,20);
        add(iblpassword);
        
         tfpassword =new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        login =new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont (new Font("Tahoma",Font.BOLD,15));
        add(login);
        
         cancel =new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont (new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        
              //scaling image
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);//in i1 image is  threr and in i2 scaled image is there
        //add function is in jframe
        image.setBounds(350,0,200,200);
        add(image);
        
        
      setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    //overriding
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
            String username=tfusername.getText();
            String password=tfpassword.getText();
            //step 4 executing sql queries
            String query="select*from login where username= '"+username+"'and password='"+password+"'";//single inverted commas is very important
            try{
            Conn c =new  Conn();
            ResultSet rs=c.s.executeQuery(query);
                
            if(rs.next()){
                setVisible(false);
                new Project();//opening next frame and closing if true
            }else{
                JOptionPane.showMessageDialog(null,"Invaild username or password" );
                        setVisible(false);
            }
            //c.s.close();//5th step
                }catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()== cancel){
            setVisible(false);
        }
    
    }
    
 public static void main(String[]args){
       new Login();//unidentified object creation
}
}