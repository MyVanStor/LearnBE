package javatraining.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javatraining.entities.Employees;
import javatraining.entities.Jobs;
import training.utils.HibernateUtils;

public class JobDaoImpl {
	public boolean save(Jobs job) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(job);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Jobs findById(String jobId) throws Exception {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			Jobs job = session.get(Jobs.class, jobId);
			Set<Employees> employees = job.getEmployees();
			System.out.println(job.toString());
			System.out.println(employees);
			return job;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Jobs> findAll() throws Exception {

		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query<Jobs> query = session.createNativeQuery("SELECT * FROM dbo.Jobs").addEntity(Jobs.class);

			List<Jobs> list = query.list();

			for (Jobs jobs2 : list) {
				System.out.println(jobs2.toString());
			}

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object[]> testAll() throws Exception {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query query = session
					.createNativeQuery(
							"SELECT j.*, e.* FROM dbo.Jobs j JOIN dbo.Employees e " + "ON j.job_id = e.job_id")
					.addEntity("j", Jobs.class).addJoin("e", "j.employees");

			List<Object[]> jobs = query.list();

			for (Object[] object : jobs) {
				Jobs job = (Jobs) object[0];
				System.out.println(job);

				for (Employees employee : job.getEmployees()) {
					System.out.println(employee);
				}
			}

			return jobs;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Object[]> findHQLJob() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();

			String joinQuery = "FROM Jobs j INNER JOIN j.employees";

			Query quey = session.createQuery(joinQuery);

			return quey.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

    public List<Jobs> searching(Employees employees) throws Exception {
        Session session = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            
            String hql = "FROM Jobs WHERE Employees = :startDate “ "
				 + "ORDER BY employeesId DESC";
            
            Query<Jobs> query = session.createQuery(hql);
            
            query.setParameter("startDate", employees);
            
 		   return query.list();
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
