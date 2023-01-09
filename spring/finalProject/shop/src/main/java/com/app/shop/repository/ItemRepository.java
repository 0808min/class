package com.app.shop.repository;

import com.app.shop.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item, Long> {
}
