package com.app.shop.domain.items;

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

    public ItemImgDTO(Long id, String imgName, String  oriImgName, String imgUrl, String repImgYn) {

    }

}
