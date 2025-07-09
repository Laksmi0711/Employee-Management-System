package employeemanagementsystem.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class dbConnect {
	Connection c = null;
    public static Connection connectDb(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/empsystem", "root", "");
//            JOptionPane.showMessageDialog(null, "Connected");
            return c;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
