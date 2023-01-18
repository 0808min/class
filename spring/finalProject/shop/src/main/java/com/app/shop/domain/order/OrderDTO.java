package com.app.shop.domain.order;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrderDTO {

    @NotNull(message = "상품 아이디는 필수 입력 값입니다.")
    private Long itemId;

    @Min(value = 1, message = "최소 주문 수량은 1개 입니다.")
    @Max(value = 9999, message = "최대 주문 수량은 9999개 입니다.")
    private int count;

    @Builder
    public OrderDTO(Long itemId, int count) {
        this.itemId = itemId;
        this.count = count;
    }

}
