package HR.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PayrollEmp extends JFrame implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // getting the dimensions of the screen
    JButton logout, back;
    JLabel Cname;
    JTable table;
    PayrollEmp(){
        // giving title to page.
        super("HR Home Page !");

        // creating the label of company name
        Cname = new JLabel("Company name");
        Cname.setBounds(10,8,220,30);
        Cname.setFont(new Font("Verdana", Font.BOLD,23));
        add(Cname);

        // Creating the logout button
        logout = new JButton("Logout");
        logout.setBounds(880,8,90,30);
        logout.setFont(new Font("Aerial",Font.BOLD,15));
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.yellow);
        logout.addActionListener(this);
        add(logout);

        table = new JTable();
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select Name, Role, (Salary/30)*attendance as salary from employees;");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(100,80,800,350);
        add(scrollpane);

        back = new JButton("Back");
        back.setFont(new Font("Aerial",Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(440,440,130,30);
        back.addActionListener(this);
        add(back);

        //frame settings
        setLayout(null);
        double wh = screenSize.height/1.5;
        double ww = screenSize.width/1.5;
        setBounds(0,0,(int) ww, (int) wh);
        setLocation(screenSize.width/6,150);
        getContentPane().setBackground(new Color(222,185,134));
        setVisible(true);
    }

    // function to print 2 black lines at the top and the bottom.
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0,80,1024,80);

        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0,515,1024,515);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            setVisible(false);
            new LoginPage();
        }
        else if(e.getSource() == back){
            setVisible(false);
            new HRHome();
        }
    }

    public static void main(String[] args) {
        new PayrollEmp();
    }
}
