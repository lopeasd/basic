# 1.遇到的常见问题

### 1.stmt.execute(sql);执行成功为什么反回false(PreparedStatement一样)
>execute 方法返回一个 boolean 值，以指示第一个结果的形式。必须调用 getResultSet 或 getUpdateCount 方法来检索结果，并且必须调用 getMoreResults 移动到任何后面的结果。 
返回：
如果第一个结果是 ResultSet 对象，则返回 true；如果第一个结果是更新计数或者没有结果，则返回 false

>意思就是如果是查询的话返回true，如果是更新或插入的话就返回false了；
    更新语句应该为
            stmt.executeUpdate(sql);

    Driver driver = new com.mysql.jdbc.Driver();
    Driver driver = (Driver) Class.forName(driverClass).newInstance();

 1.
     Driver driver = new com.mysql.jdbc.Driver();
     driver.connect(jdbcUrl, info);

 2.可以注册多个驱动
     Class.forName("com.mysql.jdbc.Driver");
     DriverManager.getConnection(jdbcUrl, user, password);

 3.注册两次，可以注册多个驱动
     Driver driver = new com.mysql.jdbc.Driver();
     DriverManager.registerDriver(driver);
     DriverManager.getConnection(jdbcUrl, user, password);



