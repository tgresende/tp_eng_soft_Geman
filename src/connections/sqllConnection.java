package connections;

import java.sql.*;

public class sqllConnection {
	Connection conn = null;
	

	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Tulio\\Desktop\\Eng Software\\test_proj.db");
			return conn;
		}catch(Exception e) {
			return null;
		}
	}
}

