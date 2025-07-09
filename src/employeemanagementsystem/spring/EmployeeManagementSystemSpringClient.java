package employeemanagementsystem.spring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmployeeManagementSystemSpringClient {
	
	static String s;
	static Connection c = null;
	static PreparedStatement pst = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	static String username;
	static String password;
	
	public static void managerLogin() throws SQLException {
		Scanner sc=new Scanner(System.in);
	    System.out.println("\nEnter username :");
	    username=sc.nextLine();
	    System.out.println("\nEnter password :");
	    password=sc.nextLine();
	    c = dbConnect.connectDb();
        String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
        pst = c.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        rs = pst.executeQuery();
        try {
            if(rs.next()){
            	System.out.println("\nLogin Successful!");
            }
            else{
            	System.out.println("Invalid Username & Password Combination");
            	managerLogin();
            }
        }catch (Exception e) {System.out.println(e);}

	}
	
	public static String employeeLogin() throws SQLException {
		Scanner sc=new Scanner(System.in);
	    System.out.println("\nEnter username :");
	    username=sc.nextLine();
	    System.out.println("\nEnter password :");
	    password=sc.nextLine();
	    c = dbConnect.connectDb();
        String sql = "SELECT * FROM employee WHERE f_name = ? AND password = ?";
        pst = c.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        rs = pst.executeQuery();
        try {
            if(rs.next()){
            	System.out.println("\nLogin Successful!");
            }
            else{
            	System.out.println("\nInvalid Username & Password Combination");
            	employeeLogin();
            }
        }catch (Exception e) {System.out.println(e);}
        return username;
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		dbConnect.connectDb();
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		/** To clear the output Screen **/
	    System.out.print("\033[H\033[2J");
	    
	    Scanner sc=new Scanner(System.in);
	    String i,login;
	    
	    do {
	    	System.out.println("\n****************************************************");
		    System.out.println("\tEMPLOYEE MANAGEMENT SYSTEM -> LOGIN PAGE");
		    System.out.println("****************************************************");
		    System.out.println("\nPress 1 : Manager/HR Login");
		    System.out.println("Press 2 : Employee Login");
		    System.out.println("Press 3 : To Exit");
		    login=sc.nextLine();
		    
	    	switch(login) {
		    
		    	case "1":
		    	{
		    		managerLogin();
		    		
		    		MainMenu menu = (MainMenu) context.getBean("menu");
		    		menu.manager();
		    		
		    		do {
		    			System.out.println("\nPlease Enter choice :");
		    		    i=sc.nextLine();

		    		    switch(i)
		    		    {
		    		        case "1":
		    		        {
		    		        Employee_Add ep = (Employee_Add) context.getBean("ep");
		    		        ep.addEmp();
		    		        
		    		        sc.nextLine();		    			        
	    			        System.out.print("\nPress Enter to Continue...");
	    		            sc.nextLine();
		    		        System.out.print("\033[H\033[2J");
		    		        menu.manager();
		    		        break;
		    		        }
		    		        case "2":
		    		        {
		    		          try
		    		          {
		    		      	    Employee_Show employee = (Employee_Show) context.getBean("employee");
		    		        	employee.viewEmp();
		    		          }catch(Exception e){System.out.println(e);}


		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.manager();
		    		          break;
		    		        }
		    		        case "3":
		    		        {
		    		          Employee_Remove epr = (Employee_Remove) context.getBean("epr");
		    		          epr.removeEmp(s);

		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.manager();
		    		          break;
		    		        }
		    		        case "4":
		    		        {
		    		            Employee_Update epu = (Employee_Update) context.getBean("epu");
		    		            try
		    		            {
		    		              epu.updateEmpManager();

			    		          sc.nextLine();
		    		              System.out.print("\nPress Enter to Continue...");
		    		              sc.nextLine();
		    		              System.out.print("\033[H\033[2J");
		    		              menu.manager();
		    		              break;
		    		            }
		    		            catch(IOException e)
		    		            {
		    		              System.out.println(e);
		    		            }
		    		        }
		    		        case "5":
		    		        {
		    		        	Employee_LeaveApplication ela = (Employee_LeaveApplication) context.getBean("ela");
		    			        ela.leaveApproval();

			    		        sc.nextLine();		    			        
		    			        System.out.print("\nPress Enter to Continue...");
		    		            sc.nextLine();
		    			        System.out.print("\033[H\033[2J");
		    			        menu.manager();
		    			        break;
		    		        }
		    		        case "6":
		    		        {
		    		          try
		    		          {
		    		      	    Employee_View employee = (Employee_View) context.getBean("view");
		    		        	employee.viewEmp();
		    		          }catch(Exception e){System.out.println(e);}


		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.manager();
		    		          break;
		    		        }
		    		        case "7":
		    		        {
		    		          Client.main(args);
		    		          
		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.manager();
		    		          break;
		    		        }
		    		        case "8":
		    		        {
		    		        	CodeExit obj = (CodeExit) context.getBean("obj");
		    		        	obj.out();
		    		        }
		    		    	default:
		    		    	{
		    		    		System.out.println("\nInvalid choice");
		    		    	}
		    		      }
		    			
		    		} while(!i.equalsIgnoreCase("8"));
		    	}
		    	case "2":
		    	{
		    		employeeLogin();
		    		
		    		MainMenu menu = (MainMenu) context.getBean("menu");
		    		menu.employee();
		    		do {
		    			
		    			System.out.println("\nPlease Enter choice :");
		    		    i=sc.nextLine();

		    		    switch(i)
		    		    {
		    		        case "1":
		    		        {
		    		          try
		    		          {

		    		      	    Employee_Show employee = (Employee_Show) context.getBean("employee");
		    		        	employee.viewEmp();
		    		          }catch(Exception e){System.out.println(e);}


		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.employee();
		    		          break;
		    		        }

		    		        case "2":
		    		        {
		    		            Employee_Update epu = (Employee_Update) context.getBean("epu");
		    		            try
		    		            {
		    		              epu.updateEmp();

			    		          sc.nextLine();
		    		              System.out.print("\nPress Enter to Continue...");
		    		              sc.nextLine();
		    		              System.out.print("\033[H\033[2J");
		    		              menu.employee();
		    		              break;
		    		            }
		    		            catch(IOException e)
		    		            {
		    		              System.out.println(e);
		    		            }
		    		        }
		    		        case "3":
		    		        {
		    		        	Employee_Attendance ea = (Employee_Attendance) context.getBean("ea");
		    			        ea.attendance();

			    		        sc.nextLine();
		    			        System.out.print("\nPress Enter to Continue...");
		    		            sc.nextLine();
		    			        System.out.print("\033[H\033[2J");
		    			        menu.employee();
		    			        break;
		    		        }
		    		        case "4":
		    		        {
		    		        	Employee_LeaveApplication ela = (Employee_LeaveApplication) context.getBean("ela");
		    			        ela.leaveApplication();

			    		        sc.nextLine();
		    			        System.out.print("\nPress Enter to Continue...");
		    		            sc.nextLine();
		    			        System.out.print("\033[H\033[2J");
		    			        menu.employee();
		    			        break;
		    		        }
		    		        case "5":
		    		        {
		    		          try
		    		          {

		    		      	    Employee_Rate rate = (Employee_Rate) context.getBean("rate");
		    		        	rate.viewEmp();
		    		          }catch(Exception e){System.out.println(e);}


		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.employee();
		    		          break;
		    		        }
		    		        case "6":
		    		        {
//		    		          try
//		    		          {
//		    		        	  System.out.print("\nProceed to chat...");
//		    		        	
//		    		          }catch(Exception e){System.out.println(e);}
			    		      Client.main(args);


		    		          sc.nextLine();
		    		          System.out.print("\nPress Enter to Continue...");
		    		          sc.nextLine();
		    		          System.out.print("\033[H\033[2J");
		    		          menu.manager();
		    		          break;
		    		        }
		    		        case "7":
		    		        {
		    		        	CodeExit obj = (CodeExit) context.getBean("obj");
		    		        	obj.out();
		    		        }
		    		    	default:
		    		    	{
		    		    		System.out.print("\nInvalid choice");
		    		    	}
		    		      }
		    		} while(!i.equalsIgnoreCase("7"));
		    	}
		    	case "3":
		        {
		        	CodeExit obj = (CodeExit) context.getBean("obj");
		        	obj.out();
		        }
		    	default:
		    	{
		    		System.out.println("\nInvalid choice");
		    	}
		    }
	    } while(!login.equalsIgnoreCase("3"));
	    
	}
}
