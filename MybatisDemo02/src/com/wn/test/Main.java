package com.wn.test;

import com.wn.entity.User;
import com.wn.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Main {
    SqlSessionFactory factory;
    SqlSession sqlSession = null;

    {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    SqlSession sqlSession=new SqlSessionFactoryBuilder().build(Resource.class.getResourceAsStream("sqlMapConfig.xml")).openSession();
    @Test
    public void selectUser(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List list = mapper.queryAllUser();
        System.out.println(list);
    }
    @Test
    public void   deleteUserById(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count= mapper.deleteUserById(3);
        System.out.println(count);
    }
    @Test
    public  void  queryName(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user= mapper.queryUserByName("jam");
        System.out.println(user);
    }
}
