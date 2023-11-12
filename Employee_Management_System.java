
import java.io.*;
import java.util.*;

class EmpDet implements Serializable{
    int id;
    String name;
    int age;
    String designation;
    String department;
    int salary;

    public EmpDet (int id, String name, int age, String designation, String department, int salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.designation=designation;
        this.department=department;
        this.salary=salary;

    } 
    public String toString()
    {
        return "\n ___EMPLOYEE DETAILS___  "+
        "\n ID : " + this.id +
        "\n NAME: " + this.name +
        "\n AGE: " + this.age+
        "\n DESIGNATION : " + this.designation+
        "\n DEPARTMENT : " + this.department+
        "\n SALARY: " + this.salary;
    }
}
public class Employee_Management_System
{
    static void display(ArrayList<EmpDet> alist)
    {
         System.out.println(" \n____________WELCOME TO EMPLOYEE MANAGEMENT SYSTEM____________");
        System.out.println(String.format("%-15s%-20s%-15s%-25s%-20s%-15s", "ID", "NAME", "AGE","DESIGNATION", "DEPARTMENT","SALARY"));
        for (EmpDet e : alist)
        {
        System.out.println(String.format("%-15s%-20s%-15s%-25s%-20s%-15s", e.id, e.name, e.age, e.designation, e.department, e.salary));
        }
    }

    public static void main (String[] args)
{
    int id;
    String name;
    int age;
    String designation;
    String department;
    int salary;
    Scanner sc = new Scanner(System.in);
    ArrayList<EmpDet>alist =new ArrayList<EmpDet>();

    File fi=null;
    FileInputStream fiss=null;
    ObjectInputStream oiss=null;
    FileOutputStream foss=null;
    ObjectOutputStream ooss=null;
    try{
        fi = new File("C:/Users/adith/Desktop/mine/EmployeeManagementSytem/EmployeeDataList.txt");
        if (fi.exists()){
            fiss =new FileInputStream(fi);
            oiss = new ObjectInputStream(fiss);
            alist= ( ArrayList<EmpDet>)oiss.readObject();
        }

    }

        catch(Exception exp){
            System.out.println(exp);
        }
    do {
          System.out.println(" \n____________WELCOME TO EMPLOYEE MANAGEMENT SYSTEM____________");
          System.out.println("\n\t\t\t1.Add Employee");
          System.out.println("\n\t\t\t2.View Employee");
          System.out.println("\n\t\t\t3.Update Employee");
          System.out.println("\n\t\t\t4.Delete Employee");
          System.out.println("\n\t\t\t5.View Employee List");
          System.out.println("\n\t\t\t6.Exit");

         System.out.println("\n ____________ ENETR A NUMBER TO CHOOSE A FUNCTION  ____________  ");
        int n =sc.nextInt();
        switch(n){
            case 1:
                System.out.println("Enter the details to add an Employee : \n");
                System.out.println("Enter ID: ");
                id=sc.nextInt();
                System.out.println("Enter Name: ");
                name=sc.next();
                System.out.println("Enter Age: ");
                age=sc.nextInt();
                System.out.println("Enter Designation: ");
                designation=sc.next();
                System.out.println("Enter Department: ");
                department=sc.next();
                System.out.println("Enter Salary: ");
                salary=sc.nextInt();
                alist.add(new EmpDet(id, name, age, designation, department, salary));
                display(alist);
                break;

            case 2:
                 System.out.println("Enter an Employee's ID to view their details : ");
                id=sc.nextInt();
                int a=0;
                for(EmpDet e:alist)
                {
                    if(id==e.id)
                    {
                        System.out.println(e+"\n");
                        a++;
                    }
                }
                if(a==0)
                {
                System.out.println("\n INVALID ID");
                System.out.println("\n The ID does not match with any existing Employee");

                }
                break;
            
            case 3:
            System.out.println("Enter an Employee's ID to update their details");
            id=sc.nextInt();
            int b=0;
            for(EmpDet e:alist)
            {
                if(id==e.id)
                {
                    b++;
                do{
                    
                    System.out.println("\n Select a number to update the details: ");
                    System.out.println("\n\t\t\t1.ID ");
                    System.out.println("\n\t\t\t2.Name ");
                    System.out.println("\n\t\t\t3.Age");
                    System.out.println("\n\t\t\t4.Designation");
                    System.out.println("\n\t\t\t5.Department");
                    System.out.println("\n\t\t\t6.Salary");
                    System.out.println("\n\t\t\t7.Exit");

                    
                    
                 System.out.println("\n ____________ ENETR A NUMBER TO CHOOSE THE FIELD THAT NEEDS AN UPDATE  ____________  ");
                int n1 =sc.nextInt();
                switch(n1)
                {   case 1:
                    System.out.println("\n Update ID : ");
                    e.id=sc.nextInt();
                    System.out.println(e+"\n");
                    break;

                    case 2:
                    System.out.println("\n Update Name : ");
                    e.name=sc.next();
                    System.out.println(e+"\n");
                    break;

                    case 3:
                    System.out.println("\n Update Age : ");
                    e.age=sc.nextInt();
                    System.out.println(e+"\n");
                    break;
                    
                    case 4:
                    System.out.println("\n Update Designation : ");
                    e.designation=sc.next();
                    System.out.println(e+"\n");
                    break;
                    
                    case 5:
                    System.out.println("\n Update Department : ");
                    e.department=sc.next();
                    System.out.println(e+"\n");
                    break;
                    
                    case 6:
                    System.out.println("\n Update Salary : ");
                    e.salary=sc.nextInt();
                    System.out.println(e+"\n");
                    break;

                    case 7: 
                    b++;
                    break;
                    
                    default:
                    System.out.println("\n Please enter the correct number ");
                    break;
                }
                }
                while(b==1);
                }

            }
            if (b==0)
            {
            System.out.println("\n INVALID ID");
            System.out.println("\n The ID does not match with any existing Employee");
            }
            break;

            case 4:
            System.out.println("\n Enter Employee ID to delete the details: ");
            id=sc.nextInt();
            int c=0;
            try{
                for(EmpDet e:alist)
            {
                if(id==e.id)
                {
                    alist.remove(e);
                    display(alist);
                    c++;
                }
            }
            if(c==0)
            {
            System.out.println("\n INVALID ID");
            System.out.println("\n The ID does not match with any existing Employee");
            }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            break;

            case 5:
            display(alist);
            break;

            case 6:
            System.out.println("THANK YOU FOR USING APPLICATION");
            break;

            default:
             System.out.println("\n Please enter the correct number : ");
            break;

        }
}
while (true);
}
}