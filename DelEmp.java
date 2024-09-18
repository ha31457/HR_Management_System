package HR.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DelEmp extends JFrame implements ActionListener{

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // getting screen dimensions

    JButton logout, submit;
    JTextField idInp;
    JLabel Cname;

    //used after clicking submit button
    JLabel warning, Name, empName, Role, empRole;
    JButton delete;

    DelEmp(){ // constructor
        // setting title of the page
        super("Delete employee page");

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

        // creating label for id
        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(95,80,280,42);
        idLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        add(idLabel);

        //creating the textfield for id input
        idInp = new JTextField();
        idInp.setBounds(440,80,180,32);
        idInp.setFont(new Font("Verdana", Font.BOLD, 25));
        add(idInp);

        // creating a submit button to submit the data
        submit = new JButton("Submit");
        submit.setBounds(720,80,150,32);
        submit.setFont(new Font("Verdana", Font.BOLD, 22));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // creating the warning label
        warning = new JLabel();
        warning.setBounds(110,140,850,35);
        warning.setFont(new Font("Verdana", Font.BOLD, 28));
        add(warning);

        // creating name label
        Name = new JLabel();
        Name.setBounds(180,240,130,35);
        Name.setFont(new Font("Verdana", Font.BOLD,28));
        add(Name);

        // creating label for name from database
        empName = new JLabel();
        empName.setBounds(570,240,120,35);
        empName.setFont(new Font("Verdana", Font.BOLD,28));
        add(empName);

        // creating role label
        Role = new JLabel();
        Role.setBounds(180,320,120,35);
        Role.setFont(new Font("Verdana", Font.BOLD,28));
        add(Role);

        // creating label for role from database
        empRole = new JLabel();
        empRole.setBounds(570,320,120,35);
        empRole.setFont(new Font("Verdana", Font.BOLD,28));
        add(empRole);

        // creating the delete button
        delete = new JButton();
        delete.setBounds(430,425,140,35);
        delete.setFont(new Font("Verdana", Font.BOLD, 20));
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        // frame settings
        setLayout(null);
        double wh = screenSize.height/1.5;
        double ww = screenSize.width/1.5;
        setBounds(0,0,(int) ww, (int) wh);
        setLocation(screenSize.width/6,150);
        getContentPane().setBackground(new Color(222,185,134));
        setVisible(true);
    }

    // function to print 2 lines at top and bottom
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
        if(e.getSource() == submit){
            try{
                String id = idInp.getText();
                Con c = new Con();
                ResultSet resultSet = c.statement.executeQuery("select * from employees where empId = '"+id+"'");
                String empname = "", emprole = "";
                while(resultSet.next()) {
                    empname = resultSet.getString("Name");
                    emprole = resultSet.getString("Role");
                }
                Name.setText("Name:");
                empName.setText(empName.getText() + String.valueOf(empname));
                Role.setText("Role:");
                empRole.setText(empRole.getText() + String.valueOf(emprole));
                warning.setText("Warning: Please check the employee details below.");
                delete.setText("Delete");
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        if(e.getSource() == delete){
            int ans = JOptionPane.showConfirmDialog(null,"Are you sure?");
            if(ans == 0){
                try{
                    String id = idInp.getText();
                    Con c = new Con();
                    c.statement.executeUpdate("DELETE FROM employees WHERE empId = '"+id+"'");
                    JOptionPane.showMessageDialog(null,"Employee deleted succesfully");
                    setVisible(false);
                    new HRHome();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        }
    }

    // main function
    public static void main(String[] args) {
        new DelEmp();
    }
}