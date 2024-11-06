package stu.sll.main.database.connection;

import stu.sll.main.common.constants.ErrorMessage;
import stu.sll.main.common.constants.SqlConstant;
import java.sql.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.database
 * @Author: ZhouChenyi
 * @Description: 数据库连接
 * @Version: 1.1
 */

public class SQLConnection {
    public static boolean databaseConnect() throws SQLException {
        // 加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("<JDBC Driver> 成功加载MySQL驱动");
        } catch (ClassNotFoundException ex) {
            System.err.println("<JDBC Driver> 加载MySQL驱动出错：" + ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        // 连接数据库
        try {
            DriverManager.getConnection(SqlConstant.getSqlUrl(), SqlConstant.getSqlUser(), SqlConstant.getSqlPwd());
            System.out.println("<Connection> 成功与数据库建立连接");
            return true;
        } catch (SQLException e) {
            System.err.println("<Connection> 连接数据库时出错：" + e.getMessage());
            throw new SQLException(ErrorMessage.SQL_CONNECT_ERROR);
        }
    }

    public static void Close(Connection conn, Statement stmt) throws SQLException {
        try {
            if (stmt != null) {
                stmt.close(); // 关闭语句
            }
            if (conn != null) {
                conn.close(); // 关闭连接
            }
            System.out.println("成功关闭数据库连接");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // 每次获取新的连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(SqlConstant.getSqlUrl(), SqlConstant.getSqlUser(), SqlConstant.getSqlPwd());
    }
}
