package com.ru.sbt.twits.controllers;

import com.ru.sbt.twits.Twit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutController {
    @PutMapping("/puttwit")
    public @ResponseBody ResponseEntity<String>
    putTwit(Twit twit) {
        return new ResponseEntity<String>("PUT Response : "
                + twit.toString(), HttpStatus.OK);
    }
}