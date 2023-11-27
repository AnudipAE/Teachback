package inventory.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.system.entity.Product;
import inventory.system.exception.ProductNotFoundException;
import inventory.system.repository.ProductRepository;
import inventory.system.service.ProductService;

//ProductService.java
@Service
public class ProductServiceImpl implements ProductService {
	 @Autowired
	 private ProductRepository productRepository;
	
	 @Override
	 public Product addProduct(Product product) {
	     return productRepository.save(product);
	 }
	
	 @Override
	 public List<Product> getAllProducts() {
	     return productRepository.findAll();
	 }
	
		 @Override
		 public Product updateProduct(Long productId, Product updatedProduct) throws ProductNotFoundException {
			    Optional<Product> optionalProduct = productRepository.findById(productId);
		
		     if (optionalProduct.isPresent()) {
		         Product existingProduct = optionalProduct.get();
		
		         // Update fields based on your requirements
		         existingProduct.setProductName(updatedProduct.getProductName());
		         existingProduct.setProductCategory(updatedProduct.getProductCategory());
		         existingProduct.setProductPrice(updatedProduct.getProductPrice());
		
		         // Update relationships if needed
		
		         return productRepository.save(existingProduct);
		     } else {
		         throw new ProductNotFoundException("Product not found with ID: " + productId);
		     }
		 }
		
		 @Override
		 public Product getProductById(Long productId) throws ProductNotFoundException {
		     return productRepository.findById(productId)
		             .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));
		 }
		
		 @Override
		 public void deleteProduct(Long productId) throws ProductNotFoundException {
		     if (productRepository.existsById(productId)) {
		         productRepository.deleteById(productId);
		     } else {
		         throw new ProductNotFoundException("Product not found with ID: " + productId);
		     }
		 }

}

