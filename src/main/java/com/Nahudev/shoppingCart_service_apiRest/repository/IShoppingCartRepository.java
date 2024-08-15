package com.Nahudev.shoppingCart_service_apiRest.repository;

import com.Nahudev.shoppingCart_service_apiRest.model.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
}
