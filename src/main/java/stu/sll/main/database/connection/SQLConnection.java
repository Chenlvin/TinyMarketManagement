package stu.sll.main.database.connection;

import stu.sll.main.common.constants.ErrorMessage;
import stu.sll.main.common.constants.SqlConstant;
import stu.sll.main.common.util.LogUtil;

import java.sql.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.database
 * @Author: ZhouChenyi
 * @Description: 数据库连接
 */

public class SQLConnection {
    public static boolean databaseConnect() throws SQLException {
        // 加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            LogUtil.info("<JDBC Driver> 成功加载MySQL驱动");
        } catch (ClassNotFoundException ex) {
            LogUtil.error("<JDBC Driver> 加载MySQL驱动出错：" + ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        // 连接数据库
        try {
            DriverManager.getConnection(SqlConstant.getSqlUrl(), SqlConstant.getSqlUser(), SqlConstant.getSqlPwd());
            LogUtil.info("<Connection> 成功与数据库建立连接");
            return true;
        } catch (SQLException e) {
            LogUtil.error("<Connection> 连接数据库时出错：" + e.getMessage());
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
            LogUtil.info("成功关闭数据库连接");
        } catch (SQLException ex) {
            LogUtil.error(ex.getMessage());
        }
    }

    // 每次获取新的连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(SqlConstant.getSqlUrl(), SqlConstant.getSqlUser(), SqlConstant.getSqlPwd());
    }
}
