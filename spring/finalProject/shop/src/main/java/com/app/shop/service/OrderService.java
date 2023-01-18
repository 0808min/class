package com.app.shop.service;

import com.app.shop.domain.order.OrderDTO;
import com.app.shop.domain.order.OrderHistoryDTO;
import com.app.shop.domain.order.OrderItemDTO;
import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemImg;
import com.app.shop.entity.member.Member;
import com.app.shop.entity.order.Order;
import com.app.shop.entity.order.OrderItem;
import com.app.shop.repository.ItemImgRepository;
import com.app.shop.repository.ItemRepository;
import com.app.shop.repository.MemberRepository;
import com.app.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemImgRepository itemImgRepository;

    public Long order(OrderDTO orderDTO, String email) {
        Item item = itemRepository.findById(orderDTO.getItemId()).orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDTO.getCount());
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getId();
    }

    @Transactional(readOnly = true)
    public Page<OrderHistoryDTO> getOrderList(String email, Pageable pageable) {

        List<Order> orders = orderRepository.findOrders(email, pageable);
        Long totalCount = orderRepository.countOrder(email);
        List<OrderHistoryDTO> orderHistoryDTOS = new ArrayList<>();

        for(Order order : orders) {
            OrderHistoryDTO orderHistoryDTO = new OrderHistoryDTO(order);
            List<OrderItem> orderItems = order.getOrderItems();

            for (OrderItem orderItem : orderItems) {
                ItemImg itemImg = itemImgRepository.findByItemIdAndRepimgYn(orderItem.getItem().getId(), "Y");

                OrderItemDTO orderItemDTO = new OrderItemDTO(orderItem, itemImg.getImgUrl());
                orderHistoryDTO.addOrderItemDTO(orderItemDTO);
            }
        }

        return new PageImpl<OrderHistoryDTO>(orderHistoryDTOS, pageable, totalCount);
    }

    @Transactional(readOnly = true)
    public boolean validateOrder(Long orderId, String email) {
        Member curMember = memberRepository.findByEmail(email);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        Member saveMember = order.getMember();

        if(StringUtils.equals(curMember.getEmail(), saveMember.getEmail())) {
            return false;
        }

        return true;
    }

    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        order.cancelOrder;
    }




}
