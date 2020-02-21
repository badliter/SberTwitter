package com.ru.sbt.twits.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetController {
    @GetMapping("/gettwit/{id}")
    public @ResponseBody ResponseEntity<String>
    getTwitById(@PathVariable String id) {
        return new ResponseEntity<String>("GET Response : "
                + id, HttpStatus.OK);
    }
}
