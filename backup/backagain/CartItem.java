package com.spirngauth.authentication_spring.models;


import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Users.class)
    @JoinColumn(name = "id")
    @Column(name="session_id")
    private Long sessionId;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Product.class)
    @JoinColumn(name = "id")
    @Column(name = "product_id")
    private Long productId;




}
