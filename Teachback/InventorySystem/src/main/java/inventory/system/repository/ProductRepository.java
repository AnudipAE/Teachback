package inventory.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inventory.system.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
