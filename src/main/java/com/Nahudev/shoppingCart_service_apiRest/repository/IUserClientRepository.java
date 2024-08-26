package com.Nahudev.shoppingCart_service_apiRest.repository;

import com.Nahudev.shoppingCart_service_apiRest.dto.UserClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userService")
public interface IUserClientRepository {

    public String URL = "/users";

    @GetMapping(URL + "/getUser/{userId}")
    public UserClientDTO getUserById(@PathVariable(name = "userId") Long id);

}
