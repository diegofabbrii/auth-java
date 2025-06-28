package com.diegofabbrii.authentication.domain.dtos.product;

import java.math.BigDecimal;

public record CreateProductDTO(String name, String imgUrl, BigDecimal price) {}
