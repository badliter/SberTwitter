package ru.sbt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String greeting(@RequestParam(name = "login", required = false, defaultValue = "login") String login, Model model) {
        model.addAttribute("login", login);
        return "signIn";
    }
}
