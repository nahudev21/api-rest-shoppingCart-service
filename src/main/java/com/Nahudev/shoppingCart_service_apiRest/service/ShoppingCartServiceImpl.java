package com.Nahudev.shoppingCart_service_apiRest.service;

import com.Nahudev.shoppingCart_service_apiRest.dto.ProductClientDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.UserClientDTO;
import com.Nahudev.shoppingCart_service_apiRest.model.ShoppingCartEntity;
import com.Nahudev.shoppingCart_service_apiRest.repository.IProductClientRepository;
import com.Nahudev.shoppingCart_service_apiRest.repository.IShoppingCartRepository;
import com.Nahudev.shoppingCart_service_apiRest.repository.IUserClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService{

    @Autowired
    private IShoppingCartRepository shoppingCartRepository;

    @Autowired
    private IUserClientRepository userClient;

    @Autowired
    private IProductClientRepository productClient;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShoppingCartDTO createShoppingCart(Long userId, Long productId,
                                              int amount) {

        UserClientDTO userClientDTO = userClient.getUserById(userId);
        ProductClientDTO productClientDTO = productClient.getProductById(productId);
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();

        shoppingCartEntity.setNameCompleteUser(userClientDTO.getName() + " " + userClientDTO.getLastName());
        shoppingCartEntity.setUserId(userClientDTO.getId());
        shoppingCartEntity.setNameProduct(productClientDTO.getName());
        shoppingCartEntity.setAmount(amount);
        shoppingCartEntity.setPrice(productClientDTO.getPrice());
        shoppingCartRepository.save(shoppingCartEntity);

        int totalAmount = productClientDTO.getStock() - amount;
        productClient.reduceStock(productId, totalAmount);

        return mapOutShoppingCartDTO(shoppingCartEntity);
    }

    public ShoppingCartDTO mapOutShoppingCartDTO(ShoppingCartEntity shoppingCartEntity) {
        return modelMapper.map(shoppingCartEntity, ShoppingCartDTO.class);
    }

    public ShoppingCartEntity mapOutShoppingCartEntity(ShoppingCartDTO shoppingCartDTO) {
        return modelMapper.map(shoppingCartDTO, ShoppingCartEntity.class);
    }

}
