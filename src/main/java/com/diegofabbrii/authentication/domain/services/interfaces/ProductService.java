package com.diegofabbrii.authentication.domain.services.interfaces;

import com.diegofabbrii.authentication.domain.dtos.product.CreateProductDTO;
import com.diegofabbrii.authentication.domain.dtos.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
	
	List<ProductResponseDTO> listProduct();
	ProductResponseDTO createProduct(CreateProductDTO productDto);
	
}
