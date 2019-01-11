package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Functions
{
    public static Connection connection()throws SQLException 
    {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
            return con;
    }
    
    public static int createTable(String table_name)throws SQLException
    {
            PreparedStatement pst = Functions.connection().prepareStatement("create table "+table_name+"(id int,name varchar(100))");
            int message = pst.executeUpdate();
            return message;
    }
    
    public static int insert(String table_name,int id,String name)throws SQLException
    {
        PreparedStatement pst = Functions.connection().prepareStatement("insert into "+table_name+"(id,name)values(?,?)");
        pst.setInt(1,id);
        pst.setString(2,name);
        int message = pst.executeUpdate();
        return message;
    }
    
    public static int update(String table_name,int oldid,int newid)throws SQLException
    {
        PreparedStatement pst = Functions.connection().prepareStatement("update "+table_name+" set id=? where id=?");
        pst.setInt(1,newid);
        pst.setInt(2,oldid);
        int message = pst.executeUpdate();
        return message;
    }
    
    public static int delete(String table_name,int id)throws SQLException
    {
        PreparedStatement pst = Functions.connection().prepareStatement("delete from "+table_name+" where id=?");
        pst.setInt(1, id);
        int message = pst.executeUpdate();
        return message;
    }
    
    public static ResultSet read(String table_name)throws SQLException
    {
        PreparedStatement pst = Functions.connection().prepareStatement("select * from "+table_name);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
}
