package employeemanagementsystem.spring;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employee_Add {
	
	Connection c = null;
	PreparedStatement pst = null;
	PreparedStatement ps = null;
	
	public void addEmp() throws SQLException {
        Scanner sc=new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EmployDetail emp = (EmployDetail) context.getBean("emp");

        emp.getInfo();
        
        c = dbConnect.connectDb();
        String sql = "insert into employee (emp_id,f_name,l_name,email,position,contact_num,salary,totalSalary,evaluation,password) values (?,?,?,?,?,?,?,?,?,?)";
        
        String queryCheck = "SELECT * FROM employee WHERE emp_id = ?";
        ps = c.prepareStatement(queryCheck);
        ps.setString(1, emp.employ_id);
        ResultSet resultSet = ps.executeQuery();
        
        try{
            
            if(resultSet.next()){
                
            	System.out.println("\nEmployee ID already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
            	
            	pst = c.prepareStatement(sql);
            	
            	pst.setString(1, emp.employ_id);
                pst.setString(2, emp.first_name);
                pst.setString(3, emp.last_name);
                pst.setString(4, emp.email);
                pst.setString(5, emp.position);
                pst.setString(6, emp.employ_contact);
                pst.setString(7, emp.employ_salary);
                pst.setInt(8, 0);
                pst.setString(9, "Pending");
                pst.setString(10, emp.employ_password);
                
                pst.execute();
               
                System.out.println("\nEmployee has been Added :)\n");

            }
        }
        catch(Exception e){System.out.println(e);}
    }

}
