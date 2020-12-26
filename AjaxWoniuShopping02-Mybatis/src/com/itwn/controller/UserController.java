package com.itwn.controller;

import com.alibaba.fastjson.JSON;
import com.itwn.entity.User;
import com.itwn.mapper.UserMapper;
import com.itwn.util.CommonServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserController")
public class UserController extends CommonServlet {
    SqlSessionFactory factory;

    {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    SqlSession sqlSession =factory.openSession();

    @Override
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.queryAllUser();
        String s = JSON.toJSONString(userList);
        System.out.println(s);
        resp.getWriter().write(s);

    }

    @Override
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获得前端输入的账号密码

        System.out.println(req.getParameter("type"));
        String userName= req.getParameter("username");
        System.out.println(userName);
        String userPass= req.getParameter("password");
        System.out.println(userPass);
        //代理查询得到user类
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user= userMapper.queryUserByName(userName);
        //判断该user类是否为空
        if (user!=null){
            //密码对比
            if (user.getUserPass().equals(userPass)){
                //为当前会话设置登录状态
                HttpSession httpSession=req.getSession();
                httpSession.setAttribute("login",user.getUserName());
                //添加cookie

                //可以把对象序列化到cookie吗？
                Cookie cookieUserId=new Cookie("userId",user.getId()+"");
                Cookie cookieUserName=new Cookie("userName",user.getUserName());
                Cookie cookieUserPass=new Cookie("userPass",user.getUserPass());
                Cookie cookieUserPhone=new Cookie("userPhone",user.getUserPhone());
                Cookie cookieUserImg=new Cookie("userImg",user.getUserImg());
                Cookie cookieUserType=new Cookie("userType",user.getUserType()+"");

                cookieUserId.setMaxAge(60*60*24);
                cookieUserName.setMaxAge(60*60*24);
                cookieUserPass.setMaxAge(60*60*24);
                cookieUserPhone.setMaxAge(60*60*24);
                cookieUserImg.setMaxAge(60*60*24);
                cookieUserType.setMaxAge(60*60*24);

                resp.addCookie(cookieUserId);
                resp.addCookie(cookieUserName);
                resp.addCookie(cookieUserPass);
                resp.addCookie(cookieUserPhone);
                resp.addCookie(cookieUserImg);
                resp.addCookie(cookieUserType);

                resp.getWriter().write("1");
            }else {
                resp.getWriter().write("0");
            }
        }else {
            resp.getWriter().write("-1");
        }
        System.out.println(user!=null?user.toString():"查询不到user");
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.delete(req, resp);
    }
}