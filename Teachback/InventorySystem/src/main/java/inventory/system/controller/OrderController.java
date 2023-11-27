package inventory.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inventory.system.entity.Order;
import inventory.system.exception.OrderNotFoundException;
import inventory.system.service.OrderService;

//OrderController.java
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	 @Autowired
	 private OrderService orderService;
	
	 @PostMapping
	 public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	     Order savedOrder = orderService.addOrder(order);
	     return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Order>> getAllOrders() {
	     List<Order> orders = orderService.getAllOrders();
	     return new ResponseEntity<>(orders, HttpStatus.OK);
	 }
	
	 @GetMapping("/{orderId}")
	 public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
	     try {
	         Order order = orderService.getOrderById(orderId);
	         return new ResponseEntity<>(order, HttpStatus.OK);
	     } catch (OrderNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @PutMapping("/{orderId}")
	 public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
	     try {
	         Order order = orderService.updateOrder(orderId, updatedOrder);
	         return new ResponseEntity<>(order, HttpStatus.OK);
	     } catch (OrderNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @DeleteMapping("/{orderId}")
	 public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
	     try {
	         orderService.deleteOrder(orderId);
	         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     } catch (OrderNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
}


