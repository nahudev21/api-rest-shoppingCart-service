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
public class ShoppingCartFromUserDTO {

    private List<ShoppingCartDTO> addedProducts;

}
