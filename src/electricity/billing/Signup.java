package electricity.billing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Signup extends JFrame implements ActionListener{

    JButton create, back;
    Choice logginin;
    JTextField meter, username, name;
    JPasswordField password;
    Signup(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
      
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(100, 50, 140, 20);
        loggininas.setForeground(Color.GRAY);
        loggininas.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(loggininas);
        
        logginin = new Choice();
        logginin.add("Customer");
        logginin.setBounds(260, 50, 150, 20);
        panel.add(logginin);
       
        
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
       
        panel.add(lblmeter);
        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
       
        panel.add(meter);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);
        
         password = new JPasswordField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = logginin.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            
//            if (isValidName(sname)) {
//                    JOptionPane.showMessageDialog(Signup.this, "Valid name: " + name);
//                } else {
//                    JOptionPane.showMessageDialog(Signup.this, "Invalid name: " + name, "Error", JOptionPane.ERROR_MESSAGE);
//                }
            
            String spassword = password.getText();
            String smeter = meter.getText();
           
            try {
                Conn c = new Conn();
                
                String query = null;
//                if (atype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
//                } else {
//                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
//                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            
            new Login();
        }
    }
    
    

    public static void main(String[] args) {
        
//        String userNumber = JOptionPane.showInputDialog("Enter a number:");
        
       

        new Signup();
    }
}