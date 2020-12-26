package com.itwn.mapper;

import com.itwn.entity.User;

import java.util.List;

public interface UserMapper {
    //查询当前数据库中任一表的数据数量
    public int queryTableCount(String tableName);
    //查询当前页用户
    public List<User> queryNowPageUser(int nowPage);
    //查询所有用户
    public List<User> queryAllUser();
    //名字查询单一用户（登录，搜索）
    public  User queryUserByName(String userName);
    //给定一个用户的任意信息，删除对应的用户
    public  void  deleteUser(User user);

}
