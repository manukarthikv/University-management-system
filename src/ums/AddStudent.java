    
package ums;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class AddStudent extends JFrame implements ActionListener {
    JTextField tfname ,tfphone,tfemail;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);
    AddStudent(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,150,100,50);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,30);
        add(tfname);
        
        
        JLabel lblrollno=new JLabel("Roll Number");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        
        labelrollno=new JLabel("1000"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);
        
        JLabel lbldob=new JLabel("date of birth");
        lbldob.setBounds(400,150,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        dcdob=new JDateChooser();
        dcdob.setBounds(600,150,150,30);
        add(dcdob);
        
        JLabel lblphone=new JLabel("Phone no");
        lblphone.setBounds(400,200,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,200,200,30);
        add(tfphone);
        
        
        JLabel lblemail=new JLabel("E-mail");
        lblemail.setBounds(50,250,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,250,150,30);
        add(tfemail);
        
        JLabel lblcourse=new JLabel("Course");
        lblcourse.setBounds(400,250,150,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
         
        String course[]={"B.Tech","BBA","BCA","BSc","MSc","MBA","MCom"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(600,250,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch=new JLabel("Branch");
        lblbranch.setBounds(50,300,150,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
         
        String branch[]={"CSE","IS","MECH","CIVIL","ECE","EEE","AI/ML"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(200,300,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
         submit =new JButton("Submit");
         submit.setBounds(250,450,120,30);
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.addActionListener(this);
         submit.setFont (new Font("Tahoma",Font.BOLD,15));
         add(submit);
        
         cancel =new JButton("Cancel");
        cancel.setBounds(450,450,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont (new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
    }
    //overriding
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String name=tfname.getText();
            String rollno=labelrollno.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String course=(String)cbcourse.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            try{
                String query="insert into student values('"+name+"','"+rollno+"','"+dob+"','"+phone+"','"+email+"','"+course+"','"+branch+"')";
                Conn con=new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student details inserted successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
    }
        else{
            setVisible(false);
        }
    }
    /**
     *
     * @param args
     */
    public static void main(String[]args){
        new AddStudent();//creating class object
}
}
