package com.mycorp.birdobs.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/observation")
public class ObservationControlleur {

    @GetMapping()
    public ResponseEntity<Void> test() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}