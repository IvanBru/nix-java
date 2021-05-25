package com.example.springProj.controller;

import com.example.springProj.models.Item;
import com.example.springProj.repo.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ItemController {
    @Autowired
    private ItemsRepo itemsRepo;

    @GetMapping("/items")
    public String items(Model model){
        Iterable<Item> items= itemsRepo.findAll();
        model.addAttribute("items", items);
        return "items";
    }
    @PostMapping("/delItem")
    public String delItem(@RequestParam long itemId ,Model model){
        itemsRepo.deleteById(itemId);
        return "redirect:items";
    }

    @PostMapping("/editItem")
    public String editItem(@RequestParam long itemId ,Model model){
        Item itemEdit = itemsRepo.findById(itemId).orElseThrow(IllegalStateException::new);
        Iterable<Item> items= itemsRepo.findAll();
        model.addAttribute("items", items);
        model.addAttribute("itemEdit",itemEdit);
        return "items";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name,@RequestParam int price,Model model){
        Item item =  new Item(name,price);
        itemsRepo.save(item);
        return "redirect:items";
    }

    @PostMapping("/updateItem")
    public String updateItem(@RequestParam String itemId ,@RequestParam String name,@RequestParam int price,Model model){
        Item item = itemsRepo.findById(Long.valueOf(itemId).longValue()).orElseThrow(IllegalStateException::new);
        item.setName(name);
        item.setPrice(price);
        itemsRepo.save(item);
        return "redirect:items";
    }

}
