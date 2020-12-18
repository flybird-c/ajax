package jdbc.dao.impl;

import jdbc.dao.FilmDao;
import jdbc.entity.Film;
import jdbc.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class filmDaoImpl implements FilmDao {
    @Override
    public List<Film> queryFilm() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Film> filmList=new ArrayList<>();
        try {
            connection= DbUtils.getConnection();
            String sql="select  * from film order by fPrice desc";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Film film=new Film();
                film.setId(resultSet.getInt(1));
                film.setfName(resultSet.getString(2));
                film.setfPrice(resultSet.getDouble(3));
                film.setImgSrc(resultSet.getString(4));
                film.setComments(resultSet.getString(5));
                film.setType(resultSet.getString(6));
                filmList.add(film);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filmList;
    }
}
