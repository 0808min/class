package com.app.shop.domain.items;

import com.app.shop.entity.item.ItemSellStatus;
import lombok.Data;

@Data
public class ItemSearchDTO {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";


}
