package com.app.shop;



import com.app.shop.domain.carts.CartItemDTO;
import com.app.shop.entity.cart.CartItem;
import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemSellStatus;
import com.app.shop.entity.member.Member;
import com.app.shop.repository.CartItemRepository;
import com.app.shop.repository.ItemRepository;
import com.app.shop.repository.MemberRepository;
import com.app.shop.service.CartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class CartServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CartService cartService;

    @Autowired
    CartItemRepository cartItemRepository;

    public Item saveItem() {
        Item item = Item.builder()
                .itemName("테스트 상품")
                .price(10000)
                .itemDetail("테스트 상품 설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100)
                .build();

        return itemRepository.save(item);
    }

    public Member saveMember() {
        Member member = Member.builder()
                .email("test@gmail.com")
                .build();

        return memberRepository.save(member);
    }

    @Test
    @DisplayName("장바구니 담기 테스트")
    public void addCart() {
        Item item = saveItem();
        Member member = saveMember();

        CartItemDTO cartItemDTO = CartItemDTO.builder()
                .itemId(item.getId())
                .count(5)
                .build();

        Long cartItemId = cartService.addCart(cartItemDTO, member.getEmail());
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(item.getId(), cartItem.getItem().getId());
        assertEquals(cartItemDTO.getCount(), cartItem.getCount());

    }

}
