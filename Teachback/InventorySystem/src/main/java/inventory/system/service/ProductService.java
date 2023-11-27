package inventory.system.service;

import java.util.List;

import inventory.system.entity.Product;
import inventory.system.exception.ProductNotFoundException;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductById(Long id) throws ProductNotFoundException;
	
	public Product addProduct(Product product);
	
	public void deleteProduct(Long productID) throws ProductNotFoundException;
	
	public Product updateProduct(Long productId, Product updatedProduct) throws ProductNotFoundException;
	
}
