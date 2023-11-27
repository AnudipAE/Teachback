package inventory.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import inventory.system.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public List<Customer> findAll();
}
