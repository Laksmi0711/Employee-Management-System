package employeemanagementsystem.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Employee_LeaveApplication {
	
	Connection c = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	
	public void leaveApplication() throws SQLException {
		int input,nod;
		String r,empId;
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		Scanner sc = new Scanner(System.in);

	    System.out.println("\n*****************************************************************");
	    System.out.println("\tEMPLOYEE MANAGEMENT SYSTEM -> Leave Application");
	    System.out.println("*****************************************************************");
		
	    System.out.println("\nEnter your employee ID:");
	    empId = sc.nextLine();
        
        c = dbConnect.connectDb();
        
        String queryCheck = "SELECT * FROM employee WHERE emp_id = ?";
        ps = c.prepareStatement(queryCheck);
        ps.setString(1, empId);
        ResultSet resultSet = ps.executeQuery();
        
        if(resultSet.next()) {
        	
        	do {
            	System.out.println("\nPress 1 : To Apply for Paid Leave");
        		System.out.println("Press 2 : To Apply for Unpaid Leave");
        	    System.out.println("Press 3 : To Apply for Sick Leave");
        	    System.out.println("Press 4 : To Check Application Status");
        	    System.out.println("Press 5 : To Exit");
                input = sc.nextInt();
                
                String leave = "INSERT INTO holiday (employeeId,leaveType,reasonOrProof,numberOfDays,applicationStatus) values ('"+empId+"',?,?,?,?)";
                
            	switch (input) 
                {
        	        case 1:
        	        {
        	            
        	    		System.out.println("\nWhat is the reason for this application?");
        	            r = sc.nextLine();
        	            r = sc.nextLine();
        	            
        	            System.out.println("\nHow many days are you applying for?");
        	    		nod = sc.nextInt();
        	    		
        	        	ps = c.prepareStatement(leave);
        	        	ps.setString(1, "Paid Leave");
        	        	ps.setString(2, r);
        	        	ps.setInt(3, nod);
        	        	ps.setString(4, "In Review");
        	        	ps.execute();
        	        	break;
        	        }
        	        case 2:
        	        {
        	            
        	    		System.out.println("\nWhat is the reason for this application?");
        	            r = sc.nextLine();
        	            r = sc.nextLine();
        	            
        	            System.out.println("\nHow many days are you applying for?");
        	    		nod = sc.nextInt();
        	    		
        	        	ps1 = c.prepareStatement(leave);
        	        	ps1.setString(1, "Unpaid Leave");
        	        	ps1.setString(2, r);
        	        	ps1.setInt(3, nod);
        	        	ps1.setString(4, "In Review");
        	        	ps1.execute();
        	        	break;
        	        }
        	        case 3:
        	        {
        	    		System.out.println("\nProvide a link to access your medical certificate.");
        	            r = sc.nextLine();
        	            r = sc.nextLine();
        	            
        	            System.out.println("\nHow many days are you applying for?");
        	    		nod = sc.nextInt();
        	    		
        	        	ps2 = c.prepareStatement(leave);
        	        	ps2.setString(1, "Sick Leave");
        	        	ps2.setString(2, r);
        	        	ps2.setInt(3, nod);
        	        	ps2.setString(4, "In Review");
        	        	ps2.execute();
        	        	break;
        	        }
        	        case 4:{
        	        	System.out.println("\nLeave Application Status.....");
        	        	String display = "SELECT * FROM holiday WHERE employeeId = '"+empId+"' ";
        	            Statement s = c.createStatement();
        	            ResultSet rs = s.executeQuery(display);
        	            DBTablePrinter.printResultSet(rs);
        	        	break;
        	        }
        	        case 5:{
        	        	return;
        	        }
                }
            	
            } while (input!=5);
        }
        else {
    	        System.out.println("\nEmployee does not exists :( ");
        }
        
	}

	
	public void leaveApproval() throws SQLException {
		int a,b,id;
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); 
		Scanner sc = new Scanner(System.in);
        c = dbConnect.connectDb();
        
        do {
    	    System.out.println("\n************************************************************************");
    	    System.out.println("\tEMPLOYEE MANAGEMENT SYSTEM -> Employee Leave Management");
    	    System.out.println("************************************************************************");

    		System.out.println("\nLeave Applications");
            String display = "SELECT * FROM holiday WHERE applicationStatus = 'In Review'";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(display);
            DBTablePrinter.printResultSet(rs);
            System.out.println("\nPress 1 : To Proceed with Approval");
    		System.out.println("Press 2 : To Exit");
            a = sc.nextInt();
        	
        	switch (a) {
	        	case 1:
	        	{
	        		System.out.println("\nLeave Applications");
	                Statement s1 = c.createStatement();
	                ResultSet rs1 = s1.executeQuery(display);
	                DBTablePrinter.printResultSet(rs1);
	            	System.out.println("\nEnter Application ID");
	            	id = sc.nextInt();
	                

                	String sql = "UPDATE holiday SET applicationStatus = ? WHERE id = ?;";
                	System.out.println("\nPress 1 : To Approve");
	        		System.out.println("Press 2 : To Reject");
	                b = sc.nextInt();
	                
                	switch (b) {
		                case 1:
		                {
			                ps1 = c.prepareStatement(sql);
			                ps1.setString(1, "Approved");
			                ps1.setInt(2, id);
			                ps1.execute();
			                break;
		                }
		                case 2:
		                {
		                	ps2 = c.prepareStatement(sql);
			                ps2.setString(1, "Rejected");
			                ps2.setInt(2, id);
			                ps2.execute();
			                break;
		                }
                	}
                	
                	break;
	        	}
	        	case 2:
	        	{
	        		return;
	        	}
	        	default:
	        	{
		    		System.out.println("\nInvalid choice");
	        	}
        	}
        	
        } while (a!=2);
		
		
	}

}