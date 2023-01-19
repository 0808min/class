package com.app.shop.domain.carts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CartItemDTO {

    @NotNull(message = "상품 아이디는 필수 입력 값입니다.")
    private Long itemId;

    @Min(value = 1, message = "최소 1개 이상 담아주세요")
    private int count;

    @Builder
    public CartItemDTO(Long itemId, int count) {
        this.itemId = itemId;
        this.count = count;
    }

}
