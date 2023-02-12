package com.timigv.jpa.controller;

import com.timigv.jpa.entity.Application;
import com.timigv.jpa.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
