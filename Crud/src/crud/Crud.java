package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Crud 
{
    public static void main(String[] args)throws SQLException
    {
        int c=0;
        boolean bool = true;
        Scanner scan = new Scanner(System.in);
        System.out.print("1]create\n2]insert\n3]update\n4]delete\n5]read");
        c=scan.nextInt();
        while(bool)
        {
            switch(c)
            {
                case 1:
                    System.out.print("Enter the name of the table : ");
                    String table_name = scan.next();
                    int message = Functions.createTable(table_name);
                    System.out.println("message : "+message);
                    break;
               
                case 2:
                    System.out.print("Enter the name of the table : ");
                    table_name = scan.next();
                    System.out.print("Enter id : ");
                    int id = scan.nextInt();
                    System.out.print("Enter name : ");
                    String name = scan.next();
                    int message1 = Functions.insert(table_name,id,name);
                    System.out.println(message1);
                    System.out.println("message : "+message1);
                    break;
                
                case 3:
                    System.out.print("Enter the name of the table : ");
                    table_name = scan.next();
                    System.out.print("Enter the id you want to change : ");
                    int oldid=scan.nextInt();
                    System.out.print("Enter new id : ");
                    int newid=scan.nextInt();
                    int message2 = Functions.update(table_name,oldid,newid); 
                    System.out.println("message : "+message2);
                    break;
                    
                case 4:
                    System.out.print("Enter the name of the table : ");
                    table_name = scan.next();
                    System.out.print("Enter id of row you want to delete : ");
                    int delid = scan.nextInt();
                    int message3 = Functions.delete(table_name,delid);
                    System.out.println("message : "+message3);
                    break;
                    
                case 5:
                    System.out.print("Enter the name of the table : ");
                    table_name = scan.next();
                    ResultSet rs = Functions.read(table_name);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1)+rs.getString(2));
                    }
                break;
            }
            
            System.out.print("Do you want to continue?[1/0] : ");
            int iteration = scan.nextInt();
            
            bool = iteration==1;
            
            if(bool)
            {
                System.out.print("1]create\n2]insert\n3]update\n4]delete\n5]read");
                c=scan.nextInt();
            }
        }
    }
}
