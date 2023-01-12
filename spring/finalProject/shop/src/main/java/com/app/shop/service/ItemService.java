package com.app.shop.service;

import com.app.shop.domain.items.ItemFormDTO;
import com.app.shop.domain.items.ItemImgDTO;
import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemImg;
import com.app.shop.repository.ItemImgRepository;
import com.app.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDTO itemFormDTO, List<MultipartFile> itemImgFileList) throws Exception {

        // 상품 등록
        Item item = itemFormDTO.toEntity(itemFormDTO);
        itemRepository.save(item);

        // 이미지 등록
        for (int i = 0, max = itemImgFileList.size(); i < max; i++) {
            ItemImg itemImg = ItemImg.builder()
                    .item(item)
                    .repimgYn(i == 0 ? "Y" : "N")
                    .build();

            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }

        return item.getId();

    }

    @Transactional(readOnly = true)
    public ItemFormDTO getItemDetail(Long itemId) {

        List<ItemImg> itemImgList = itemImgRepository.findItemIdOrderByIdAsc(itemId);
        List<ItemImgDTO> itemImgDTOList = new ArrayList<>();

        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
        ItemFormDTO itemFormDTO = ItemFormDTO.of(item);
        itemFormDTO.setItemImgDTOList(itemImgDTOList);

        return itemFormDTO;

    }

}
