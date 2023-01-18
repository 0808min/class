package com.app.shop.domain.items;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainItemDTO {

    private Long id;

    private String itemName;

    private String itemDetail;

    private String  itemUrl;

    private Integer price;

    @QueryProjection
    public MainItemDTO(Long id, String itemName, String itemDetail, String itemUrl, Integer price) {
        this.id = id;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemUrl = itemUrl;
        this.price = price;
    }


}
