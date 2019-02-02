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
        String choices = "1]create\n2]insert\n3]update\n4]delete\n5]read\n6]man_Query\n7]list of tables\n8]drop table";
        Scanner scan = new Scanner(System.in);
        System.out.println(choices);
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
                    
                case 6:
                    System.out.print("Enter the SQL Query manually : ");
                    scan.useDelimiter("\n");
                    String man_Query = scan.next();
                    System.out.println(man_Query);
                    boolean type = Functions.queryType(man_Query);
                    ResultSet rs1;
                    int message4=0;
                    if(type)
                    {
                         rs1 = Functions.select_Query(man_Query);
                         while(rs1.next())
                         {
                            System.out.println(rs1.getInt(1)+rs1.getString(2));
                         }
                    }
                    else
                    {
                         message = Functions.nonSelect_Query(man_Query);
                         System.out.println(message4);
                    }     
                break;
                    
                case 7:
                    ResultSet tables = Functions.select_Query("show tables");
                    while(tables.next())
                    {
                            System.out.println(tables.getString(1));
                    }
                break;
                    
                case 8:
                    System.out.print("Enter the name of the table : ");
                    String table=scan.next();
                    int message5 = Functions.nonSelect_Query("drop table "+table);
                    System.out.println("message : "+message5);
                    break;
            }
            
            System.out.print("Do you want to continue?[1/0] : ");
            int iteration = scan.nextInt();
            
            bool = iteration==1;
            
            if(bool)
            {
                System.out.println(choices);
                c=scan.nextInt();
            }
        }
    }
}
