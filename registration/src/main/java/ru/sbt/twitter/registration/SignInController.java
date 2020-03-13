package ru.sbt.twitter.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.twitter.registration.model.User;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class SignInController {
    @Autowired
    RegistrationDBLogic dbLogic;

    @GetMapping("/signIn/{username}/{password}")
    public ResponseEntity<User> signIn(@PathVariable String username, @PathVariable String password) {
        return new ResponseEntity<User>(dbLogic.signIn(username, password), OK);
    }

    @GetMapping("/signOut/{username}")
    public ResponseEntity<String> signOut(@PathVariable String username) {
        return new ResponseEntity<>(dbLogic.signOut(username), OK);
    }
}
