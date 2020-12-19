

import jdbc.dao.UserDao;
import jdbc.dao.impl.queryUserImpl;
import jdbc.entity.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否已经登录，不可二次登录
        HttpSession session=req.getSession();
         if (session.getAttribute("login")!=null&&session.getAttribute("login")!=""){
             resp.getWriter().write("<script>window.alert('当前用户已登录！');</script>");
             System.out.println("当前用户已登录！");
             return;
         }

         //获取文本框的值，查询该用户将结果保存到实体类
        String userName=null;
        String userPass=null;
        UserDao userDao=null;
        Users users=null;
        userName= req.getParameter("userName");
        userPass=req.getParameter("userPass");
        userDao=new queryUserImpl();
        users=userDao.queryUser(userName);
        String name=userName;
        System.out.println(name);



        //登录状态判断
        if (users.getUserNo()!=null){
            if (userPass.equals(users.getPassWord())){
                //登录成功添加cookie到本地
                Cookie cookie=new Cookie(userName,userPass);
                cookie.setMaxAge(24*60*60);
                resp.addCookie(cookie);

                //为当前会话添加登录状态
                session.setAttribute("login",userName);
                session.setAttribute(userName, userPass);
                System.out.println(session.getAttribute(userName)+","+session.getAttribute("login"));

                //提示登录成功，重定向到新的主页
                resp.getWriter().write("<script>window.alert('登录成功！');</script>");
                System.out.println("登录成功");
                resp.sendRedirect("/queryFilmServlet");

                //域对象转发
//                RequestDispatcher requestDispatcher=this.getServletContext().getRequestDispatcher("/logoutServlet");
//                requestDispatcher.forward(req,resp);

                    //正常转发
//                req.getRequestDispatcher("/logoutServlet").forward(req, resp);
            }else {
                resp.getWriter().write("<script>window.alert('密码错误！');</script>");
                System.out.println("密码错误");
//                RequestDispatcher requestDispatcher=this.getServletContext().getRequestDispatcher("/queryFilmServlet");
//                requestDispatcher.forward(req,resp);

            }
        }else {
            resp.getWriter().write("<script>window.alert('用户名不存在，请注册！');</script>");
            System.out.println("用户不存在，请注册");
//            RequestDispatcher requestDispatcher=this.getServletContext().getRequestDispatcher("/queryFilmServlet");
//            requestDispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
