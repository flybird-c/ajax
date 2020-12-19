import jdbc.dao.FilmDao;
import jdbc.dao.impl.filmDaoImpl;
import jdbc.entity.Film;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/queryFilmServlet")
public class queryFilmServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num=req.getParameter("value");
        FilmDao filmImpl =new filmDaoImpl();

        //查询获得电影数据的长度（个数）
        int pageFilm = filmImpl.countFilm();

        //页数：8个一组，不够8个向上取整
        pageFilm=pageFilm/8+1;

        //将页数遍历存放进数组
        List arrayList = new ArrayList<>();
        for (int i = 1; i <= pageFilm; i++) {
            arrayList.add(i);
        }

//        for (Object o : arrayList) {
//            System.out.println(o.toString());
//        }

        req.setAttribute("arrayList",arrayList);

        //获得页数对应的电影数据
        //如果num为获得数据，则默认显示第一页
        if ("".equals(num)||num==null){
            List<Film> list= filmImpl.queryPageFilm(Integer.parseInt("1"));
            req.setAttribute("filmList",list);
        }else {
            List<Film> list= filmImpl.queryPageFilm(Integer.parseInt(num));
            req.setAttribute("filmList",list);
        }


        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
