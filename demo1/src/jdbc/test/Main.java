package jdbc.test;

import org.junit.Test;
import jdbc.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    @Test
    public void connTest() throws SQLException, ClassNotFoundException {
        Connection connection = DbUtils.getConnection();
        System.out.println("链接成功");
        connection.close();
    }
//    public static void main(String[] args) {
//        User user=new User();
//        JDBC.dao.dbDao db=new dbDao();
//        db.add(user);
//        user.setID(1);
//        db.del(user.getID());
//        System.out.println(db.queryUser());
//        user.setID(10);
//        user.setUserName("测试2");
//        user.setUserPass("0987");
//        user.setUserPhone("13457372397");
//        db.updateUser(user);
//        System.out.println(db.queryUser());
//      db.selectID(2);
//        db.selectName("测试2");
//
//    }
}
