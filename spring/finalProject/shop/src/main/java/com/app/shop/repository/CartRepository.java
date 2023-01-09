package com.app.shop.repository;

import com.app.shop.domain.carts.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
