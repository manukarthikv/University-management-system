
package ums;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ExaminationDetails extends JFrame implements ActionListener{
    JTextField search;
    JButton cancel,submit;
    JTable table;
    ExaminationDetails(){
        setSize(1000,475);
        setLocation(300,100);
        
        setLayout(null);
         getContentPane().setBackground(Color.WHITE );
        
        JLabel heading=new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);
        
        search=new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("serif",Font.PLAIN,20));
        add(search);
        
         submit =new JButton("Result");
         submit.setBounds(300,90,120,30);
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.addActionListener(this);
         submit.setFont (new Font("Tahoma",Font.BOLD,15));
         add(submit);
        
         cancel =new JButton("Back");
        cancel.setBounds(440,90,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont (new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        table = new JTable();  
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        JScrollPane jsp=new  JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        
         
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
            
        catch(Exception e){
            e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,1).toString());
                
            }
        
    });
        
        
        
        setVisible(true);
               
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            setVisible(false);
            new Marks(search.getText());
        }else{
            setVisible(false);
        }}
public static void main(String[]args){

        new ExaminationDetails();//creating class object
}

}