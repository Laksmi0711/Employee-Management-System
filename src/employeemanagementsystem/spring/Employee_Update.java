package employeemanagementsystem.spring;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee_Update {
	
	Connection c = null;
	PreparedStatement ps = null;
	PreparedStatement pst = null;
	
	public void updateEmp() throws IOException, SQLException {
	   
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//    	 EmployeeManagementSystemSpringClient menu = (EmployeeManagementSystemSpringClient) context.getBean("menu");
	
       System.out.print("\nPlease Enter Employee's ID :");
       Scanner sc=new Scanner(System.in);
       String s=sc.nextLine();
     
       c = dbConnect.connectDb();
//       String emp_id = menu.s;
       String emp_id = s;
       
       String queryCheck = "SELECT * FROM employee WHERE emp_id = ?";
       ps = c.prepareStatement(queryCheck);
       ps.setString(1, emp_id);
       ResultSet resultSet = ps.executeQuery();
       
       String sql;
       
       if(resultSet.next()) {
       	
    	   while(true){
               System.out.println("\nType 1 to update First Name, \n2 for Last Name, \n3 for Email ID, \n4 for Position, \n5 for Contact Number, \n6 for Salary, \n7 for Password, and \n8 to exit:");
               int editData = sc.nextInt();

               switch(editData) {
                   case 1:
	            	   System.out.print("\nEnter new First Name :");
                	   sc.nextLine();
	                   String f_name = sc.nextLine();
	                   
	                   sql = "UPDATE employee SET f_name = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setString(1, f_name);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's First Name has been updated Successfully");
                     break;
                   case 2:
                	   System.out.print("\nEnter new Last Name :");
                	   sc.nextLine();
	                   String l_name = sc.nextLine();
	                   
	                   sql = "UPDATE employee SET l_name = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setString(1, l_name);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's Last Name has been updated Successfully");
                     break;
                   case 3:
                	   System.out.print("\nEnter new Email ID :");
                	   sc.nextLine();
	                   String email = sc.nextLine();
	                   
	                   sql = "UPDATE employee SET email = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setString(1, email);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's Email ID has been updated Successfully");
                     break;
                   case 4:
                	   System.out.print("\nEnter new Position :");
                	   sc.nextLine();
	                   String position = sc.nextLine();
	                   
	                   sql = "UPDATE employee SET position = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setString(1, position);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's Position has been updated Successfully");
                     break;
                   case 5:
                	   System.out.print("\nEnter new Contact Number :");
                	   sc.nextLine();
	                   int contact_num = sc.nextInt();
	                   
	                   sql = "UPDATE employee SET contact_num = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setInt(1, contact_num);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's Contact Number has been updated Successfully");
                       break;
                   case 6:
                	   System.out.print("\nEnter new Salary :");
                	   sc.nextLine();
	                   int salary = sc.nextInt();
	                   
	                   sql = "UPDATE employee SET salary = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setInt(1, salary);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's Salary has been updated Successfully");
                       break;
                   case 7:
                	   System.out.print("\nEnter new Password:");
                	   sc.nextLine();
	                   String password = sc.nextLine();
	                   
	                   sql = "UPDATE employee SET password = ? WHERE emp_id = ?;";
	                   pst = c.prepareStatement(sql);
	                   pst.setString(1, password);
	                   pst.setString(2, emp_id);
	                   pst.execute();
	                   
	                   System.out.println("\nEmployee's Password has been updated Successfully");
                       break;
                   case 8:
                	   return;
                   default:
                     System.out.println("Invalid field!");
               }
               
           }
	    
       }
       else {
	        System.out.println("\nEmployee does not exists :( ");
       }

	  }
	
	public void updateEmpManager() throws IOException, SQLException {
		   
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//	    	 EmployeeManagementSystemSpringClient menu = (EmployeeManagementSystemSpringClient) context.getBean("menu");
		
	       System.out.print("\nPlease Enter Employee's ID :");
	       Scanner sc=new Scanner(System.in);
	       String s=sc.nextLine();
	     
	       c = dbConnect.connectDb();
//	       String emp_id = menu.s;
	       String emp_id = s;
	       
	       String queryCheck = "SELECT * FROM employee WHERE emp_id = ?";
	       ps = c.prepareStatement(queryCheck);
	       ps.setString(1, emp_id);
	       ResultSet resultSet = ps.executeQuery();
	       
	       String sql;
	       
	       if(resultSet.next()) {
	       	
	    	   while(true){
	               System.out.println("\nType 1 to update First Name, \n2 for Last Name, \n3 for Email ID, \n4 for Position, \n5 for Contact Number, \n6 for SalaryPerHour, \n7 for Salary, \n8 for Password, and \n9 to exit:");
	               int editData = sc.nextInt();

	               switch(editData) {
	                   case 1:
		            	   System.out.print("\nEnter new First Name :");
	                	   sc.nextLine();
		                   String f_name = sc.nextLine();
		                   
		                   sql = "UPDATE employee SET f_name = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setString(1, f_name);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's First Name has been updated Successfully");
	                     break;
	                   case 2:
	                	   System.out.print("\nEnter new Last Name :");
	                	   sc.nextLine();
		                   String l_name = sc.nextLine();
		                   
		                   sql = "UPDATE employee SET l_name = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setString(1, l_name);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's Last Name has been updated Successfully");
	                     break;
	                   case 3:
	                	   System.out.print("\nEnter new Email ID :");
	                	   sc.nextLine();
		                   String email = sc.nextLine();
		                   
		                   sql = "UPDATE employee SET email = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setString(1, email);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's Email ID has been updated Successfully");
	                     break;
	                   case 4:
	                	   System.out.print("\nEnter new Position :");
	                	   sc.nextLine();
		                   String position = sc.nextLine();
		                   
		                   sql = "UPDATE employee SET position = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setString(1, position);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's Position has been updated Successfully");
	                     break;
	                   case 5:
	                	   System.out.print("\nEnter new Contact Number :");
	                	   sc.nextLine();
		                   int contact_num = sc.nextInt();
		                   
		                   sql = "UPDATE employee SET contact_num = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setInt(1, contact_num);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's Contact Number has been updated Successfully");
	                       break;
	                   case 6:
	                	   System.out.print("\nEnter new SalaryPerHour :");
	                	   sc.nextLine();
		                   int salaryPerHour = sc.nextInt();
		                   
		                   sql = "UPDATE employee SET salary = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setInt(1, salaryPerHour);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's SalaryPerHour has been updated Successfully");
	                       break;
	                   case 7:
	                	   System.out.print("\nEnter new Salary:");
	                	   sc.nextLine();
		                   String salary = sc.nextLine();
		                   
		                   sql = "UPDATE employee SET totalSalary = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setString(1, salary);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's Salary has been updated Successfully");
	                       break;
	                   case 8:
	                	   System.out.print("\nEnter new Password:");
	                	   sc.nextLine();
		                   String password = sc.nextLine();
		                   
		                   sql = "UPDATE employee SET password = ? WHERE emp_id = ?;";
		                   pst = c.prepareStatement(sql);
		                   pst.setString(1, password);
		                   pst.setString(2, emp_id);
		                   pst.execute();
		                   
		                   System.out.println("\nEmployee's Password has been updated Successfully");
	                       break;
	                   case 9:
	                	   return;
	                   default:
	                     System.out.println("Invalid field!");
	               }
	               
	           }
		    
	       }
	       else {
		        System.out.println("\nEmployee does not exists :( ");
	       }

		  }

}