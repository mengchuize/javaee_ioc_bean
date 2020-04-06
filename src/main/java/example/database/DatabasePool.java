package example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

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
                HikariConfig hikariconfig=new HikariConfig();
                hikariconfig.setUsername("root");
                hikariconfig.setPassword("Mengchuize");
                hikariconfig.setDriverClassName("com.mysql.jdbc.Driver");
                hikariconfig.setJdbcUrl("jdbc:mysql://localhost:3306/newdatabase?serverTimezone=UTC");
                hikariDatasource=new HikariDataSource(hikariconfig);
                return hikariDatasource;
            }

        }
        return null;

    }

    public static void main(String[] args) {

    }
}
