package com.itwn.util;

import com.itwn.entity.User;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

public class CommonUtil {
    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
    private static  String userName="xxxx";
    private static String userPass="xxx";
    //1.上传。。。。
    public static String up(HttpServletRequest req, String fileName, String dir) throws ServletException, IOException {
        String path=null;
        Part part=req.getPart(fileName);
        if(part!=null && part.getSize()>0){
            //1.得到服务器的目录
            String serverPath=req.getServletContext().getRealPath("/"+dir);
            //2.得到上传文件的原名字
            String upFileName=part.getSubmittedFileName();
            //3.得到上传到服务器的新文件名字(唯一)
            upFileName= UUID.randomUUID().toString().replace("-","")+upFileName;
            //4.上传图片值服务器目录中
            part.write(serverPath+"/"+upFileName);
            path=dir+"/"+upFileName;
        }
        return path;
    }
    //2.下载
    public static void load(HttpServletRequest req, HttpServletResponse resp,String fileName,String dir)throws ServletException, IOException {
        //下载  (将服务器端文件写入到客户端)
        String fileServerPath=req.getServletContext().getRealPath("/"+dir+"/"+fileName);
        InputStream ins=new FileInputStream(fileServerPath);
        //2.设置下载框中文件名字的编码为UTF-8
        fileName= URLEncoder.encode(fileName,"UTF-8");
        //3.弹出下载框
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        //4. 点击下载实现 读取服务器端文件 写入到客户端
        OutputStream out=resp.getOutputStream();
        //5. 文件流读写操作
        byte[] bs=new byte[1024];
        int temp=-1;
        while((temp=ins.read(bs))!=-1){
            out.write(bs,0,temp);
        }
        //7.关闭输入输出流
        ins.close();
        out.close();
    }


    //批量导入数据的功能方法
    public static <T>List<T> getUpList(HttpServletRequest req, String fileName,Class<T> cla)throws ServletException, IOException {
        Part part=req.getPart(fileName);
        if(part!=null&&part.getSize()>0&&part.getSubmittedFileName().endsWith(".csv")){
            List<T> list=new ArrayList<>();
            //1.得到上传文件的输入流 (读)
            InputStream ins=part.getInputStream();
            //2.将字节流转成字符输入缓冲流
            BufferedReader br=new BufferedReader(new InputStreamReader(ins));
            List<String> listStr=new ArrayList<>();
            String temp=null;
            //3.将读取到的内容存入listStr集合中
            while ((temp=br.readLine())!=null){
                listStr.add(temp);
            }
            br.close();
            //4.将listStr===>list<T>
            //<1>.得到第一行的属性名字
            String[] filedNames=listStr.get(0).split(",");
            for(int i=1;i<listStr.size();i++){
                //<2>.得到一行数据
                String[] lines=listStr.get(i).split(",");
                try {
                    //<3>.创建一个实体类对象
                    T t=cla.newInstance();
                    for(int j=0;j<filedNames.length;j++){
                        //<4>.拿到属性，并且将对应的值插入到对应的属性中
                        Field f=cla.getDeclaredField(filedNames[j]);
                        f.setAccessible(true);
                        Object fieldValue=lines[j];
                        String fieldType=f.getGenericType().getTypeName();
                        //将字符串转成数值类型....
                        if(fieldType.contains("int")||fieldType.contains("Integer")){
                            fieldValue=Integer.parseInt(lines[j]);
                        }else if(fieldType.contains("double")||fieldType.contains("Double")){
                            fieldValue=Double.parseDouble(lines[j]);
                        }
                        f.set(t,fieldValue);
                    }
                    list.add(t);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
      return null;
    }
    //1.根据手机号码返回验证码
    public static String getCode(String phone){
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        int mobile_code = (int)((Math.random()*9+1)*100000);
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", userName), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", userPass),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String SubmitResult =method.getResponseBodyAsString();
            //System.out.println(SubmitResult);
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);
            if("2".equals(code)){
                System.out.println("短信提交成功");
                return mobile_code+"";
            }
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
