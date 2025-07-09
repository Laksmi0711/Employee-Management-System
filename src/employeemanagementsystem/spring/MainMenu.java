package employeemanagementsystem.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
	
	public void manager() {
	    System.out.println("\n**********************************************************************");
	    System.out.println("\tEMPLOYEE MANAGEMENT SYSTEM -> MANAGER/HR DASHBOARD");
	    System.out.println("\n**********************************************************************");
	    System.out.println("Press 1 : To Add an Employee Details");
	    System.out.println("Press 2 : To See an Employee Details ");
	    System.out.println("Press 3 : To Remove an Employee");
	    System.out.println("Press 4 : To Update Employee Details");
	    System.out.println("Press 5 : To Check Leave Application");
	    System.out.println("Press 6 : To View Evaluated Employees");
	    System.out.println("Press 7 : To Chat With Your Colleagues");
	    System.out.println("Press 8 : To Exit the EMS Portal");

	}
	
	public void employee() {
		System.out.println("\n**********************************************************************");
	    System.out.println("\tEMPLOYEE MANAGEMENT SYSTEM -> EMPLOYEE DASHBOARD");
	    System.out.println("\n**********************************************************************");
	    System.out.println("Press 1 : To See Employee Details ");
	    System.out.println("Press 2 : To Update Employee Details");
	    System.out.println("Press 3 : To Update Attendance");
	    System.out.println("Press 4 : To Apply for Leave");
	    System.out.println("Press 5 : To Rate Employees");
	    System.out.println("Press 6 : To Chat With Your Colleagues");
	    System.out.println("Press 7 : To Exit the EMS Portal");

	}

}
