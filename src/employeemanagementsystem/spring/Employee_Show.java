package employeemanagementsystem.spring;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee_Show {
	
	Connection c = null;
	PreparedStatement ps = null;
	PreparedStatement pst = null;
	
	public void viewEmp() throws Exception {
	    
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//     	 EmployeeManagementSystemSpringClient menu = (EmployeeManagementSystemSpringClient) context.getBean("menu");
	
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
        	
        	System.out.println("\nFirst Name     : " + resultSet.getString("f_name"));
        	System.out.println("Last Name      : " + resultSet.getString("l_name"));
        	System.out.println("Email ID       : " + resultSet.getString("email"));
        	System.out.println("Position       : " + resultSet.getString("position"));
        	System.out.println("Contact Number : " + resultSet.getInt("contact_num"));
        	System.out.println("Salary/Hour    : " + resultSet.getInt("salary"));
        	System.out.println("Salary         : " + resultSet.getInt("totalSalary"));
        	System.out.println("Password       : " + resultSet.getString("password"));
	    
        }
        else {
	        System.out.println("\nEmployee does not exists :( ");
        }
	}


}

