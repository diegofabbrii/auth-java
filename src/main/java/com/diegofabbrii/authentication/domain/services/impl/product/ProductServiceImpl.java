package com.diegofabbrii.authentication.domain.services.impl.product;

import com.diegofabbrii.authentication.domain.dtos.product.CreateProductDTO;
import com.diegofabbrii.authentication.domain.dtos.product.ProductResponseDTO;
import com.diegofabbrii.authentication.domain.exceptions.product.ProductAlreadyExists;
import com.diegofabbrii.authentication.domain.models.Product;
import com.diegofabbrii.authentication.domain.services.interfaces.ProductService;
import com.diegofabbrii.authentication.infra.data.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository _productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		_productRepository = productRepository;
	}
	
	@Override
	public List<ProductResponseDTO> listProduct() {
		return _productRepository.findAll()
			.stream()
			.map(product -> new ProductResponseDTO(
				product.getId(),
				product.getName(),
				product.getImgUrl(),
				product.getPrice()
			)).toList();
	}
	
	@Override
	public ProductResponseDTO createProduct(CreateProductDTO productDto) {
		Optional<Product> product = _productRepository.findByName(productDto.name());
		
		if (product.isPresent()) throw new ProductAlreadyExists();
		
		Product newProduct = new Product();
		
		newProduct.setName(productDto.name());
		newProduct.setImgUrl(productDto.imgUrl());
		newProduct.setPrice(productDto.price());
		
		Product createdProduct = _productRepository.save(newProduct);
		
		return new ProductResponseDTO(
			createdProduct.getId(),
			createdProduct.getName(),
			createdProduct.getImgUrl(),
			createdProduct.getPrice()
		);
	}
	
}
