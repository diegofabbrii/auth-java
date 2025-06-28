package com.diegofabbrii.authentication.domain.dtos.product;

import java.math.BigDecimal;

public record ProductResponseDTO(String id, String name, String imgUrl, BigDecimal price) {
}
