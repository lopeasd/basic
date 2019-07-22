package com.learn.mysql;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpExample {

    //DBCP不使用配置文件
    @Test
    public void dbcpDemo1() {
        try {
            //1. 构建数据源对象
            BasicDataSource dataSource = new BasicDataSource();
            //连的是什么类型的数据库， 访问的是哪个数据库 ， 用户名， 密码。。
            //jdbc:mysql://localhost/bank 主协议：子协议 ://本地/数据库
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost/test");
            dataSource.setUsername("root");
            dataSource.setPassword("mysql");
            //2. 得到连接对象
            Connection conn = dataSource.getConnection();
            String sql = "insert into hah values(5 ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            // parameterIndex the first parameter is 1, the second is 2, ...
            ps.setString(1, "admin");
            int i = ps.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //DBCP使用配置文件
    @Test
    public void dbcpDemo2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            BasicDataSourceFactory factory = new BasicDataSourceFactory();
            Properties properties = new Properties();
            InputStream is = new FileInputStream("src//dbcp.properties");
            properties.load(is);
            DataSource dataSource = factory.createDataSource(properties);

            //2. 得到连接对象
            conn = dataSource.getConnection();
            String sql = "insert into hah values(6 , ? )";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "properties");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if ((conn != null)) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
