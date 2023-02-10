package com.app.shop;

import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemSellStatus;
import com.app.shop.entity.member.Member;
import com.app.shop.repository.ItemRepository;
import com.app.shop.repository.MemberRepository;
import com.app.shop.repository.OrderRepository;
import com.app.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

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

}
