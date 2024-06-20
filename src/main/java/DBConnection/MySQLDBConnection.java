package DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLDBConnection {

	public static void main(String[] args) throws SQLException {
		
		Properties prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "cucumber.properties");
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String user=prop.getProperty("username");
		String password1=prop.getProperty("password");
		
		System.out.println("username : " + user + "  password : " + password1);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swaglabs","root","root"); //url/database name, username, password
				
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM EMPLOYEES WHERE username='"+user+"'");
		rs.next();
		int count=rs.getInt(1);
		System.out.println("count : " + count);
		
		if(count==0)
		{
			stmt.execute("INSERT INTO EMPLOYEES VALUES ('"+user+"','shru123')");
			System.out.println("Data inserted...........");
		}
		else
		{
			System.out.println("Data present");
		}
		
//		ResultSet rs1=stmt.executeQuery("SELECT * FROM EMPLOYEES");
//		
//		while(rs1.next())
//		{
//			String  username=rs1.getString("username");
//			String  password=rs1.getString("password");
//			
//			System.out.println("Printing inserted data : " + username+"   "+password);
//		}
		
		
		ResultSet rs2=stmt.executeQuery("SELECT COUNT(*) FROM EMPLOYEES");
		rs2.next();
		int countA=rs2.getInt(1);
		System.out.println("count : " + countA);
		if(countA!=0)
		{
			stmt.execute("DELETE FROM EMPLOYEES WHERE username='Shruthi'");
			System.out.println("Data deleted........");
		}


//	5.	Close connection.
				
		con.close();
				
		System.out.println("Query executed.......");
		

	}

}
