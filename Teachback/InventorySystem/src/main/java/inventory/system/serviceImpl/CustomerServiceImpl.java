package inventory.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.system.entity.Customer;
import inventory.system.exception.CustomerNotFoundException;
import inventory.system.repository.CustomerRepository;
import inventory.system.service.CustomerService;

// CustomerService.java
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer updatedCustomer) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isPresent()) {
			Customer existingCustomer = optionalCustomer.get();

			// Update fields based on your requirements
			existingCustomer.setCustomerFirstName(updatedCustomer.getCustomerFirstName());
			existingCustomer.setCustomerLastName(updatedCustomer.getCustomerLastName());
			existingCustomer.setCustomerEmail(updatedCustomer.getCustomerEmail());

			// Update relationships if needed

			return customerRepository.save(existingCustomer);
		} else {
			throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
		}
	}

	@Override
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
	}

	@Override
	public void deleteCustomer(Long customerId) throws CustomerNotFoundException {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
		} else {
			throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
		}
	}
}
