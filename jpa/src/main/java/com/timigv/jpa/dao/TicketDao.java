package com.timigv.jpa.dao;

import com.timigv.jpa.entity.Ticket;

import java.util.List;

public interface TicketDao {

    void addTicket(Ticket ticket);

    Ticket getTicket(Integer id);

    List<Ticket> getAllTickets();

    void updateTicket(Ticket ticket);

    void deleteTicket(Integer id);

    void closeTicket(Integer id);
}
