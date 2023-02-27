package com.timigv.jpa.service;

import com.timigv.jpa.entity.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    Ticket getTicketById(Integer id);

    List<Ticket> getAllTickets();

    void updateTicket(Ticket ticket);

    void deleteTicket(Integer id);

    void closeTicket(Integer id);
}
