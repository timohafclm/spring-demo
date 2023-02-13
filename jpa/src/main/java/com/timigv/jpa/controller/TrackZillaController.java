package com.timigv.jpa.controller;

import com.timigv.jpa.entity.Application;
import com.timigv.jpa.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tza")
@RequiredArgsConstructor
public class TrackZillaController {

    private final ApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity<Void> addApplication(@RequestBody Application application) {
        boolean created = applicationService.addApplication(application);
        if (!created) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        var headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> get(@PathVariable("id") Long id) {
        var application = applicationService.getApplication(id);
        if (application == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping("/application")
    public ResponseEntity<Application> update(@RequestBody Application application) {
        applicationService.update(application);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
