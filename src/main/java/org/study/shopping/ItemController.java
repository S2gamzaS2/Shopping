package org.study.shopping;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final NoticeRepository noticeRepository;

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/notice")
    String notice(Model model){
        List<Notice> result = noticeRepository.findAll();
        model.addAttribute("notices", result);
        return "notice.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@ModelAttribute Item item){
        System.out.println(item);
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            model.addAttribute("items", result.get());
            return "detail.html";
        }
        return "redirect:/list";
    }
}
