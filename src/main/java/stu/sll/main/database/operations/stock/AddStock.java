package stu.sll.main.database.operations.stock;

import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.*;

/**
 * @Title: AddStock
 * @Author: Chenlvin
 * @Package: stu.sll.main.database.operations.stock
 * @Description: Add stock in database
 */

public class AddStock {
    public static boolean addStock(int pid, int quantity, Timestamp datetime) throws SQLException {
        LogUtil.info("开始执行入库信息添加操作, pid=" + pid + ", quantity=" + quantity + ", datetime=" + datetime);
        String query = "INSERT INTO stock (Pid, Stock_quantity, Stock_time) VALUES (?, ?, ?)";
        String queryToProduct = "UPDATE product set Stock_Left=Stock_Left+? WHERE Pid=?";

        try (Connection connection = SQLConnection.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement stmt = connection.prepareStatement(query);
                 PreparedStatement stmt_to_product = connection.prepareStatement(queryToProduct)) {

                stmt.setInt(1, pid);
                stmt.setInt(2, quantity);
                stmt.setTimestamp(3, datetime);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    // 更新商品库存
                    stmt_to_product.setInt(1, quantity);
                    stmt_to_product.setInt(2, pid);
                    stmt_to_product.executeUpdate();

                    // 提交事务
                    connection.commit();
                    LogUtil.info("成功添加入库信息");
                    return true;
                } else {
                    throw new SQLException("没有插入任何库存数据");
                }
            } catch (SQLException ex) {
                connection.rollback();
                LogUtil.error("添加入库信息时出错：" + ex.getMessage());
                throw new SQLException(ex.getMessage());
            }
        } catch (SQLException ex) {
            LogUtil.error(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }
}
