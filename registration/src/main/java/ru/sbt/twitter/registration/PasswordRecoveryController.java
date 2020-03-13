package ru.sbt.twitter.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class PasswordRecoveryController {
    @GetMapping("passwordRecovery/{username}")
    public ResponseEntity<String> recoverPassword(@PathVariable String username) {
        return new ResponseEntity<>(username + ", it's a pity!", OK);
    }
}
