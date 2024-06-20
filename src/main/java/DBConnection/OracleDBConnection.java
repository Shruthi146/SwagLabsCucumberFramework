package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDBConnection {
	
	// JDBC URL, username, and password of Oracle server
    private static final String URL = "jdbc:oracle:thin:@ymx01s.gfs.com:45001:ymx01s"; 
    private static final String USER = "ssp_appl"; 
    private static final String PASSWORD = "streetApp$11"; 

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the Oracle database successfully!");

            // Create a statement object
            statement = connection.createStatement();

            // Execute a query
            String sql = "SELECT * FROM ssp_system_param where ssp_system_param_id='PRE_PROD_NEXT_WEEK_EFFECT_DATE_TODAY_ON_SUN_TO_THU'"; // Change to your table
            resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                System.out.println("ssp_system_param_id       " + resultSet.getString("ssp_system_param_id")); 
                System.out.println("ssp_system_param_value    " + resultSet.getString("ssp_system_param_value"));
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
