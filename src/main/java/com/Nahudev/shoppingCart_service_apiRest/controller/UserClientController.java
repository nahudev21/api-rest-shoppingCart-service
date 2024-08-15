package com.Nahudev.shoppingCart_service_apiRest.controller;

import com.Nahudev.shoppingCart_service_apiRest.repository.IProductClientRepository;
import com.Nahudev.shoppingCart_service_apiRest.repository.IUserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientController {

    @Autowired
    private IUserClientRepository userClient;

    @Autowired
    private IProductClientRepository productClient;

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<?> getUser(@PathVariable(name = "userId") Long id) {
        return new ResponseEntity<>(userClient.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "productId") Long id) {
        return new ResponseEntity<>(productClient.getProductById(id), HttpStatus.OK);
    }

}
