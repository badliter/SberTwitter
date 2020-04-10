package ru.sbt.twitter.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbt.twitter.registration.model.User;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class SignUpController {
    @Autowired
    RegistrationDBLogic dbLogic;

    @GetMapping("/getUser/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable("user_id") long user_id) {
        return new ResponseEntity<>(dbLogic.getUserById(user_id), OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody User user){
        return new ResponseEntity<>(dbLogic.signUp(user), OK);
    }
}
