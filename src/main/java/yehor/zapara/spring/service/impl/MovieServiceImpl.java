package yehor.zapara.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import yehor.zapara.spring.dao.MovieDao;
import yehor.zapara.spring.exception.DataProcessingException;
import yehor.zapara.spring.model.Movie;
import yehor.zapara.spring.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie by id " + id));
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
