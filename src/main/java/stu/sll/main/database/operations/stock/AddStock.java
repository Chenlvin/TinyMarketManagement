package stu.sll.main.database.operations.stock;

import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.database.operations.stock
 * @Author: ZhouChenyi
 * @Description: Add Stock
 * @Version: 1.0
 */

public class AddStock {
    public static boolean addStock(int pid, int quantity, Timestamp datetime) throws SQLException {
        String query0 = "ALTER TABLE stock AUTO_INCREMENT=0";
        String query = "INSERT INTO stock (Pid, Stock_quantity, Stock_time) VALUES (?, ?, ?)";
        String queryToProduct = "UPDATE product set Stock_Left=Stock_Left+? WHERE Pid=?";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             PreparedStatement stmt2 = connection.prepareStatement(query0);
             PreparedStatement stmt_to_product = connection.prepareStatement(queryToProduct)) {
            stmt2.executeUpdate();

            stmt_to_product.setInt(1,quantity);
            stmt_to_product.setInt(2,pid);

            stmt.setInt(1, pid);
            stmt.setInt(2, quantity);
            stmt.setTimestamp(3, datetime);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                stmt_to_product.executeUpdate();
                LogUtil.info("成功添加入库信息");
                return true;
            } else {
                throw new SQLException("0 条数据受影响");
            }
        } catch (SQLException ex) {
            LogUtil.error("添加入库信息时出错：" + ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }
}
