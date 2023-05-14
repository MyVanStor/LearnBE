package models;

public class CourseModels {
	private String course_id;
	private String subject_idString;
	private String course_code;
	private String title;
	private int number_of_credits;

	public CourseModels(String course_id, String subject_idString, String course_code, String title,
			int number_of_credits) {
		this.course_id = course_id;
		this.subject_idString = subject_idString;
		this.course_code = course_code;
		this.title = title;
		this.number_of_credits = number_of_credits;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getSubject_idString() {
		return subject_idString;
	}

	public void setSubject_idString(String subject_idString) {
		this.subject_idString = subject_idString;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber_of_credits() {
		return number_of_credits;
	}

	public void setNumber_of_credits(int number_of_credits) {
		this.number_of_credits = number_of_credits;
	}

	@Override
	public String toString() {
		return "CourseModels [course_id=" + course_id + ", subject_idString=" + subject_idString + ", course_code="
				+ course_code + ", title=" + title + ", number_of_credits=" + number_of_credits + "]\n";
	}
}
