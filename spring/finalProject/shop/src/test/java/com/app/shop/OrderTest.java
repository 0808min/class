package com.app.shop;


import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemSellStatus;
import com.app.shop.entity.member.Member;
import com.app.shop.entity.order.Order;
import com.app.shop.entity.order.OrderItem;
import com.app.shop.repository.ItemRepository;
import com.app.shop.repository.MemberRepository;
import com.app.shop.repository.OrderItemRepository;
import com.app.shop.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
@Log4j2
public class OrderTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager manager;

    @Autowired
    OrderItemRepository orderItemRepository;


    public Item createItem() {
        Item item = Item.builder()
                .itemName("테스트 상품")
                .price(10000)
                .itemDetail("테스트 상품 상세설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100)
                .build();

        return item;
    }

    public Order createOrder() {
        Order order = new Order();

        IntStream.rangeClosed(1, 3).forEach(i -> {
            Item item = this.createItem();
            itemRepository.save(item);

            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .count(10)
                    .orderPrice(1000)
                    .order(order)
                    .build();

            order.getOrderItems().add(orderItem);
        });

        Member member = new Member();
        memberRepository.save(member);

        orderRepository.save(order);

        return order;
    }


    @Test
    @DisplayName("생명주기 테스트")
    public void cascadeTest() {

        Order order = new Order();

        IntStream.rangeClosed(1, 3).forEach(i -> {
            Item item = this.createItem();
            itemRepository.save(item);

            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .count(10)
                    .orderPrice(1000)
                    .order(order)
                    .build();

            order.getOrderItems().add(orderItem);
        });

        orderRepository.saveAndFlush(order);

        manager.clear();

        Order saveOrder = orderRepository.findById(order.getId())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals(10, saveOrder.getOrderItems());

    }

    @Test
    public void orTest () {
        Order order = this.createOrder();
        order.getOrderItems().remove(0);
        manager.flush();

    }

    @Test
    @DisplayName("지연 로딩 테스트")
    public void lazeLoadingTest() {
        Order order = this.createOrder();
        Long orderItemId = order.getOrderItems().get(0).getId();
        manager.flush();
        manager.clear();

        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(EntityNotFoundException::new);
        log.info("Order class : " + orderItem.getOrder().getClass());
        orderItem.getOrder().getOrderDate();


    }

}
