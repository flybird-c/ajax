package jdbc.dao.impl;

import jdbc.dao.UserDao;
import jdbc.entity.Users;
import jdbc.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  queryUserImpl implements UserDao {
    @Override
    public Users queryUser(String name) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Users users=new Users();
        try {
            connection= DbUtils.getConnection();
            String sql="select * from users where userNO=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
               users.setId(resultSet.getInt(1));
               users.setUserNo(resultSet.getString(2));
               users.setPassWord(resultSet.getString(3));
               users.setPhoneNum(resultSet.getString(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
