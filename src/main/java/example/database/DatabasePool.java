package example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import example.beans.Homework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabasePool {

    public static HikariDataSource hikariDatasource;

    public static HikariDataSource getHikarDataSourse(){

        if(hikariDatasource!=null)
        {
            return hikariDatasource;
        }

        synchronized (DatabasePool.class){
            if(hikariDatasource==null)
            {
                //读取配置文件实例化一个IOC容器
                ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
                //从容器中获取对象
                JdbcBeans t=(JdbcBeans)context.getBean("jdbc");

                HikariConfig hikariconfig=new HikariConfig();
                hikariconfig.setUsername(t.Username);
                hikariconfig.setPassword(t.Password);
                hikariconfig.setDriverClassName(t.DriverClassName);
                hikariconfig.setJdbcUrl(t.JdbcUrl);
                hikariDatasource=new HikariDataSource(hikariconfig);
                return hikariDatasource;
            }

        }
        return null;

    }

    public static void main(String[] args) {

    }
}
