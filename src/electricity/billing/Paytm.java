package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Paytm extends JFrame implements ActionListener {

    Choice paymentMethod, bankList;
    JButton pay;
    JLabel nameLabel, amountLabel, paymentMethodLabel, bankLabel, labelname, labelamount;
    String cmonth;
    String meter;

    Paytm(String meter, String monthName) {
        this.meter = meter;
        this.cmonth = monthName;

        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Pay Bills");
        heading.setBounds(350, 50, 500, 40);
        heading.setFont(new Font("TIMES New Roman", Font.BOLD, 25));
        add(heading);

        nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(150, 140, 300, 20);
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(nameLabel);

        labelname = new JLabel("");
        labelname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        labelname.setBounds(400, 140, 200, 20);
        add(labelname);

        amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(150, 200, 300, 20);
        amountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(amountLabel);

        labelamount = new JLabel("");
        labelamount.setBounds(400, 200, 200, 20); // Adjusted bounds for amount label
        labelamount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(labelamount);

        paymentMethodLabel = new JLabel("Select Payment Method:");
        paymentMethodLabel.setBounds(150, 270, 250, 20);
        paymentMethodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(paymentMethodLabel);

        paymentMethod = new Choice();
        paymentMethod.add("Google Pay");
        paymentMethod.add("Paytm");
        paymentMethod.add("Bank Transfer");
        paymentMethod.setBounds(400, 270, 150, 20);
        add(paymentMethod);

        bankLabel = new JLabel("Bank Name:");
        bankLabel.setBounds(150, 340, 250, 20);
        bankLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(bankLabel);

        bankList = new Choice();
        bankList.add("Kalyan Janta Bank");
        bankList.add("State Bank of India");
        bankList.add("Punjab National Bank");
        bankList.add("Central Bank Of India");
        bankList.setBounds(400, 340, 150, 20);
        add(bankList);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter + "'");
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
            }

            // Fetch the amount data from the database based on meter and month
            rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' AND month = '" + cmonth + "'");
            while (rs.next()) {
                labelamount.setText(rs.getString("totalbill"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(300, 430, 150, 30);
        pay.addActionListener(this);
        add(pay);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            // Handle payment logic here
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '" + meter + "' AND month = '" + cmonth + "'");
                JOptionPane.showMessageDialog(null, "Payment successful", "Payment", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Payment", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Paytm("", "");
    }
}
