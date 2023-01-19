package com.app.shop.domain.carts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartDetailDTO {

    private Long cartItemId;
    private String itemName;
    private int price;
    private int count;
    private String imgUrl;

    @Builder
    public CartDetailDTO(Long cartItemId, String itemName, int price, int count, String imgUrl) {
        this.cartItemId = cartItemId;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
        this.imgUrl = imgUrl;

    }

}
