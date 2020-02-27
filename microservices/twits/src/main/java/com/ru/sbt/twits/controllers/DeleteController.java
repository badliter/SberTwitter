package com.ru.sbt.twits.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteController {
    @DeleteMapping("/deletetwit/{id}")
    public @ResponseBody ResponseEntity<String>
    deleteTwitById(@PathVariable String id) {
        return new ResponseEntity<String>("DELETE Response : "
                + id, HttpStatus.OK);
    }
}
