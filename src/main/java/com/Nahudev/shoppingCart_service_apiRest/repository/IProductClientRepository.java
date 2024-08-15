package com.Nahudev.shoppingCart_service_apiRest.repository;

import com.Nahudev.shoppingCart_service_apiRest.dto.ProductClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productClient", url = "http://localhost:8081/api/products")
public interface IProductClientRepository {

    @GetMapping("/getById/{productId}")
    public ProductClientDTO getProductById(@PathVariable(name = "productId") Long id);

}
