package com.wn.Dao.impl;

import com.wn.Dao.userDao;
import com.wn.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class userDaoImpl implements userDao {
    SqlSession sqlSession;
    {
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> queryUser() {
        return sqlSession.selectList("user.queryUser");
    }
}
