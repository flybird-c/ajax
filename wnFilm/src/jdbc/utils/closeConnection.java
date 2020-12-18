package jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

public  class closeConnection {
    public static void closeConnection(){
        try {
            Connection conn=DbUtils.getConnection();
            if(conn!=null&&!conn.isClosed()){
                System.out.println("获取连接成功正在关闭");
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
