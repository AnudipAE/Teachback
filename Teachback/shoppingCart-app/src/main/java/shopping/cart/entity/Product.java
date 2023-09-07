package shopping.cart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "category", nullable = false, length = 255)
	private String category;
	
	@Column(name = "price")
	private double price;
	
	@ManyToMany(mappedBy = "products")
	 private List<Order> orders= new ArrayList<Order>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String name, String category, double price, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.orders = orders;
	}

	public Product(String name, String category, double price, List<Order> orders) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", orders="
				+ orders + "]";
	}
	
	
}
