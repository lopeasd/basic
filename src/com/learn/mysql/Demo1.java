package com.learn.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/4/2 22:13
 * @Version: 1.0
 */
public class Demo1 {


    public static void main(String[] args) throws Exception {
        Connection conn = new Demo1().demo2();
        System.out.println(conn);
        String sql = "delete from hah where id=5;";
        Statement statement = conn.createStatement();
        boolean b = statement.execute(sql);
        statement.executeUpdate("");
        System.out.println(b);
    }

    private static void test1() throws Exception {
        Statement stmt = new Demo1().getConnection1().createStatement();
        String sql = "insert into hah values(6,'demo2');";
        boolean execute = stmt.execute(sql);
        System.out.println(execute);
    }

    public Connection getConnection1() throws Exception {
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        // 读取类路径下的jdbc.properties 文件
        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);

        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        // 通过反射创建 Driver 对象
        Driver driver = (Driver) Class.forName(driverClass).newInstance();

        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);

        // 通过 Driver 的 connect 方法连接数据库.
        Connection connection = driver.connect(jdbcUrl, info);

        return connection;
    }

    public Connection getConnection2() throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");

        properties.load(inputStream);

        String driver = properties.getProperty("driver");
        String jdbcUrl = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);

        return DriverManager.getConnection(jdbcUrl, user, password);
    }


    public Connection demo2() throws Exception {

        Driver driver = new com.mysql.jdbc.Driver();


//1.注册驱动程序(可以注册多个驱动程序)


        DriverManager.registerDriver(driver);

//2.连接到具体的数据库

        Properties properties = new Properties();

        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");

        properties.load(in);

        String jdbcUrl = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Connection conn = DriverManager.getConnection(jdbcUrl, user, password);

        return conn;
    }

}
