import java.sql.*;

public class Demo {

    public static void main(String[] args) throws SQLException {

        String sql = "select firstname from students where sid = 5";
        String url = "jdbc:postgresql://localhost:5432/College";
        String username = "postgres";
        String password = "2078";


        Connection con = DriverManager.getConnection(url,username, password);
        Statement st = con.createStatement();
        ResultSet rs =  st.executeQuery(sql);
        rs.next();
        String firstname = rs.getString(1);
        System.out.println(firstname);

        con.close();

    }
}
