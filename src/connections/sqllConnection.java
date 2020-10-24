package connections;

import java.sql.*;

import javax.swing.JOptionPane;

public class sqllConnection {
	Connection conn = null;
	

	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			String path = System.getProperty("user.dir");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+path+"\\bancoDadosGeman.db");
			return conn;
		}catch(Exception e) {
			return null;
		}
	}
}

