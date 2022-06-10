package com.webshop.frontend.controller;

import com.webshop.frontend.dto.User;
import com.webshop.frontend.services.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "signup";
    }

    @PostMapping("/validateLogin")
    public String validateLogin(Model model, @ModelAttribute("user") User user) {

        try {
            String token = loginService.validateUser(user);
            if (token != null) {
                return "redirect:/items";
            } else {
                model.addAttribute("STATUS", "FAILED");
                return "index";
            }
        } catch (Exception ex) {
            model.addAttribute("STATUS", "FAILED");
            log.error(ex.getMessage());
            return "index";
        }
    }

}
