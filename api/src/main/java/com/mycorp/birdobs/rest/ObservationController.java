package com.mycorp.birdobs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycorp.birdobs.dto.ObservationDto;
import com.mycorp.birdobs.services.ObservationService;



@RestController
@RequestMapping("/observation")
public class ObservationController {

    @Autowired
    ObservationService observationService;

    @PostMapping
    public ResponseEntity<?> addObservationReport(@RequestBody ObservationDto observation) {
        if (observation.getReportID() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier l'ID. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        if (observation.getDate_pub() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier la date. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        ObservationDto savedObservationReport = observationService.save(observation);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedObservationReport);
    }
}