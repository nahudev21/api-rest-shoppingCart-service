package com.Nahudev.shoppingCart_service_apiRest.controller;

import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartDTO;
import com.Nahudev.shoppingCart_service_apiRest.repository.IProductClientRepository;
import com.Nahudev.shoppingCart_service_apiRest.repository.IUserClientRepository;
import com.Nahudev.shoppingCart_service_apiRest.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @PostMapping("/addCart/{userId}/{productId}")
    public ResponseEntity<ShoppingCartDTO> createShoppingCart(@PathVariable(name = "userId", required = true) Long userId,
                                                              @PathVariable(name = "productId", required = true) Long productId,
                                                              @RequestParam(value = "amount", required = true) int amount) {

        return new ResponseEntity<>(shoppingCartService.createShoppingCart(userId, productId, amount), HttpStatus.CREATED);
    }


}
