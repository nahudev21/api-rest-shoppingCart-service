package com.Nahudev.shoppingCart_service_apiRest.service;

import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartFromUserDTO;

public interface IShoppingCartService {

    public ShoppingCartDTO createShoppingCart(Long userId, Long productId, int amount);

    public ShoppingCartDTO getProductFromShoppingCart(Long id);

    public ShoppingCartFromUserDTO getAllProductsFromShoppingCart(Long userId);

    public void deleteProductFromShoppingCart(Long id);

    public void deleteShoppingCart(Long userId);

}
