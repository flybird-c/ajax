package jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static DbUtils instance=new DbUtils();
    private DbUtils(){}
    public static DbUtils getInstance(){
        return instance;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn=null;

            Class.forName(DBproperties.getProperties(finalData.DIVER_CLASS));//Class.forName是一个静态方法，同样可以用来加载类。
            conn= DriverManager.getConnection(DBproperties.getProperties(finalData.URL),
                    DBproperties.getProperties(finalData.USER),
                    DBproperties.getProperties(finalData.PASSWORD));
             /*
            DriverManager是驱动的管理类
            1）通过重载的getConnection()方法获取数据库连接，较为方便
            2）通过DriverManager可以注册并同时管理多个驱动程序：如果注册了多个数据库连接，则调用getConnection()方法时传入不同参数，返回不同的数据库连接
             */
        return conn;
    }

}
