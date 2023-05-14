package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbcutils.DBUtils;
import models.CourseModels;

public class CourseDAO {
	public static CourseDAO getInstance() {
		return new CourseDAO();
	}

	public List<CourseModels> listCourse() throws Exception {
		Connection con = DBUtils.getConnection();

		String url = "SELECT * FROM Course;";

		PreparedStatement statement = con.prepareStatement(url);

		ResultSet rs = statement.executeQuery();

		List<CourseModels> list = new ArrayList<>();

		while (rs.next()) {
			String course_id = rs.getString(1);
			String subject_idString = rs.getString(2);
			String course_code = rs.getString(3);
			String title = rs.getString(4);
			int number_of_credits = rs.getInt(5);

			CourseModels courseModels = new CourseModels(course_id, subject_idString, course_code, title,
					number_of_credits);
			
			list.add(courseModels);
		}
		return list;
	}
}
