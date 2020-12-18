package jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DBproperties {
    private static Properties pro;
    static{
        //
        InputStream is= DBproperties.class.getClassLoader().getResourceAsStream("db.properties");
         pro=new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  String  getProperties(String key){return pro.getProperty(key);}
}
