package yehor.zapara.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import yehor.zapara.spring.dao.AbstractDao;
import yehor.zapara.spring.dao.CinemaHallDao;
import yehor.zapara.spring.model.CinemaHall;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory factory) {
        super(factory, CinemaHall.class);
    }
}
