package HR.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmp extends JFrame implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // getting screen dimensions
    JLabel Cname, empId;
    JButton logout, submit;
    JTextField NameInp,RoleInp, DeptInp, AttenInp, SalaryInp;
    int idNum = (int) (Math.random()*(99999 - 10000 + 1) + 10000);
    AddEmp(){ // constructor
        // giving title to page
        super("Add Employee !");

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

        // creating label for Id
        JLabel Id = new JLabel("Emp Id");
        Id.setBounds(50,100,200,32);
        Id.setFont(new Font("Verdana", Font.BOLD,26));
        add(Id);

        // creating label to show employee Id
        empId = new JLabel("" + idNum);
        empId.setBounds(280,100,200,32);
        empId.setFont(new Font("Verdana", Font.BOLD,26));
        add(empId);

        // creating name label
        JLabel name = new JLabel("Name");
        name.setBounds(530,100,200,32);
        name.setFont(new Font("Verdana", Font.BOLD,26));
        add(name);

        // creating input for name
        NameInp = new JTextField();
        NameInp.setBounds(760,100,200,32);
        NameInp.setFont(new Font("Verdana", Font.BOLD,23));
        add(NameInp);

        // creating role label
        JLabel role = new JLabel("Role");
        role.setBounds(530, 225, 200, 32);
        role.setFont(new Font("Verdana", Font.BOLD,26));
        add(role);

        // creating input for role
        RoleInp = new JTextField();
        RoleInp.setBounds(760,225,200,32);
        RoleInp.setFont(new Font("Verdana", Font.BOLD,23));
        add(RoleInp);

        // creating Department label
        JLabel dept = new JLabel("Department");
        dept.setBounds(50, 225, 200, 32);
        dept.setFont(new Font("Verdana", Font.BOLD,26));
        add(dept);

        // creating input for Department
        DeptInp = new JTextField();
        DeptInp.setBounds(280,225,200,32);
        DeptInp.setFont(new Font("Verdana", Font.BOLD,23));
        add(DeptInp);

        // creating Salary label
        JLabel salary = new JLabel("Salary");
        salary.setBounds(530, 355, 200, 32);
        salary.setFont(new Font("Verdana", Font.BOLD,26));
        add(salary);

        // creating input for Salary
        SalaryInp = new JTextField();
        SalaryInp.setBounds(760,355,200,32);
        SalaryInp.setFont(new Font("Verdana", Font.BOLD,23));
        add(SalaryInp);

        // creating attendace label
        JLabel attendance = new JLabel("Attendance");
        attendance.setBounds(50, 355,200,32);
        attendance.setFont(new Font("Verdana", Font.BOLD,26));
        add(attendance);

        // creating input for attendance
        AttenInp = new JTextField();
        AttenInp.setBounds(280,355,200,32);
        AttenInp.setFont(new Font("Verdana", Font.BOLD,23));
        add(AttenInp);

        // creating a submit button to submit data
        submit = new JButton("SUBMIT");
        submit.setBounds(445,430,120,30);
        submit.setFont(new Font("Aerial",Font.BOLD,18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // frame settings
        setLayout(null);
        double wh = screenSize.height/1.5;
        double ww = screenSize.width/1.5;
        setBounds(0,0,(int) ww, (int) wh);
        setLocation(screenSize.width/6,150);
        getContentPane().setBackground(new Color(222,185,134));
        setVisible(true);
    }

    // function to print 2 black lines at top and bottom
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0,80,1024,80);

        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0,515,1024,515);
    }

    // function to implement actionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logout){
            setVisible(false);
            new LoginPage();
        }else if(e.getSource() == submit){
            try{
                Con c = new Con();
                if(NameInp.getText().isEmpty() || RoleInp.getText().isEmpty() || DeptInp.getText().isEmpty() || AttenInp.getText().isEmpty() || SalaryInp.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"No field should be empty...");
                }else {
                    String name = NameInp.getText();
                    String role = RoleInp.getText();
                    String department = DeptInp.getText();
                    String attendence = AttenInp.getText();
                    String salary = SalaryInp.getText();

                    String q = "insert into employees values('"+name+"','"+role+"','"+department+"', '"+attendence+"', '"+salary+"','"+idNum+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Employee details added sucessfully !");
                    setVisible(false);
                    new HRHome();
                }
            } catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    // main function
    public static void main(String[] args) {
        new AddEmp();
    }
}
