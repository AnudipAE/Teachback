package hibernate.student.management;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class StudentApp {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("HibernateDemo");
			EntityManager em = factory.createEntityManager();
			
			System.out.println("_______Welcome to Student Management System________");
			
			//Adding Student records to the database
			Student student1 = new Student("John", "oak", "john.oak@gmail.com" );
			Student student2 = new Student("Khrist", "Kandu", "khrist.kandu@gmail.com");
			Student student3 = new Student("Eliza", "Khristina", "eliza.khrist@gmail.com");
			
			StudentDAO studentDao = new StudentDAO(em);
			studentDao.save(student1);
			studentDao.save(student2);
			studentDao.save(student3);

			//Searching for Student record by id
			System.out.println("Student detail with given id :");
			System.out.println();
			
			Optional<Student> studentById = studentDao.findById(1);
			System.out.println("Student : " + studentById);
			System.out.println("*****************************************************************");
			
			//returning all Student records
			System.out.println("All Student records :");
			System.out.println();
			
			List<Student> allStudents = studentDao.findAll();
			System.out.println("Movies : " + allStudents);
			System.out.println("*****************************************************************");
			
			//removing one Student record from the database.
			System.out.println("Removing One Student :");
			System.out.println();
			
			studentDao.remove(student3);
			System.out.println("*****************************************************************");
			
			//removing all Student records from the database
			System.out.println("Removing All Student :");
			System.out.println();
			
			studentDao.remove();;
			System.out.println("*****************************************************************");
			
			
		}
		
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Exception Hibernate");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
		finally {
			 if(factory!= null) {
				 factory.close();
				 }
		}

	}

}
