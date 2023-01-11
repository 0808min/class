package com.app.shop.controller;

import com.app.shop.domain.items.ItemFormDTO;
import com.app.shop.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/admin/item/new")
    public String ItemForm(Model model) {
        model.addAttribute("itemFormDTO", new ItemFormDTO());
        return "/item/itemForm";
    }

    public String itemNew(@Valid ItemFormDTO itemFormDTO, BindingResult bindingResult, Model model,
    @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {

        if(bindingResult.hasErrors()) {
            return "item/itemForm";
        }

        if(itemImgFileList.get(0).isEmpty() && itemFormDTO.getId() == null) {
            model.addAttribute("errorMassage", "첫번째 상품 이미지는 필수 입력 값입니다.");
            return "item/itemForm";
        }

        try {
            itemService.saveItem(itemFormDTO, itemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMassage", "상품 등록중 에러가 발생했습니다.");

            return "item/itemForm";
        }


        return "redirect:/";

    }



}
