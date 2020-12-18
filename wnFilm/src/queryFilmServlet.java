import jdbc.dao.FilmDao;
import jdbc.dao.impl.filmDaoImpl;
import jdbc.entity.Film;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryFilmServlet")
public class queryFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDao filmImpl =new filmDaoImpl();
        List<Film> list= filmImpl.queryFilm();
        req.setAttribute("filmList",list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
