package inventory.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.system.entity.Order;
import inventory.system.exception.OrderNotFoundException;
import inventory.system.repository.OrderRepository;
import inventory.system.service.OrderService;

//OrderService.java
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	 private OrderRepository orderRepository;
	
	@Override
	 public Order addOrder(Order order) {
	     return orderRepository.save(order);
	 }
	
	@Override
	 public List<Order> getAllOrders() {
	     return orderRepository.findAll();
	 }
	
	 @Override
	 public Order updateOrder(Long orderId, Order updatedOrder) throws OrderNotFoundException {
	    Optional<Order> optionalOrder = orderRepository.findById(orderId);

	    if (optionalOrder.isPresent()) {
	       Order existingOrder = optionalOrder.get();

	      // Update fields based on your requirements
	      existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
	      existingOrder.setOrderDate(updatedOrder.getOrderDate());
	      existingOrder.setDeliveryDate(updatedOrder.getDeliveryDate());

	     // You may also need to update relationships (e.g., products, customer) based on your use case

	     return orderRepository.save(existingOrder);
	   } else {
	     throw new OrderNotFoundException("Order not found with ID: " + orderId);
	   }
	 }
	 
	 @Override
	 public Order getOrderById(Long orderId) throws OrderNotFoundException {
		 return orderRepository.findById(orderId)
	        .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + orderId));
	 }

	 @Override
	 public void deleteOrder(Long orderId) throws OrderNotFoundException {
		 if (orderRepository.existsById(orderId)) {
	       orderRepository.deleteById(orderId);
	     } else {
	       throw new OrderNotFoundException("Order not found with ID: " + orderId);
	    }
	 }
}

