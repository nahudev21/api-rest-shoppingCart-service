package com.Nahudev.shoppingCart_service_apiRest.repository;

import com.Nahudev.shoppingCart_service_apiRest.dto.ProductClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productsService")
public interface IProductClientRepository {

    public String URL = "/api/products";

    @GetMapping(URL + "/getById/{productId}")
    public ProductClientDTO getProductById(@PathVariable(name = "productId") Long id);

    @PutMapping(URL + "/reduceStock/{productId}/{amount}")
    public void reduceStock(@PathVariable(name = "productId") Long id,
                            @PathVariable(name = "amount") int amount);

}
