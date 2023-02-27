package com.timigv.jpa.controller;

import com.timigv.jpa.entity.Application;
import com.timigv.jpa.entity.Ticket;
import com.timigv.jpa.service.ApplicationService;
import com.timigv.jpa.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tza")
@RequiredArgsConstructor
public class TrackZillaController {

    private final ApplicationService applicationService;
    private final TicketService ticketService;

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
    public ResponseEntity<Application> getApplication(@PathVariable("id") Long id) {
        var application = applicationService.getApplication(id);
        if (application == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping("/application")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
        applicationService.update(application);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Long id) {
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket, UriComponentsBuilder builder) {
        ticketService.addTicket(ticket);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id) {
        var ticket = ticketService.getTicketById(id);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        var tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PutMapping("/ticket")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<Ticket> closeTicket(@PathVariable("id") Integer id) {
        ticketService.closeTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
