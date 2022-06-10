package com.webshop.frontend.controller;

import com.webshop.frontend.dto.User;
import com.webshop.frontend.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/saveUser")
    public String addUser(Model model, @ModelAttribute("user") User user) {

        try {
            userService.saveUser(user);
            model.addAttribute("STATUS", "SUCCESS");
        } catch (Exception ex) {
            model.addAttribute("STATUS", "FAILED");
            log.error(ex.getMessage());
        }

        return "signup";
    }

}
