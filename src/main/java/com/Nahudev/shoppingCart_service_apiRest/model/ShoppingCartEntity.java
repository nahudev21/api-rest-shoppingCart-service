package com.Nahudev.shoppingCart_service_apiRest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carrito_productos")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo_usuario")
    private String nameCompleteUser;

    @Column(name = "usuarioId")
    private Long userId;

    @Column(name = "nombre_producto")
    private String nameProduct;

    @Column(name = "cantidad")
    private int amount;

    @Column(name = "precio")
    private Double price;

}
