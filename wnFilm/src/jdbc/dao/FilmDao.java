package jdbc.dao;

import jdbc.entity.Film;

import java.util.List;

public interface FilmDao {
    //每次以页码为起始返回一个列表，8个电影数据
    public List<Film> queryPageFilm(int page);

    //查询数据的数量
    public int countFilm();
}
