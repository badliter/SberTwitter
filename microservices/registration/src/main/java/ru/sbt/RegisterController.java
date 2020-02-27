package ru.sbt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Unknown user") String name, Model model) {
        model.addAttribute("name", name);
        return "signUp";
    }
}
