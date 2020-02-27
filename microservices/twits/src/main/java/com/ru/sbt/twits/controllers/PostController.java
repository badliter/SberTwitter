package com.ru.sbt.twits.controllers;

import com.ru.sbt.twits.Twit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @PostMapping("/posttwit")
    public @ResponseBody ResponseEntity<String>
    postTwit(Twit twit) {
        return new ResponseEntity<String>("POST Response : "
                + twit.toString(), HttpStatus.OK);
    }
}
