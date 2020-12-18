import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String userName=req.getParameter("userName");
        String userPass= req.getParameter("userPass");
        Integer days=Integer.parseInt(req.getParameter("days"));



        if ("123".equals(userName)){
            if ("321".equals(userPass)){
                resp.getWriter().write("<script>window.alert('登录成功！')</script>");
                HttpSession httpSession=req.getSession();
                Cookie cookieName=new Cookie("userName",userName);
                Cookie cookiePass=new Cookie("userName",userPass);
                Cookie cookieDays=new Cookie("days",days.toString());

                cookieName.setMaxAge(3600*24*days);
                cookiePass.setMaxAge(3600*24*days);
                cookieDays.setMaxAge(3600*24*days);

                resp.addCookie(cookieName);
                resp.addCookie(cookiePass);
                resp.addCookie(cookieDays);
            }else {
                resp.getWriter().write("<script>window.alert('密码错误！')</script>");
            }
        }else {
            resp.getWriter().write("<script>window.alert('用户名不存在！')</script>");

        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
