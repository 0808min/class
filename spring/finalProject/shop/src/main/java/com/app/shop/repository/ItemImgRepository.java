package com.app.shop.repository;

import com.app.shop.entity.item.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    List<ItemImg> findItemIdOrderByIdAsc(Long itemId);


}
