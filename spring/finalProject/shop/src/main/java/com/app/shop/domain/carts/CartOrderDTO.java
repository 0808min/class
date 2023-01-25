package com.app.shop.domain.carts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartOrderDTO {

    private Long cartItemId;

    private List<CartOrderDTO> cartOrderDTOList;
}
