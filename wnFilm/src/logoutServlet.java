
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到当前会话,没有则不创建
        HttpSession session=req.getSession();
        if (session.getAttribute("login")!=null||session.getAttribute("login")!=""){
            resp.getWriter().write("<script>window.alert('请先登录！');</script>");
            System.out.println("请先登录");
        }else {

            //将会话当前登录状态清空
//            String  loginName= (String) session.getAttribute("login");
            session.invalidate();
//            session.setAttribute("login","");
//            session.removeAttribute(loginName);

            //提示+重定向
            resp.getWriter().write("<script>window.alert('注销成功！');</script>");
            System.out.println("注销成功");
            resp.sendRedirect("/queryFilmServlet");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
