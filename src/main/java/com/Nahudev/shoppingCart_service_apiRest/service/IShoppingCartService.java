package com.Nahudev.shoppingCart_service_apiRest.service;

import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartDTO;

public interface IShoppingCartService {

    public ShoppingCartDTO createShoppingCart(Long userId, Long productId, int amount);

    public ShoppingCartDTO getProductFromShoppingCart(Long id);

}
