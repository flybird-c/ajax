package com.wn.mapper;

import com.wn.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> queryAllUser();
    public User queryUserByName(String name);
    //2. 查询相应页数的用户信息
//    public List<User> queryUser(int nowPage,int pageSize);
    //3.根据id搜索用户信息
//    public User queryUserById(int id);

    //4.根据id删除用户
    public int  deleteUserById(int id);

    //5.添加用户
//    public int  addUser(User user);

}
