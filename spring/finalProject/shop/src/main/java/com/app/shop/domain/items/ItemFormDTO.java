package com.app.shop.domain.items;

import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemSellStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ItemFormDTO {

    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemName;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "상세 내용은 필수 입력 값입니다.")
    private String itemDetail;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stockNumber;

    private ItemSellStatus itemSellStatus;

    private List<ItemImgDTO> itemImgDTOList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    @Builder
    public ItemFormDTO(String itemName, Integer price, String itemDetail, Integer stockNumber,ItemSellStatus itemSellStatus) {
        this.itemName = itemName;
        this.price = price;
        this.itemDetail = itemDetail;
        this.stockNumber = stockNumber;
        this.itemSellStatus = itemSellStatus;
    }

    public Item toEntity(ItemFormDTO dto) {
        Item entity = Item.builder()
                .itemName(dto.itemName)
                .itemDetail(dto.itemDetail)
                .stockNumber(dto.stockNumber)
                .itemSellStatus(dto.itemSellStatus)
                .price(dto.price)
                .build();

        return entity;
    }

    public static ItemFormDTO of(Item entity) {
        ItemFormDTO dto = ItemFormDTO.builder()
                .itemName(entity.getItemName())
                .itemDetail(entity.getItemDetail())
                .itemSellStatus(entity.getItemSellStatus())
                .price(entity.getPrice())
                .stockNumber(entity.getStockNumber())
                .build();

        return dto;

    }

}
