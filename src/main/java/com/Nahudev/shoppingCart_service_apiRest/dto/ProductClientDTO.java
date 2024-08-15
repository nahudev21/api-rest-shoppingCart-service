package com.Nahudev.shoppingCart_service_apiRest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductClientDTO {

    private Long id;

    private String name;

    private String description;

    private String image;

    private Double price;

    private int stock;

    private String category;

}
