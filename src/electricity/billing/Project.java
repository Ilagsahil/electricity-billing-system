package electricity.billing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
    
    String atype, meter, name;
//    ViewInformation viewInfoForm;
    Project(String _atype, String _name, String _meter) {
        this.atype = _atype;
        this.name = _name;
        this.meter = _meter;
        
        System.out.println("In Project class: " + this.atype);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
//        JDesktopPane desktop = new JDesktopPane();
//        desktop.setBackground(Color.DARK_GRAY);
//        
//        viewInfoForm = new ViewInformation(meter);
//        desktop.add(viewInfoForm);
//        
//        add(desktop, BorderLayout.CENTER);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        mb.add(master);
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails .setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails .setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        customerdetails .setIcon(new ImageIcon(image2));
        customerdetails .setMnemonic('M');
        customerdetails.addActionListener(this);
        customerdetails .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerdetails );
        
        JMenuItem depositdetails = new JMenuItem("Deposite Details");
        depositdetails .setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails .setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        depositdetails .setIcon(new ImageIcon(image3));
        depositdetails .setMnemonic('N');
        depositdetails.addActionListener(this);
        depositdetails .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositdetails );
        
        JMenuItem calculatebill = new JMenuItem("CalculateBill");
        calculatebill .setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill .setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculatebill .setIcon(new ImageIcon(image4));
        calculatebill .setMnemonic('F');
        calculatebill.addActionListener(this);
        calculatebill .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        master.add(calculatebill);

        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        mb.add(info);
        
        JMenuItem upadateinformation = new JMenuItem("UpdateInformation");
        upadateinformation .setFont(new Font("monospaced",Font.PLAIN,12));
        upadateinformation .setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        upadateinformation .setIcon(new ImageIcon(image5));
        upadateinformation .setMnemonic('B');
        upadateinformation.addActionListener(this);
        upadateinformation .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        info.add(upadateinformation );
        
        JMenuItem viewinformation = new JMenuItem("ViewInformation");
        viewinformation .setFont(new Font("monospaced",Font.PLAIN,12));
        viewinformation .setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        viewinformation .setIcon(new ImageIcon(image6));
        viewinformation .setMnemonic('K');
        viewinformation.addActionListener(this);
        viewinformation .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        info.add(viewinformation );
        
        JMenu user = new JMenu("User");
        info.setForeground(Color.RED);
        mb.add(user);
        
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill .setFont(new Font("monospaced",Font.PLAIN,12));
        paybill .setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        paybill .setIcon(new ImageIcon(image7));
        paybill .setMnemonic('O');
        paybill.addActionListener(this);
        paybill .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        user.add(paybill );
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails .setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails .setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        billdetails .setIcon(new ImageIcon(image8));
        billdetails .setMnemonic('Q');
        billdetails.addActionListener(this);
        billdetails .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        user.add(billdetails );
        
        JMenu report = new JMenu("Report");
        info.setForeground(Color.RED);
        mb.add(report);
        
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('Z');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        report.add(generatebill );
        
        JMenu utility = new JMenu("Utility");
        info.setForeground(Color.RED);
        mb.add(utility);
        
        
        JMenuItem notpad = new JMenuItem("Notepad");
        notpad.setFont(new Font("monospaced",Font.PLAIN,12));
        notpad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        notpad.setIcon(new ImageIcon(image10));
        notpad.setMnemonic('N');
        notpad.addActionListener(this);
        notpad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notpad );
        
        JMenuItem calculater = new JMenuItem("Calculator");
        calculater.setFont(new Font("monospaced",Font.PLAIN,12));
        calculater.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculater.setIcon(new ImageIcon(image11));
        calculater.setMnemonic('c');
        calculater.addActionListener(this);
        calculater.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(calculater );
        
        
        JMenu mexit = new JMenu("Exit");
        info.setForeground(Color.RED);
        mb.add(mexit);
        
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit );

        if (this.atype.equals("Admin")) {
            //mb.add(master);
            info.setVisible(false);
            user.setVisible(false);
            report.setVisible(false);
        } else {
            master.setVisible(false);
        }
        
//        mb.add(utility);
//        mb.add(mexit);
        
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")){
            new NewCustomer();
        }else if (msg.equals("Customer Details")){
             new CustomerDetails();
        }else if (msg.equals("Deposite Details")){
             new DepositeDetails();
        }else if (msg.equals("CalculateBill")){
            new CalculateBill();
        }else if (msg.equals("ViewInformation")){
            new ViewInformation(name);
//            viewInfoForm.setVisible(true);
//            viewInfoForm.show();
        }else if (msg.equals("UpdateInformation")){
            new UpdateInformation(name);
        }else if (msg.equals("Bill Details")){
            new BillDetails(meter);
        }else if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (msg.equals("Exit")){
            setVisible(false);
            new Login();
        }else if (msg.equals("Pay Bill")){
            new PayBill(meter);
        }else if (msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }
    public static void main(String[] args) {
        new Project("", "", "");
        
    } 
    
}
