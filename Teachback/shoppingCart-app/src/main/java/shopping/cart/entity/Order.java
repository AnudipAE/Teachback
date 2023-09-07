package shopping.cart.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "status", nullable = false, length = 255)
	private String status;
	
	@Column(name ="order_date")
	private LocalDate orderDate;
	
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="products_to_orders", 
			joinColumns = { @JoinColumn(name="product_id", referencedColumnName="id")},
			inverseJoinColumns = { @JoinColumn(name = "order__id", referencedColumnName="id")}
	)
	private List<Product> products = new ArrayList<Product>() ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}

	public Order(String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		super();
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", products=" + products + ", customer=" + customer + "]";
	}
	
	
}
