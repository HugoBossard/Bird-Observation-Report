package com.mycorp.birdobs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycorp.birdobs.dto.ReportDto;
import com.mycorp.birdobs.services.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    private final static String VERIFY_ID = "/{id:[0-9]+}";

    @PostMapping
    public ResponseEntity<?> addReport(@RequestBody ReportDto report) {
        if (report.getReportID() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier l'ID. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        if (report.getDatePub() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas spécifier la date. La base s'occupe de le créer.", HttpStatus.BAD_REQUEST);
        }

        if (report.getUserID() == null) {
            return new ResponseEntity<>("Un report est forcément lié à un utilisateur; vous ne pouvez pas faire ça.", HttpStatus.BAD_REQUEST);
        }

        ReportDto savedReport = reportService.save(report);

        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    @GetMapping(VERIFY_ID)
    public ResponseEntity<ReportDto> getReportById(@PathVariable Integer id) {
        ReportDto reportDto = reportService.findById(id);

        if (reportDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reportDto, HttpStatus.OK);
    }

    @PutMapping(VERIFY_ID)
    public ResponseEntity<?> updateReportById(@PathVariable Integer id, @RequestBody ReportDto report) {
        if (report.getReportID() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas modifier l'ID.", HttpStatus.BAD_REQUEST);
        }

        if (report.getDatePub() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas modifier la date.", HttpStatus.BAD_REQUEST);
        }

        if (report.getUserID() != null) {
            return new ResponseEntity<>("Vous ne pouvez pas modifier l'utilisateur lié au report.", HttpStatus.BAD_REQUEST); 
        }
        
        ReportDto reportUpdated = reportService.updateById(id, report);

        if (reportUpdated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reportUpdated, HttpStatus.OK);
    }

    @DeleteMapping(VERIFY_ID)
    public ResponseEntity<Void> deleteReportById(@PathVariable Integer id) {
        boolean found = reportService.deleteById(id);

        if (!found) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}