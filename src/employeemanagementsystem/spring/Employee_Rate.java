package employeemanagementsystem.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.Statement;


public class Employee_Rate {
	Connection c = null;
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	PreparedStatement pst2 = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	
	int teamwork;
	int leadership;
	int comms;
	int prod;
	int integrity;
	
	public void viewEmp() throws Exception {
	    
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeManagementSystemSpringClient ems = (EmployeeManagementSystemSpringClient) context.getBean("ems");
	    
	    c = dbConnect.connectDb();
        String sql = "Select * From employee";
        pst = c.prepareStatement(sql);
        rs = pst.executeQuery();
        
        int x = 0;
        String evaluator = ems.username;
        
        try {
        	System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
        	System.out.printf("     Evaluate the competency of your co-workers. On a scale of 1 to 5, how would rate your co-workers?    %n");
            System.out.printf("          1 - Poor  2 - Unsatisfactory  3 - Satisfactory  4 - Very Satisfactory  5 - Outstanding    %n");
            System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
           
            while(rs.next()){
            	
            	String f_name = rs.getString("f_name");
            	String queryCheck = "SELECT * FROM employee_rating WHERE Evaluatedby = '"+f_name+"'";
                ps = c.prepareStatement(queryCheck);
                ps.execute();
                ps.executeQuery();
                
                String statusCheck = "SELECT * FROM employee WHERE f_name = '"+evaluator+"'";
                pst1 = c.prepareStatement(statusCheck);
                ResultSet resultSet = pst1.executeQuery();
                
//                if(resultSet.next()) {
//                	System.out.println("Evaluation is Pending!");
//                }
//                else {
//                 	System.out.println("Evaluation is Completed!");
//                	break;
//                }
                	
            	if(evaluator.equals(f_name)) {
            		continue;
            	}
            	
            	System.out.println("\nEmployee Name : " + rs.getString("f_name") + " " + rs.getString("l_name"));
            	
            	
            	System.out.print("Teamwork      : ");
            	teamwork = sc.nextInt();
                System.out.print("Leadership    : ");
                leadership = sc.nextInt();
                System.out.print("Communication : ");
                comms = sc.nextInt();
                System.out.print("Productivity  : ");
                prod = sc.nextInt();
                System.out.print("Integrity     : ");
                integrity = sc.nextInt();
                
                String q1 = "insert into employee_rating values('" +evaluator+ "','" +rs.getString("f_name")+ "','" +teamwork+ "','" +leadership+ "', '" +comms+
                                      "', '" +prod+ "', '" +integrity+ "')";
                ps = c.prepareStatement(q1);
                x = ps.executeUpdate(q1); 
            }
    
            String q2 = "UPDATE employee SET evaluation = 'Completed' WHERE f_name = '"+evaluator+"'";
			pst2 = c.prepareStatement(q2);
			pst2.executeUpdate(q2); 
            
            if (x > 0)                          
         	   System.out.println("\nYou Have Successfully Evaluated All Employees");           
      
        }catch (Exception e) {System.out.println(e);}
	}   
	}
//	public void viewEmp() throws SQLException {
//		Scanner sc = new Scanner(System.in);
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//		EmployeeManagementSystemSpringClient ems = (EmployeeManagementSystemSpringClient) context.getBean("ems");
//	    
//	    c = dbConnect.connectDb();
//        String sql = "Select * From employee";
//        pst = c.prepareStatement(sql);
//        rs = pst.executeQuery();
//        
//        String evaluator = ems.username;
//      
//      try {
//    	  
//      	  System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
//      	  System.out.printf("     Evaluate the competency of your co-workers. On a scale of 1 to 5, how would rate your co-workers?    %n");
//          System.out.printf("          1 - Poor  2 - Unsatisfactory  3 - Satisfactory  4 - Very Satisfactory  5 - Outstanding    %n");
//          System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
//          
//          	String f_name = rs.getString("f_name");
//          	String queryCheck = "SELECT * FROM employee_rating WHERE Evaluatedby = '"+f_name+"'";
//            ps = c.prepareStatement(queryCheck);
//            ps.execute();
//            rs1 = ps.executeQuery();
//              
//              String statusCheck = "SELECT * FROM employee WHERE f_name = '"+f_name+"' AND evaluation = 'Completed'";
//              pst1 = c.prepareStatement(statusCheck);
//              ResultSet resultSet = pst1.executeQuery();
//              
//              if(resultSet.next()) {
//                  
//              	System.out.println("Evaluation is Pending!");
//              }
//              else {
//              	System.out.println("Evaluation is Completed!");
//              }
//              	
//          	if(evaluator.equals(f_name)) {
//          	}
//          	
//          	System.out.println("\nEmployee Name : " + rs.getString("f_name") + " " + rs.getString("l_name"));
//          	
//          	
//          	System.out.print("Teamwork      : ");
//          	teamwork = sc.nextInt();
//              System.out.print("Leadership    : ");
//              leadership = sc.nextInt();
//              System.out.print("Communication : ");
//              comms = sc.nextInt();
//              System.out.print("Productivity  : ");
//              prod = sc.nextInt();
//              System.out.print("Integrity     : ");
//              integrity = sc.nextInt();
//              
//              String q1 = "INSERT INTO employee_rating (EvaluatedBy,First Name,Teamwork,Leadership,Communication,Productivity,Integrity) VALUES (?,?,?,?,?,?,?,?)";
//              ps = c.prepareStatement(q1);
//              ps.setString(1, evaluator);
//              ps.setString(2, f_name);
//              ps.setInt(3, teamwork);
//              ps.setInt(4, leadership);
//              ps.setInt(5, comms);
//              ps.setInt(6, prod);
//              ps.setInt(7, integrity);
//              ps.execute();
//  
//          String q2 = "UPDATE employee SET evaluation = 'Completed' WHERE f_name = '"+evaluator+"'";
//			pst2 = c.prepareStatement(q2);
//			pst2.execute();
//          
//      }catch (Exception e) {System.out.println(e);}
//	}
//}
