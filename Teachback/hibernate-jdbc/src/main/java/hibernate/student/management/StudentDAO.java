package hibernate.student.management;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentDAO {
	private EntityManager em;
	
	public StudentDAO(final EntityManager em) {
		this.em = em;
	}
	
	//adding Student records to the database
	public  void save(final Student student) {
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(student);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	//Searching for Student record by id
	public  Optional<Student> findById(int id) {
		Student a = em.find(Student.class, id);
						
		if(a != null)
			return Optional.of(a);
		else
			return Optional.empty();
	}
	
	//returning all Student records	
	public List<Student> findAll(){
			
		List<Student> students = em.createQuery("from Student ", Student.class).getResultList();
						
		return students;
	}
	
	//removing one Student record from the database.
	public void remove(final Student student) {
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.remove(student);
			tx.commit();
			
		} 
		catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	//removing all Student records from the database
	public void remove() {
		
		List<Student> students = findAll();
		
		for(Student m : students) {
			EntityTransaction tx = null;
			
			try {
				tx = em.getTransaction();
				
				if(!tx.isActive()) {
					tx.begin();
				}
				
				em.remove(m);
				tx.commit();
				
			}
			catch (Exception e) {

				if(tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}	
	}

}
