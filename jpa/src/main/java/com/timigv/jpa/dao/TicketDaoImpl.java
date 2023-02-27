package com.timigv.jpa.dao;

import com.timigv.jpa.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public Ticket getTicket(Integer id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        var query = "select t from Ticket t order by t.title";
        return (List<Ticket>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void updateTicket(Ticket ticket) {
        var exist = getTicket(ticket.getId());
        exist.setDescription(ticket.getDescription());
        exist.setApplication(ticket.getApplication());
        exist.setTitle(ticket.getTitle());
        entityManager.flush();
    }

    @Override
    public void deleteTicket(Integer id) {
        entityManager.remove(getTicket(id));
    }

    @Override
    public void closeTicket(Integer id) {
        var ticket = getTicket(id);
        ticket.setStatus("Resolved");
    }
}
