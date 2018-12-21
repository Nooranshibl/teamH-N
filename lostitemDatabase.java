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
	
	public static List<lostitem> getDataBase() {
        List<lostitem> myList = new ArrayList<lostitem>();
        try {
        	String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/lostitemDatabase";
            String username = "root";
            String password="";
            Class.forName(driver);
            Connection con = null;
            if (con == null) {
                con = DriverManager.getConnection(url, username, password);
            }
            System.out.println("Connection estd");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from lostitem");
            while (rs.next()) {
                lostitem tmp=new lostitem();
                tmp.setDescription(rs.getString(1));
                tmp.setCategory(rs.getString(2));
                myList.add(tmp);
            }
            con.close();
        } catch (Exception e) {
            System.out.print("Error : " + e.getMessage());
        }
        return myList;
    }
}
