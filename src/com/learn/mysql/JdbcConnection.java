package com.learn.mysql;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnection {
    private final String driverClass = "com.mysql.jdbc.Driver";
    private final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test";
    private final String username = "root";
    private final String password = "mysql";

//    方式一：通过驱动driver类来连接数据库

    @Test
    public void demo1() {
        try {
            Driver driver = new Driver();

            Properties properties = new Properties();

            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");

            properties.load(inputStream);

            Connection connect = driver.connect(jdbcUrl, properties);

            Statement statement = connect.createStatement();
            String sql="insert into hah values(4,'zhangsan')";
            boolean execute = statement.execute(sql);
            System.out.println(execute);
            System.out.println(connect);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式二：通过反射Driver，加载Driver里面的静态代码块，实现自动注册Driver，在DriverManager连接数据库
    @Test
    public void demo2() {
        try {
            Class.forName(driverClass);
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   //方式三：通过DriverManager，注册Driver，来连接数据库(和class.forName相同)
    @Test
    public void demo3(){
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //直接使用DriverManager获取数据库连接。
    @Test
    public void demo4(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("delete from hah where id=3");
            System.out.println(connection);
            System.out.println(execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
