package HR.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // getting screen dimensions
    JLabel Cname, Uname, Pass, Wlcm;
    JTextField uname;
    JPasswordField password;
    JButton signin, clear;
    Graphics g;
    LoginPage(){ // constructor
        // setting title to the page
        super("HR Management System");


        // creating the label of company name
        Cname = new JLabel("Company name");
        Cname.setBounds(10,8,220,30);
        Cname.setFont(new Font("Verdana", Font.BOLD,23));
        add(Cname);

        // Creating the Welcome label
        Wlcm = new JLabel("Welcome to the Company Name");
        Wlcm.setBounds(160,85, 600, 50);
        Wlcm.setFont(new Font("Aerial", Font.BOLD,30));
        add(Wlcm);

        // User-name Label
        Uname = new JLabel("User-Name:");
        Uname.setBounds(100, 200, 250, 30);
        Uname.setFont(new Font("Verdana", Font.BOLD,25));
        add(Uname);

        // user-name input textfield
        uname = new JTextField();
        uname.setBounds(400,200,250,30);
        uname.setFont(new Font("Aerial",Font.BOLD,21));
        uname.addActionListener(this);
        add(uname);

        //Password label
        Pass = new JLabel("Password:");
        Pass.setBounds(100, 280, 250, 30);
        Pass.setFont(new Font("Verdana", Font.BOLD,25));
        add(Pass);

        // Password input passwordfield
        password = new JPasswordField();
        password.setBounds(400,280,250,30);
        password.setFont(new Font("Aerial",Font.BOLD,21));
        password.addActionListener(this);
        add(password);

        // creating the signin button
        signin = new JButton("Sign In");
        signin.setFont(new Font("Aerial",Font.BOLD,18));
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setBounds(200,380,150,30);
        signin.addActionListener(this);
        add(signin);

        // creating the clear button
        clear = new JButton("Clear");
        clear.setFont(new Font("Aerial",Font.BOLD,18));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(410,380,150,30);
        clear.addActionListener(this);
        add(clear);

        // frame settings
        setLayout(null);
        double wh = screenSize.height/1.5;
        setBounds(0,0,screenSize.width/2, (int) wh);
        setLocation(screenSize.width/4,150);
        getContentPane().setBackground(new Color(222,185,134));
        setVisible(true);
    }

    // function to draw two lines one at the top and other at the bottom...
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5)); // Set the thickness of the line (5 pixels)
        g2d.drawLine(0, 80, 780, 80);

        g2d.setStroke(new BasicStroke(5)); // Set the thickness of the line (5 pixels)
        g2d.drawLine(0, 500, 780, 500);
    }

    // override function to implement actions....
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // setting up signin logic...
            if (e.getSource() == signin) {
                String UName = uname.getText();
                String Pass = password.getText();
                if(UName.equals("Harsh@123")){
                    if(Pass.equals("HDP@227")){
                        setVisible(false);
                        new HRHome();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Admin ID / Password is incorrect");
                }
            }
            // clearing both the text and password field if clear button is clicked
            else if(e.getSource() == clear){
                uname.setText("");
                password.setText("");
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    // main function....
    public static void main(String[] args) {
        new LoginPage();
    }
}

