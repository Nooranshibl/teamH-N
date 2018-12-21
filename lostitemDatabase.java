import java.sql.*;
import java.util.*;

public class lostitemDatabase {
	
	public void addLostitem (String Description , String Category)
	{
		try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/lostitemDatabase";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String query = "INSERT INTO lostitem VALUES(?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, Description);
            preparedStmt.setString(2, Category);
    
            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
	}
	

}

