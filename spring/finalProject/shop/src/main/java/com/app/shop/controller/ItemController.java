package com.app.shop.controller;

import com.app.shop.domain.items.ItemFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @GetMapping(value = "/admin/item/new")
    public String ItemForm(Model model) {
        model.addAttribute("itemFormDTO", new ItemFormDTO());
        return "/item/itemForm";

    }

}
