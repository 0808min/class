package com.app.shop.entity.cart;

import com.app.shop.entity.cart.Cart;
import com.app.shop.entity.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table(name = "cart_item")
@Entity
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_item_id")
    private Item item;

    private int count;


    @Builder
    public CartItem(Cart cart, Item item, int count) {
        this.cart = cart;
        this.item = item;
        this.count = count;

    }

}
