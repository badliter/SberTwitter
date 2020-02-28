package ru.sbt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgetYourPasswordController {
    @GetMapping("/passwordRecovery")
    public String greeting(@RequestParam(name = "login", required = false, defaultValue = "Enter your login") String login, Model model) {
        model.addAttribute("name", login);
        return "passwordRecovery";
    }
}
