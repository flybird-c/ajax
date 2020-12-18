package jdbc.dao;

import jdbc.entity.Film;

import java.util.List;

public interface FilmDao {
    public List<Film> queryFilm();
}
