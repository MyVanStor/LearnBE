package javatraining.main;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javatraining.dao.EmployeeDaoImpl;
import javatraining.dao.JobDaoImpl;
import javatraining.entities.Employees;
import javatraining.entities.Jobs;

public class MainTest {
	public static void main(String[] args) throws Exception {
//		SessionFactory session = HibernateUtils.getSessionFactory();

		EmployeeDaoImpl daoImpl = new EmployeeDaoImpl();
		JobDaoImpl jobImpl = new JobDaoImpl();
//		Jobs job = new Jobs("J002", "Java fresher IT", 10, 20, null);
//		jobImpl.save(job);
//		Employees e = new Employees(0, "Nguyen", "Van", "Van.nd215512", "0382823", LocalDate.now(), 15, 30, null);
//		
//		e.setJob(job);
//		daoImpl.save(e);

		Employees e = new Employees(0, "Nguyen", "Van", "Vannd215512", "038282", LocalDate.now(), 15, 30, null);
		Employees e1 = new Employees(0, "Nguyen", "Van", "Van1nd215512", "03828", LocalDate.now(), 15, 30, null);
		Employees e2 = new Employees(0, "Nguyen", "Van", "Van2nd215512", "0382", LocalDate.now(), 15, 30, null);
		Employees e3 = new Employees(0, "Nguyen", "Van", "Van3nd215512", "038223", LocalDate.now(), 15, 30, null);
		Set<Employees> set = new HashSet<Employees>();
		set.add(e3);
		set.add(e1);
		set.add(e2);
		set.add(e);
		
		Jobs job = new Jobs("J005", "Java freshe", 10, 20, null);
		job.setEmployees(set);
		jobImpl.save(job);

//		List<Object[]> list = jobImpl.testAll();
//		
//		List<Object[]> objects = jobImpl.findHQLJob();
//		
//		for (Object[] objects2 : objects) {
//			System.out.println((Jobs) objects2[0]);
//			
//			System.out.println((Employees) objects2[1]);
//		}
		
//		List<Jobs> list2 = jobImpl.searching(e);
//		
//		for (Jobs jobs : list2) {
//			System.out.println(jobs.toString());
//		}
	}
}
