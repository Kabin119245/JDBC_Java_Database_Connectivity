import java.sql.*;//1.import packages

public class DemoTwo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url =  "jdbc:postgresql://localhost:5432/College";
        String username = "postgres";
        String password = "****";
        String query = "select * from students";
//        Applications do not need to explicitly load the org.postgresql.Driver class because the pgJDBC driver jar supports the Java Service Provider mechanism. The driver will be loaded by the JVM when the application connects to PostgreSQL® (as long as the driver’s jar file is on the classpath).
//just doing now
        Class.forName("org.postgresql.Driver"); //2 mo need explicityly but still done
        Connection con = DriverManager.getConnection(url, username, password); //3.creating connection

        Statement st = con.createStatement();//4.creating the statement
        ResultSet rs = st.executeQuery(query); //5.executing the statement
        //as result is of multiple strings or tables, we use ResultSet

        while(rs.next()) {
            String userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getString(4);

            System.out.println(userData); //6.process the result
        }

       // 7. close the connections

        st.close();
        con.close();

    }


}
