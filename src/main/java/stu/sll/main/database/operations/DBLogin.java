package stu.sll.main.database.operations;

import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.database.operations
 * @Author: ZhouChenyi
 * @Description: TODO
 * @Version: 1.1
 */

public class DBLogin {
    public static boolean dbLogin(String username, String password) throws SQLException {
        try {
            LogUtil.info("查询登录用户名与密码");
            String query = "SELECT COUNT(*) FROM user WHERE Username = ? AND Password = ?";
            Connection conn = SQLConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // 登录成功
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            throw new SQLException("登录时出错：" + ex.getMessage())  ;
        }
    }
}
