package inventory.system.service;

import java.util.List;

import inventory.system.entity.Order;
import inventory.system.exception.OrderNotFoundException;

public interface OrderService {

	public List<Order> getAllOrders();
	
	public Order getOrderById(Long id) throws OrderNotFoundException;
	
	public Order addOrder(Order order);
	
	public void deleteOrder(Long orderID) throws OrderNotFoundException;
	
	public Order updateOrder(Long orderId, Order updatedOrder) throws OrderNotFoundException;
	
}
