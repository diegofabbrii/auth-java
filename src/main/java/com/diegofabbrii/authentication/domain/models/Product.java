package com.diegofabbrii.authentication.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "tb_products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String name;
	
	@Column(length = 500)
	private String imgUrl;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal price;
	
}
