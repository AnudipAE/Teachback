package shopping.cart.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import shopping.cart.entity.Product;

public class ProductRepository {
private final EntityManager em;
	
	public ProductRepository(final EntityManager em) {
		this.em=em;
	}
	public Product save(final Product product) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(product);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return product;
	}
	
	//Look for objects in the database of type Product by id
	public  Optional<Product> findById(long id) {
		Product product = em.find(Product.class, id);
				
		if(product != null)
			return Optional.of(product);
		else
			return Optional.empty();
	}
	
	//Obtain a list of products belongs to category “Books” with price > 100
	public List<Product> findAllInCategoryAndPrice(){
		List<Product> products = em.createQuery("select p from Product p where p.category = 'Books' and p.price > 100", Product.class)
						.getResultList();
	
		return products;
	}
	
	//Obtain a list of order with products belong to category “Baby”
	public List<Product> findAllInCategory(){
		List<Product> products = em.createQuery("select p from Product p where p.category = 'Books'", Product.class)
						.getResultList();
	
		return products;
	}
	
	//Searching Product record by title
	public  Optional<Product> findByName(String name) {
		Product product = em.createQuery("select p from Product p where p.name = :name", Product.class)
					.setParameter("name", name).getSingleResult();
					
		if(product != null)
			return Optional.of(product);
		else
			return Optional.empty();
	}
	
	//Returning all Product records	
	public List<Product> findAll(){
				
		List<Product> products = em.createQuery("from Product ", Product.class).getResultList();
							
		return products;
	}
	
	//Removing one Product record from the database.
	public void remove(final Product product) {
		EntityTransaction tx = null;
			
		try {
			tx = em.getTransaction();
				
			if(!tx.isActive()) {
				tx.begin();
			}
				
			em.remove(product);
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
