package example.database;

public class JdbcBeans {
    public String Username;
    public String Password;
    public String DriverClassName;
    public String JdbcUrl;

    public void setDriverClassName(String driverClassName) {
        DriverClassName = driverClassName;
    }

    public void setJdbcUrl(String jdbcUrl) {
        JdbcUrl = jdbcUrl;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getDriverClassName() {
        return DriverClassName;
    }

    public String getJdbcUrl() {
        return JdbcUrl;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return Username;
    }

}
