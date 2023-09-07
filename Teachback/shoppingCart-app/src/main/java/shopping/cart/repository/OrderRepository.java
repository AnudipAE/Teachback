package shopping.cart.repository;

import shopping.cart.entity.Order;
import shopping.cart.entity.Product;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class OrderRepository {
private final EntityManager em;
	
	public OrderRepository(final EntityManager em) {
		this.em=em;
	}
	public Order save(final Order order) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(order);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return order;
	}
	
	//Look for objects in the database of type Order by id
	public  Optional<Order> findById(long id) {
		Order order = em.find(Order.class, id);
					
		if(order != null)
			return Optional.of(order);
		else
			return Optional.empty();
	}
	
	//Searching Order record by status
	public  Optional<Order> findByStatus(String status) {
		Order order = em.createQuery("select o from Order o where o.status = :status", Order.class)
					.setParameter("status", status).getSingleResult();
						
		if(order != null)
			return Optional.of(order);
		else
			return Optional.empty();
	}
	
	//Returning all Order records	
	public List<Order> findAll(){
				
		List<Order> orders = em.createQuery("from Order ", Order.class).getResultList();
							
		return orders;
	}

	//Removing one Order record from the database.
	public void remove(final Order order) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(order);
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
