package ru.sbt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class RegisterController {
    @Autowired
    private RegistrationDataBaseLogic dataBaseLogic;

    @GetMapping("/register")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Unknown user") String name, Model model) {
        model.addAttribute("name", name);
        return "signUp";
    }
    @GetMapping("/getAllUsers/{user_id}")
    public ResponseEntity getAllTwits(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dataBaseLogic.getAllUsers(user_id), OK);
    }
}
