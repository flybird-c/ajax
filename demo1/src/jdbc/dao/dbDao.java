package jdbc.dao;

import jdbc.entity.User;

import java.util.List;

public interface dbDao {
    //增
    public void add(User user);
    public void add(String userName,String userPass,String userPhone);
    //删
    public int  del(int id);
    //改
    public int updateUser(User user);
    //查
    public List<User> queryUser();
    //单个查询
    User selectOne(String type, String name);

    //按id查询
    public User selectOne(int ID);
}
