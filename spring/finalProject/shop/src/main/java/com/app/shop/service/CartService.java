package com.app.shop.service;


import com.app.shop.domain.carts.CartDetailDTO;
import com.app.shop.domain.carts.CartItemDTO;
import com.app.shop.entity.cart.Cart;
import com.app.shop.entity.cart.CartItem;
import com.app.shop.entity.item.Item;
import com.app.shop.entity.member.Member;
import com.app.shop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;

    public Long addCart(CartItemDTO cartItemDTO, String email) {
        Item item = itemRepository.findById(cartItemDTO.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);
        Cart cart = cartRepository.findByMemberId(member.getId());
        if(cart == null) {
            cart = Cart.createCart(member);
            cartRepository.save(cart);
        }

        CartItem savedCartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());
        if (savedCartItem != null) {
            savedCartItem.addCount(cartItemDTO.getCount());
        } else {
            CartItem cartItem = CartItem.createCartItem(cart, item, cartItemDTO.getCount());
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }
        return orderRepository.countOrder(email);
    }

    @Transactional(readOnly = true)
    public List<CartDetailDTO> getCartList(String email) {
        List<CartDetailDTO> cartDetailDTOList = new ArrayList<>();

        Member member = memberRepository.findByEmail(email);
        Cart cart = cartRepository.findByMemberId(member.getId());

        if(cart == null) {
            return cartDetailDTOList;
        }

        return cartDetailDTOList;

    }

}
