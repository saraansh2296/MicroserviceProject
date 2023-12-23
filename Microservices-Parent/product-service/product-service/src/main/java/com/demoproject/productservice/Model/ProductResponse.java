package com.demoproject.productservice.Model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Data
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
}
