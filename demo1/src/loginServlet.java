import jdbc.dao.impl.dbDaoImpl;
import jdbc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String userName=req.getParameter("userName");
        String userPassWord=req.getParameter("userPassWord");



        dbDaoImpl dbDaoImpl =new dbDaoImpl();
        User user;
        user= dbDaoImpl.selectOne( "userName",userName);

        //判断是否登录成功

        //根据名字查询判断查询结果对象是否存在
        if ( user.getUserName()!=null){
            //比较对象的密码属性判断是否登录成功
            if(user.getUserName().equals(userName)&& user.getUserPass().equals(userPassWord)){
                resp.getWriter().write("<script>window.alert('登录成功！')</script>");
            }
            else {
                resp.getWriter().write("<script>window.alert('密码错误，请重新输入')</script>");
            }
        }else {
            resp.getWriter().write("<script>window.alert('用户名不存在，即将进入注册页面！')</script>");
            resp.getWriter().write("<script>window.location.href='register.html';</script>");
        }
        resp.getWriter().write("<script>window.location.href='login.html';</script>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
