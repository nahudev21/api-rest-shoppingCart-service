package com.Nahudev.shoppingCart_service_apiRest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

    private Long id;

    private String nameCompleteUser;

    private Long userId;

    private String nameProduct;

    private int amount;

    private Double price;

}
