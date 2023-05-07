package training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	public static void main(String[] args) throws SQLException {
		Connection con = DatabaseUtils.getConnection();
		
		// Đưa createStatement vào đây sẽ tự động .close() statement object
		try(Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
			ResultSet rs = st.executeQuery("SELECT * FROM Course");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(4));
			}
			
			st.addBatch("INSERT INTO Course(course_id, subject_id, course_code, title, number_of_credits) VALUES('1119', 'CSCI', '2134', 'Calculus III', 3);");
			st.addBatch("INSERT INTO Course(course_id, subject_id, course_code, title, number_of_credits) VALUES('1120', 'CSCI', '2132', 'Calculus IV', 3);");
			
			int []count = st.executeBatch();
			for (int i : count) {
				System.out.println("Số bản ghi: " + i);
			}
			
			String url = "INSERT INTO Course VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(url);
			pstmt.setString(1, "1121");
			pstmt.setString(2, "CSCI");
			pstmt.setString(3, "5482");
			pstmt.setString(4, "Cauclus V");
			pstmt.setInt(5, 2);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
