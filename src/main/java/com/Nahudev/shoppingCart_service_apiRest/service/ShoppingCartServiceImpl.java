package com.Nahudev.shoppingCart_service_apiRest.service;

import com.Nahudev.shoppingCart_service_apiRest.dto.ProductClientDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.ShoppingCartFromUserDTO;
import com.Nahudev.shoppingCart_service_apiRest.dto.UserClientDTO;
import com.Nahudev.shoppingCart_service_apiRest.exceptions.ResourceNotFoundException;
import com.Nahudev.shoppingCart_service_apiRest.model.ShoppingCartEntity;
import com.Nahudev.shoppingCart_service_apiRest.repository.IProductClientRepository;
import com.Nahudev.shoppingCart_service_apiRest.repository.IShoppingCartRepository;
import com.Nahudev.shoppingCart_service_apiRest.repository.IUserClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ShoppingCartDTO getProductFromShoppingCart(Long id) {

        ShoppingCartEntity shoppingCartFound = shoppingCartRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Producto", "id", id));


        return mapOutShoppingCartDTO(shoppingCartFound);
    }

    @Override
    public ShoppingCartFromUserDTO getAllProductsFromShoppingCart(Long userId) {

        List<ShoppingCartEntity> shoppingCartEntities = shoppingCartRepository.getShoppingCartFromUser(userId);
        List<ShoppingCartDTO> productsFromShoppingCart = shoppingCartEntities.stream().map(this::mapOutShoppingCartDTO).collect(Collectors.toList());

        ShoppingCartFromUserDTO shoppingCartFromUserDTO = new ShoppingCartFromUserDTO();
        shoppingCartFromUserDTO.setAddedProducts(productsFromShoppingCart);

        return shoppingCartFromUserDTO;
    }

    @Override
    public void deleteProductFromShoppingCart(Long id) {

        ShoppingCartEntity shoppingCartFound = shoppingCartRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Producto", "id", id));

        shoppingCartRepository.delete(shoppingCartFound);
    }


    public ShoppingCartDTO mapOutShoppingCartDTO(ShoppingCartEntity shoppingCartEntity) {
        return modelMapper.map(shoppingCartEntity, ShoppingCartDTO.class);
    }

    public ShoppingCartEntity mapOutShoppingCartEntity(ShoppingCartDTO shoppingCartDTO) {
        return modelMapper.map(shoppingCartDTO, ShoppingCartEntity.class);
    }

}
