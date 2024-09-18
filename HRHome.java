package HR.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HRHome extends JFrame implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // getting the dimensions of the screen
    JLabel Cname, Wlcm;
    JButton View, Payroll, Add, Delete, Exit;
    JButton logout;
    HRHome(){ // constructor
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

        // creating the welcome label
        Wlcm = new JLabel("Welcome Dear HR to the HR Portal!!");
        Wlcm.setBounds(180,50,880,60);
        Wlcm.setFont(new Font("Verdana", Font.BOLD, 35));
        add(Wlcm);

        //creating view employees button
        View = new JButton("View Employees");
        View.setFont(new Font("Aerial",Font.BOLD, 22));
        View.setBackground(Color.BLACK);
        View.setForeground(Color.WHITE);
        View.setBounds(140,180,280,45);
        View.addActionListener(this);
        add(View);

        //creating Payroll button
        Payroll = new JButton("Employees Payroll");
        Payroll.setFont(new Font("Aerial",Font.BOLD, 22));
        Payroll.setBackground(Color.BLACK);
        Payroll.setForeground(Color.WHITE);
        Payroll.setBounds(630,180,280,45);
        Payroll.addActionListener(this);
        add(Payroll);

        //creating add employees button
        Add = new JButton("Add Employees");
        Add.setFont(new Font("Aerial",Font.BOLD, 22));
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(140,280,280,45);
        Add.addActionListener(this);
        add(Add);

        //creating Delete employees button
        Delete = new JButton("Delete Employees");
        Delete.setFont(new Font("Aerial",Font.BOLD, 22));
        Delete.setBackground(Color.BLACK);
        Delete.setForeground(Color.WHITE);
        Delete.setBounds(630,280,280,45);
        Delete.addActionListener(this);
        add(Delete);

        //creating Exit button
        Exit = new JButton("EXIT");
        Exit.setFont(new Font("Aerial",Font.BOLD, 22));
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.setBounds(370,400,280,45);
        Exit.addActionListener(this);
        add(Exit);

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

    // function that implements actionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Exit){
            System.exit(0);
        } else if (e.getSource() == logout) {
            setVisible(false);
            new LoginPage();
        } else if(e.getSource() == View){
            setVisible(false);
            new ViewEmp();
        } else if(e.getSource() == Payroll){
            setVisible(false);
            new PayrollEmp();
        } else if(e.getSource() == Add){
            setVisible(false);
            new AddEmp();
        } else if(e.getSource() == Delete){
            setVisible(false);
            new DelEmp();
        }
    }

    // main function
    public static void main(String[] args) {
        new HRHome();
    }
}
