package com.timigv.jpa.service;

import com.timigv.jpa.dao.TicketDao;
import com.timigv.jpa.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;

    @Override
    public void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketDao.getTicket(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketDao.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(Integer id) {
        ticketDao.deleteTicket(id);
    }

    @Override
    public void closeTicket(Integer id) {
        ticketDao.closeTicket(id);
    }
}
