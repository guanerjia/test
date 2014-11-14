import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: GuanERjia
 * Date: 14-10-23
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName = master";
        String userName = "sa";
        String userPwd = "Passw0rd";
        Connection dbConn;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("Connection Successful!");
            //add for git test
            Statement statement = dbConn.createStatement();
            String sql = "SELECT [id]" +
                    ",[name]" +
                    ",[email]" +
                    " FROM [kwan].[dbo].[friend]";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
