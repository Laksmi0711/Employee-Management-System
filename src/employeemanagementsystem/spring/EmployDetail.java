package employeemanagementsystem.spring;

import java.util.Scanner;

public class EmployDetail {
	String first_name;
    String last_name;
    String email;
    String position;
    String employ_id;
    String employ_salary;
    String employ_contact;
    String employ_password;
    
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee's First Name --------: ");
        first_name=sc.nextLine();
        System.out.print("Enter Employee's Last name -: ");
        last_name=sc.nextLine();
        System.out.print("Enter Employee's ID ----------: ");
        employ_id=sc.nextLine();
        System.out.print("Enter Employee's Email ID ----: ");
        email=sc.nextLine();
        System.out.print("Enter Employee's Position ----: ");
        position=sc.nextLine();
        System.out.print("Enter Employee contact Info --: ");
        employ_contact=sc.nextLine();
        System.out.print("Enter Employee's Salary ------: ");
        employ_salary=sc.nextLine();
        System.out.print("Enter Employee's Password ------: ");
        employ_password=sc.nextLine();
    }

}
