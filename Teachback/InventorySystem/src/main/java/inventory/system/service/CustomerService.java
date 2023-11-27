package inventory.system.service;

import java.util.List;

import inventory.system.entity.Customer;
import inventory.system.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException;
	
	public Customer addCustomer(Customer customer);
	
	public void deleteCustomer(Long customerId) throws CustomerNotFoundException;
	
	public Customer updateCustomer(Long customerId, Customer updatedCustomer) throws CustomerNotFoundException;
	
}
