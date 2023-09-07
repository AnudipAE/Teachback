package shopping.cart.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import shopping.cart.entity.Customer;
import shopping.cart.entity.Order;
import shopping.cart.entity.Product;
import shopping.cart.repository.CustomerRepository;
import shopping.cart.repository.OrderRepository;
import shopping.cart.repository.ProductRepository;

public class App {
  public static void main(String[] args) {
	  System.out.println("______________________SHOPPING CART_______________________");
	  EntityManagerFactory factory = null;
		EntityManager em = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("HibernateDemo");
			em = factory.createEntityManager();
			//Operations of Product class and ProductRepository class 
			ProductRepository prep = new ProductRepository(em);
			
			Product p1 = new Product("C++", "Books", 100, null);
			Product p2 = new Product("Milk", "Babys", 199, null);
			Product p3 = new Product("Gucci", "Shirts", 2095, null);
			Product p4 = new Product("WildStone", "Perfume", 150, null);
			Product p5 = new Product("Advanced Java", "Books", 2000, null);
			Product p6 = new Product("Pampers", "Baby", 90, null);
			
			List<Product> products = new ArrayList<Product> ();
			
			products.add(p1);
			products.add(p2);
			products.add(p3);
			products.add(p4);
			
			//Saving objects of type Product to the database
			for(Product p:products) {
				prep.save(p);;
			}
			
			List<Product> products1 = new ArrayList<Product>();
			products1.add(p1);
			products1.add(p2);
			
			List<Product> products2 = new ArrayList<Product>();
			products2.add(p3);
			products2.add(p4);
			
			List<Product> products3 = new ArrayList<Product>();
			products2.add(p5);
			products2.add(p6);
			
			//Saving objects of type Customer to the database
			Customer c1 = new Customer("Kiara", 1, null);
			Customer c2 = new Customer("Mrs. Ahuja", 2,  null);
			Customer c3 = new Customer("Dimple", 3,  null);
			
			CustomerRepository crep = new CustomerRepository(em);
			crep.save(c1);
			crep.save(c2);
			crep.save(c3);
			
			//Saving objects of type Order to the database
			Order o1 = new Order("Delivered", null, null, products1, c1);
			Order o2 = new Order("Shipped", null, null,  products2,c2);
			Order o3 = new Order("Not Shipped", null, null,  products3,c3);
			
			OrderRepository orep = new OrderRepository(em);
			orep.save(o1);
			orep.save(o2);
			orep.save(o3);
			
			System.out.println("____ Operations on Product Entity ____");
			//Look for objects in the database of type Product by id
			Optional<Product> productById = prep.findById(1L);
			System.out.println("Product : " + productById);
			System.out.println("******************************************************************");
			
			//Obtain a list of products belongs to category “Books” with price > 100
			List<Product> productsByCategoryAndPrice = prep.findAllInCategoryAndPrice();
			System.out.println("Product : " + productsByCategoryAndPrice);
			System.out.println("******************************************************************");
			
			//Obtain a list of order with products belong to category “Baby”
			List<Product> productByCategory = prep.findAllInCategory();
			System.out.println("Product : " + productByCategory);
			System.out.println("******************************************************************");
			
			//Obtain a list of order with products having name "WildStone"
			Optional<Product> productByName = prep.findByName("WildStone");
			System.out.println("Product : " + productByName);
			System.out.println("******************************************************************");
			
			//Obtain all the products records
			List<Product> allProducts = prep.findAll();
			System.out.println("Product : " + allProducts);
			System.out.println("******************************************************************");
			
			//Removing one record from Product
			System.out.println("Removing One Product details :");
			prep.remove(p2);
			System.out.println("*****************************************************************");
			
			System.out.println("____ Operations on Customer Entity ____");
			//Look for objects in the database of type Customer by id
			Optional<Customer> customerById = crep.findById(1L);
			System.out.println("Customer : " + customerById);
			System.out.println("******************************************************************");
			
			//Obtain Customer record having tier 1
			Optional<Customer> customerByTier = crep.findByTier(1);
			System.out.println("Customer : " + customerByTier);
			System.out.println("******************************************************************");
			
			//Obtain all the Customer records
			List<Customer> allCustomers = crep.findAll();
			System.out.println("Customer : " + allCustomers);
			System.out.println("******************************************************************");
			
			//Removing one record from Customer
			System.out.println("Removing One Customer details :");
			crep.remove(c2);
			System.out.println("*****************************************************************");

			System.out.println("____ Operations on Order Entity ____");
			//Look for objects in the database of type Order by id
			Optional<Order> orderById = orep.findById(1L);
			System.out.println("Order : " + orderById);
			System.out.println("******************************************************************");
			
			//Obtain a list of order with Order having name "Shipped"
			Optional<Order> orderByStatus = orep.findByStatus("Shipped");
			System.out.println("Order : " + orderByStatus);
			System.out.println("******************************************************************");
			
			//Obtain all the Order records
			List<Order> allOrders = orep.findAll();
			System.out.println("Order : " + allOrders);
			System.out.println("******************************************************************");
			
			//Removing one record from Customer
			System.out.println("Removing One Order details :");
			orep.remove(o2);
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
