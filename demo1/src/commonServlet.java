import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class commonServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String type=req.getParameter("type");
        if("add".equals(type)){
            //调用add方法的servlet

        }else if ("delete".equals(type)){
            //调用delete方法的servlet

        }else if ("update".equals(type)){
            //调用修改方法的servlet
        }else {
            //默认调用查询方法的servlet
        }
    }
}
