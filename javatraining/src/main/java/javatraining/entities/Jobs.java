package javatraining.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "dbo", name = "Jobs", indexes = { @Index(columnList = "job_id, job_title", name = "IDX_ID_TITLE") })

public class Jobs {
	@Id
	@Column(name = "job_id", length = 10)
	private String jobId;

	@Column(name = "job_title", length = 255, nullable = false, unique = true)
	private String jobTitle;

	@Column(name = "min_salary", precision = 11, scale = 2)
	private double minSalary;

	@Column(name = "max_salary", precision = 11, scale = 2)
	private double maxSalary;

	public Jobs() {
	}

	public Jobs(String jobId, String jobTitle, double minSalary, double maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
	private Set<Employees> employees;

	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	public Jobs(String jobId, String jobTitle, double minSalary, double maxSalary, Set<Employees> employees) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary +"]";
	}

	
}
