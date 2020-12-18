package jdbc.dao.impl;

import jdbc.entity.User;
import jdbc.utils.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbDaoImpl implements jdbc.dao.dbDao {
    @Override
    public void add(User user) {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="INSERT INTO USER VALUES(?,?,?,?) ";
        try {
            conn=DbUtils.getConnection();
            pst= conn.prepareStatement(sql);
            pst.setInt(1,0);
            pst.setString(2,user.getUserName());
            pst.setString(3,user.getUserPass());
            pst.setString(4,user.getUserPhone());
            pst.executeUpdate();
            System.out.println("插入数据成功");
//            if(rs!=null&&!rs.isClosed())
//                rs.close();
//            if(pst!=null&&!pst.isClosed())
//                pst.close();
//            if(conn!=null&&!conn.isClosed())
//                conn.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void add(String userName, String userPass, String userPhone) {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="INSERT INTO USER VALUES(?,?,?,?) ";
        try {
            conn=DbUtils.getConnection();
            pst= conn.prepareStatement(sql);
            pst.setInt(1,0);
            pst.setString(2,userName);
            pst.setString(3,userPass);
            pst.setString(4,userPhone);
            pst.executeUpdate();
            System.out.println("插入数据成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public int del(int id) {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="delete from USER where id =?";
        try {
            conn=DbUtils.getConnection();
            pst= conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("删除数据成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateUser(User user) {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="update user set userName=?,userPass=?,userPhone=?";//不定参数更新数据可能需要用到反射
        try {
            conn=DbUtils.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getUserPass());
            pst.setString(3,user.getUserPhone());
            pst.executeUpdate();//更新数据
            System.out.println("更新数据成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> queryUser() {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select * from user; ";
        List<User> list=new ArrayList<>();
        try {
            conn=DbUtils.getConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setID(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserPass(rs.getString(3));
                user.setUserPhone(rs.getString(4));
                list.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return  list;
    }

    @Override
    public User selectOne(String type, String sqlText) {
        User user=new User();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select * from user where "+type+"=?";
        try {
            conn=DbUtils.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setString(1,sqlText);
            rs=pst.executeQuery();
            while (rs.next()){
                user.setID(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserPass(rs.getString("userPass"));
                user.setUserPhone(rs.getString("userPhone"));
            }

            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User selectOne(int ID) {
        User user=new User();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select * from user where id=?";
        try {
            conn=DbUtils.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,ID);
            rs=pst.executeQuery();
            while (rs.next()){//必须用next遍历结果集挨个取出才有结果
                user.setID(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserPass(rs.getString(3));
                user.setUserPhone(rs.getString(4));
            }
            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
