package yehor.zapara.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import yehor.zapara.spring.dao.AbstractDao;
import yehor.zapara.spring.dao.TicketDao;
import yehor.zapara.spring.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
