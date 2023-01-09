package com.app.shop.domain.items;

import com.app.shop.entity.item.ItemImg;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ItemImgDTO {

    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    public ItemImgDTO(String imgName, String  oriImgName, String imgUrl, String repImgYn) {
        this.imgName = imgName;
        this.oriImgName = oriImgName;
        this.imgUrl = imgUrl;
        this.repImgYn = repImgYn;
    }

    public ItemImg toEntity(ItemImgDTO dto) {
        ItemImg entity = ItemImg.builder()
                .imgName(dto.imgName)
                .oriImgName(dto.oriImgName)
                .imgUrl(dto.imgUrl)
                .repimgYn(dto.repImgYn)
                .build();

        return entity;
    }
    

}
