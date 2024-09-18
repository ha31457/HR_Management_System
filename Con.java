package HR.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {
    Connection connection;
    Statement statement;
    public Con(){ // constructor
        // trying to establish connection with database
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HRMS","root","Ha@201205");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
