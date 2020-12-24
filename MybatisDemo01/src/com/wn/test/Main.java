package com.wn.test;

import com.wn.Dao.impl.userDaoImpl;
import com.wn.Dao.userDao;
import com.wn.entity.User;
import org.junit.Test;

import java.util.List;

public class Main {
    userDao ud = new userDaoImpl();

    @Test
    public void select(){
        List<User> users = ud.queryUser();
        System.out.println(users);
    }
}
