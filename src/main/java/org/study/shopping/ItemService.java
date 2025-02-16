package org.study.shopping;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    public void editItem(Long id, String title, Integer price) throws Exception{
        if(title.length() >= 100 || price < 0) {
            throw new Exception("제목이 100자 이상 혹은 가격이 음수임");
        } else {
            Item item = new Item();
            item.setId(id);
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }
    }
}
