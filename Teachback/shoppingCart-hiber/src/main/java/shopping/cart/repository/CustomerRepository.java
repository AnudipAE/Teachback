package shopping.cart.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import shopping.cart.entity.Customer;
import shopping.cart.entity.Order;
import shopping.cart.entity.Product;

public class CustomerRepository {
private final EntityManager em;
	
	public CustomerRepository(final EntityManager em) {
		this.em=em;
	}
	public Customer save(final Customer customer) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(customer);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}
	
	//Look for objects in the database of type Customer by id
	public Optional<Customer> findById(long id) {
		Customer customer = em.find(Customer.class, id);
						
		if(customer != null)
			return Optional.of(customer);
		else
			return Optional.empty();
	}

	//Searching Customer record by tier
	public  Optional<Customer> findByTier(Integer tier) {
		Customer customer = em.createQuery("select c from Customer c where c.tier = :tier", Customer.class)
					.setParameter("tier", tier).getSingleResult();
						
		if(customer != null)
			return Optional.of(customer);
		else
			return Optional.empty();
	}
	//Returning all Customer records	
	public List<Customer> findAll(){
				
		List<Customer> customers = em.createQuery("from Customer ", Customer.class).getResultList();
							
		return customers;
	}
	
	//Removing one Customer record from the database.
	public void remove(final Customer customer) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(customer);
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
