package employeemanagementsystem.spring;

import java.awt.Menu;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee_Remove {
	
	Connection c = null;
	PreparedStatement ps = null;
	PreparedStatement pst = null;
	
	public void removeEmp(String ID) throws SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        EmployeeManagementSystemSpringClient menu = (EmployeeManagementSystemSpringClient) context.getBean("menu");
	
        System.out.print("\nPlease Enter Employee's ID :");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        
        c = dbConnect.connectDb();
//        String emp_id = menu.s;
        String emp_id = s;
        
        String queryCheck = "SELECT * FROM employee WHERE emp_id = ?";
        ps = c.prepareStatement(queryCheck);
        ps.setString(1, emp_id);
        ResultSet resultSet = ps.executeQuery();
        
        if(resultSet.next()) {
        	String sql = "DELETE FROM `employee` WHERE emp_id = ?";
            pst = c.prepareStatement(sql);
            pst.setString(1, emp_id);
            pst.execute();
        	
        	System.out.println("\nEmployee has been removed Successfully");
	    
        }
        else {
	        System.out.println("\nEmployee does not exists :( ");
        }
    }

}