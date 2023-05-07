package training;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName = TrainingDB; user=sa; password=nguyetminh110903;encrypt=true;trustServerCertificate=true");

			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
