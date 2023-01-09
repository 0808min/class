package com.app.shop.entity.order;


import com.app.shop.entity.item.Item;
import com.app.shop.entity.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@ToString
@Table(name = "order_item_id")
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private int orderPrice; // 주문처리

    private int count; // 수량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_id")
    private Order order;

    @Builder
    public OrderItem(Item item, Order order, int orderPrice, int count) {
        this.item = item;
        this.order = order;
        this.orderPrice = orderPrice;
        this.count = count;

    }


}
