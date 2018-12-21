import  java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class userDataBase //create class Connectivity
{
    static Connection connection=null;
    static String url = "jdbc:mysql://localhost:3306/userdatabase";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "";
    static Connection con = null;

    public static List<User> getDataBase() {
        List<User> myList = new ArrayList<User>();
        try {
            Class.forName(driver);
            if (con == null) {
                con = DriverManager.getConnection(url, userName, password);
            }
            System.out.println("Connection estd");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                User tmp=new User();
                tmp.setEmail(rs.getString(1));
                tmp.setName(rs.getString(2));
                tmp.setPassWord(rs.getString(3));
                tmp.setPhoneNum(rs.getInt(4));
                myList.add(tmp);
                //System.out.println(rs.getString(1) + "  " + rs.getString(2)+"  "+rs.getString(3)+ "  " +rs.getInt(4));
            }
            con.close();
        } catch (Exception e) {
            System.out.print("Error : " + e.getMessage());
        }
        return myList;
    }

    public void insert(String email, String name,String passWord,int phoneNum) {
        try
        {
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/userdatabase";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String query = "INSERT INTO user(email,name,passWord,phoneNum)"+" VALUES(?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3,passWord);
            preparedStmt.setInt(4,phoneNum);

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