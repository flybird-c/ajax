import jdbc.dao.impl.dbDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String userPassWord=req.getParameter("userPassWord");
        String userPhone=req.getParameter("userPhone");


        dbDaoImpl dbDaoImpl =new dbDaoImpl();
        dbDaoImpl.add( userName,userPassWord,userPhone);
        resp.getWriter().write("<script>windows.alert('注册成功！');</script>");
        resp.getWriter().write("<script>window.location.href='login.html';</script>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
