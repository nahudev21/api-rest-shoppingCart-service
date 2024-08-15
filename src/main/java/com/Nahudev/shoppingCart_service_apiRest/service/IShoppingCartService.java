package com.Nahudev.shoppingCart_service_apiRest.service;

import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartFromUserDTO;

import java.util.List;

public interface IShoppingCartService {

    public ShoppingCartDTO createShoppingCart(Long userId, Long productId, int amount);

    public ShoppingCartDTO getProductFromShoppingCart(Long id);

    public ShoppingCartFromUserDTO getAllProductsFromShoppingCart(Long userId);

    public void deleteProductFromShoppingCart(Long id);

}
