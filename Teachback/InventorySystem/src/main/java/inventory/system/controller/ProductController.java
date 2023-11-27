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

import inventory.system.entity.Product;
import inventory.system.exception.ProductNotFoundException;
import inventory.system.service.ProductService;

//ProductController.java
@RestController
@RequestMapping("/api/products")
public class ProductController {
	 @Autowired
	 private ProductService productService;
	
	 @PostMapping
	 public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	     Product savedProduct = productService.addProduct(product);
	     return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	 }
	
	 @GetMapping
	 public ResponseEntity<List<Product>> getAllProducts() {
	     List<Product> products = productService.getAllProducts();
	     return new ResponseEntity<>(products, HttpStatus.OK);
	 }
	
	 @GetMapping("/{productId}")
	 public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
	     try {
	         Product product = productService.getProductById(productId);
	         return new ResponseEntity<>(product, HttpStatus.OK);
	     } catch (ProductNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @PutMapping("/{productId}")
	 public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
	     try {
	         Product product = productService.updateProduct(productId, updatedProduct);
	         return new ResponseEntity<>(product, HttpStatus.OK);
	     } catch (ProductNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	
	 @DeleteMapping("/{productId}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
	     try {
	         productService.deleteProduct(productId);
	         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     } catch (ProductNotFoundException e) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
}
