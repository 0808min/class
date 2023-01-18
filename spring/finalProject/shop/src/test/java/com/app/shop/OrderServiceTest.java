package com.app.shop;


import com.app.shop.domain.order.OrderDTO;
import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemSellStatus;
import com.app.shop.entity.member.Member;
import com.app.shop.entity.order.Order;
import com.app.shop.entity.order.OrderItem;
import com.app.shop.repository.ItemRepository;
import com.app.shop.repository.MemberRepository;
import com.app.shop.repository.OrderRepository;
import com.app.shop.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;


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
    @DisplayName("주문 테스트")
    public void order() {
        Item item = saveItem();
        Member member = saveMember();

        OrderDTO orderDTO = OrderDTO.builder()
                .itemId(item.getId())
                .count(30)
                .build();

        Long orderId = orderService.order(orderDTO, member.getEmail());

        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        List<OrderItem> orderItems = order.getOrderItems();

        int totalPrice = orderDTO.getCount() + item.getPrice();

        assertEquals(totalPrice, order.getTotalPrice());

    }

}
