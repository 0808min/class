package com.app.shop;

import com.app.shop.domain.items.ItemFormDTO;
import com.app.shop.entity.item.Item;
import com.app.shop.entity.item.ItemImg;
import com.app.shop.entity.item.ItemSellStatus;
import com.app.shop.repository.ItemImgRepository;
import com.app.shop.repository.ItemRepository;
import com.app.shop.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemImgRepository itemImgRepository;

    List<MultipartFile> createMultipartFiles() throws Exception {
        List<MultipartFile> multipartFileList = new ArrayList<>();

        // path 제일 앞에 경로를 /User로 수정함
        for(int i = 0; i < 5; i++) {
            String path = "/Users/mincreates/projects/upload/shop/item";
            String imgName = "image" + i + ".jpg";
            MockMultipartFile multipartFile = new MockMultipartFile
                    (path, imgName, "image/jpg", new byte[]{1,2,3,4});
            multipartFileList.add(multipartFile);

        }

        return multipartFileList;

    }


    @Test
    @DisplayName("상품 등록 테스트")
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void saveItem() throws Exception {
        ItemFormDTO itemFormDTO = ItemFormDTO.builder()
                .itemName("테스트 상품")
                .itemSellStatus(ItemSellStatus.SELL)
                .itemDetail("테스트 상품 설명")
                .price(1000)
                .stockNumber(100)
                .build();

        List<MultipartFile> multipartFileList = createMultipartFiles();
        Long itemId = itemService.saveItem(itemFormDTO, multipartFileList);

        List<ItemImg> itemImgList = itemImgRepository.findItemIdOrderByIdAsc(itemId);
        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);

        assertEquals(itemFormDTO.getItemName(), item.getItemName());
        assertEquals(multipartFileList.get(0).getOriginalFilename(), itemImgList.get(0).getOriImgName());
    }


}
