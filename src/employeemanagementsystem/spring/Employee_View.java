package employeemanagementsystem.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee_View {
	Connection c = null;
	PreparedStatement ps = null;
	PreparedStatement pst = null;
	
	public void viewEmp() throws Exception {
	    
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
        c = dbConnect.connectDb();
        
        String queryCheck = "SELECT * FROM employee_rating";
        ps = c.prepareStatement(queryCheck);
        ResultSet resultSet = ps.executeQuery();
        
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                      List of All Evaluated Employees         %n");
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-15s | %-10s | %-10s | %-15s | %-15s | %-10s | %-20s |%n", "FIRST NAME", "EVALUATED BY", "TEAMWORK", "LEADERSHIP", "COMMUNICATION", "PRODUCTIVITY", "INTEGRITY", "OVERALL PERFORMANCE (%)");
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------%n");

        while(resultSet.next()) {
        	int a = resultSet.getInt("Teamwork");
        	int b = resultSet.getInt("Leadership");
        	int c = resultSet.getInt("Communication");
        	int d = resultSet.getInt("Productivity");
        	int e = resultSet.getInt("Integrity");
        	int sum = (int) (((a + b + c + d + e) / (double) 25) * 100);
        	String sum1 = sum + "%";
        	
        	System.out.printf("| %-15s | %-15s | %6s     | %6s     | %8s        | %8s        | %6s     | %13s           |%n", resultSet.getString("First Name") , resultSet.getString("EvaluatedBy") , resultSet.getInt("Teamwork"), resultSet.getInt("Leadership"), 
        		  resultSet.getInt("Communication"), resultSet.getInt("Productivity"), resultSet.getInt("Integrity"), sum1);
	    
        }
	}
}
