package jdbc.dao;

import jdbc.entity.Users;

public interface UserDao {
    //通过名字查询用户，获得用户信息
    public Users queryUser(String name);
}
