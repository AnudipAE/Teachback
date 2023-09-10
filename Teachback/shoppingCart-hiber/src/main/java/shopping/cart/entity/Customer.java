package shopping.cart.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "tier")
	private Integer tier;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="customer_id")
	private List<Order> orders ;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long id, String name, Integer tier, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
		this.orders = orders;
	}

	public Customer(String name, Integer tier, List<Order> orders) {
		super();
		this.name = name;
		this.tier = tier;
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

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + ", orders=" + orders + "]";
	}
	
	
}
