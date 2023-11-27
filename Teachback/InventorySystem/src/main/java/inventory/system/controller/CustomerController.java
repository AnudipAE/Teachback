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

import inventory.system.entity.Customer;
import inventory.system.exception.CustomerNotFoundException;
import inventory.system.service.CustomerService;

//CustomerController.java
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	 @Autowired
	 private CustomerService customerService;
	
	 @PostMapping
	 public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	     Customer savedCustomer = customerService.addCustomer(customer);
	     return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Customer>> getAllCustomers() {
	     List<Customer> customers = customerService.getAllCustomers();
	     return new ResponseEntity<>(customers, HttpStatus.OK);
	 }
	
	 @GetMapping("/{customerId}")
	 public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
	     try {
	         Customer customer = customerService.getCustomerById(customerId);
	         return new ResponseEntity<>(customer, HttpStatus.OK);
	     } catch (CustomerNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @PutMapping("/{customerId}")
	 public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
	     try {
	         Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
	         return new ResponseEntity<>(customer, HttpStatus.OK);
	     } catch (CustomerNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @DeleteMapping("/{customerId}")
	 public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
	     try {
	         customerService.deleteCustomer(customerId);
	         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     } catch (CustomerNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
}

