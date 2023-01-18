package com.app.shop.repository;

import com.app.shop.domain.items.MainItemDTO;
import com.app.shop.domain.items.ItemSearchDTO;

import com.app.shop.entity.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable);

    Page<MainItemDTO> getMainItemPage(ItemSearchDTO itemSearchDTO, Pageable pageable);
}
