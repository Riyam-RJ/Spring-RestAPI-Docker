package com.webshop.frontend.controller;

import com.webshop.frontend.dto.Item;
import com.webshop.frontend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String getItems(Model model) {

        try {
            List<Item> items = itemService.findAllItems();

            model.addAttribute("status", "success");
            model.addAttribute("items", items);

        } catch (Exception ex) {
            model.addAttribute("status", "failed");
        }

        return "items";
    }

}
