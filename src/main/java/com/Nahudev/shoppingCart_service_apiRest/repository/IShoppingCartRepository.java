package com.Nahudev.shoppingCart_service_apiRest.repository;

import com.Nahudev.shoppingCart_service_apiRest.model.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {

    @Query("SELECT s FROM ShoppingCartEntity s WHERE s.userId = %:userId%")
    public List<ShoppingCartEntity> getShoppingCartFromUser(@Param("userId") Long userId);

}
