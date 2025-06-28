package com.diegofabbrii.authentication.application.controllers.product;

import com.diegofabbrii.authentication.domain.dtos.product.CreateProductDTO;
import com.diegofabbrii.authentication.domain.dtos.product.ProductResponseDTO;
import com.diegofabbrii.authentication.domain.services.interfaces.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private final ProductService _productService;
	
	public ProductController(ProductService productService) {
		_productService = productService;
	}
	
	@GetMapping("list-product")
	public ResponseEntity<List<ProductResponseDTO>> listProduct() {
		List<ProductResponseDTO> response = _productService.listProduct();
		
		return ResponseEntity
			.ok()
			.body(response);
	}
	
	@PostMapping("create-product")
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductDTO body) {
		ProductResponseDTO response = _productService.createProduct(body);
		
		return ResponseEntity
			.ok()
			.body(response);
	}
	
}
