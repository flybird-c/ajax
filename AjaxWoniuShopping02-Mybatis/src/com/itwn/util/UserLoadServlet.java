package com.itwn.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
@WebServlet("/UserLoadServlet")
@MultipartConfig
public class UserLoadServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName="";
        String  file=req.getServletContext().getRealPath("/load/"+fileName);
        InputStream ins=new FileInputStream(file);
        fileName= URLEncoder.encode(fileName,"utf-8");
        resp.setHeader("Content-Disposition","attachemt;filename="+fileName);
        OutputStream out=resp.getOutputStream();
        byte[] bs=new  byte[1024];
        int temp=-1;
        while ((temp=ins.read(bs))!=-1){
            out.write(bs,0,temp);
        }
        ins.close();
        out.close();
    }

}
