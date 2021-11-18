package yehor.zapara.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import yehor.zapara.spring.dao.AbstractDao;
import yehor.zapara.spring.dao.MovieDao;
import yehor.zapara.spring.model.Movie;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
