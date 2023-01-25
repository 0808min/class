package com.app.shop.controller;

import com.app.shop.domain.carts.CartDetailDTO;
import com.app.shop.domain.carts.CartItemDTO;
import com.app.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CartController {

    private final CartService cartService;

    @PostMapping(value = "/cart")
    public ResponseEntity order(@RequestBody @Valid CartItemDTO cartItemDTO
                               , BindingResult bindingResult, Principal principal) {

        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }

            return new ResponseEntity<String>(sb.toString(),HttpStatus.BAD_REQUEST);
        }

        String email = principal.getName();
        Long cartItemId;

        try {
            cartItemId = cartService.addCart(cartItemDTO, email);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
    }

    @GetMapping(value = "/cart")
    public String orderList(Principal principal, Model model) {
        List<CartDetailDTO> cartDetailDTOList = cartService.getCartList(principal.getName());
        model.addAttribute("cartItems", cartDetailDTOList);
        return "cart/cartlist";
    }


}
