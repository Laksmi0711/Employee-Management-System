package employeemanagementsystem.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee_Attendance {
	
	Connection c = null;
	PreparedStatement pst = null;
	PreparedStatement ps = null;
	Statement co = null;
	
	public void attendance() throws SQLException {
		int input;
		String empId;
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Scanner sc = new Scanner(System.in);
        c = dbConnect.connectDb();
    	System.out.println("\n*******************************************************************");
	    System.out.println("\tEMPLOYEE MANAGEMENT SYSTEM -> Attendance Management");
	    System.out.println("*******************************************************************");
	    System.out.println("\nEnter your employee ID: ");
	    empId = sc.nextLine();
	    
	    String queryCheck = "SELECT * FROM employee WHERE emp_id = ?";
	    ps = c.prepareStatement(queryCheck);
	    ps.setString(1, empId);
	    ResultSet resultSet = ps.executeQuery();
	    
	    if(resultSet.next()) {
	    	
	    	System.out.println("\nPress 1 : To Clock-in");
		    System.out.println("Press 2 : To Clock-out");
	        input = sc.nextInt();
	        c = dbConnect.connectDb();
	        String clockIn = "INSERT INTO attendance (employeeId,activity,salaryPerDay) values (?,?,?)";
	        String sql1 = "SET @es = (SELECT salary FROM employee WHERE emp_id = '"+empId+"')";
	        String sql2 = "SET @ci = (SELECT attTime FROM attendance WHERE activity = 'Clocked In.....' AND employeeId = '"+empId+"' AND attDate = CURRENT_DATE)";
	        String sql3 = "SET @co = CURRENT_TIME";
	        String sql4 = "SET @td = TIMEDIFF(@co,@ci)";
	        String sql5 = "SET @d = CAST(@td AS INT)";
	        String sql6 = "SET @s = @es * @d";
	        String sql7 = "INSERT INTO attendance (employeeId,activity,salaryPerDay) values ('"+empId+"','Clocked Out.....',@s)";
	        String sql8 = "UPDATE employee SET totalSalary = totalSalary + @s WHERE emp_id = '"+empId+"'";
	        
	        switch (input) 
	        {
		        case (1):
		        {
		        	ps = c.prepareStatement(clockIn);
		        	ps.setString(1, empId);
		        	ps.setString(2, "Clocked In.....");
		        	ps.setInt(3, 0);
		        	ps.execute();
			    	System.out.println("\nClocked in.....");
		        	break;
		        }
		        case (2):
		        {
		        	co = c.createStatement();
		        	co.addBatch(sql1);
		        	co.addBatch(sql2);
		        	co.addBatch(sql3);
		        	co.addBatch(sql4);
		        	co.addBatch(sql5);
		        	co.addBatch(sql6);
		        	co.addBatch(sql7);
		        	co.addBatch(sql8);
		        	co.executeBatch();
			    	System.out.println("\nClocked out.....");
		        	break;
		        }
	        }
	    }
	    else {
		        System.out.println("\nEmployee does not exists :( ");
	    }
		
	}
	
}