package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.OrderCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/order/order")
public class OrderController {

    @GetMapping
    public String getOrderForm(){
        return "order/orderForm";
    }

    @PostMapping
    public void order(
            OrderCommand orderCommand
    ){
        // /WEB-INF/views/order/order.jsp
        log.info(orderCommand);
    }
}
