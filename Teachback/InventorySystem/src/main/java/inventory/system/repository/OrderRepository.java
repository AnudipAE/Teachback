package inventory.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inventory.system.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
