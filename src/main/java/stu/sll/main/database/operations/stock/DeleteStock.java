package stu.sll.main.database.operations.stock;

import stu.sll.main.common.util.DialogMsg;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: DeleteStock
 * @Author: Chenlvin
 * @Package: stu.sll.main.database.operations.stock
 * @Description: Delete stock in database
 */

public class DeleteStock {
    public static boolean deleteStock(int sid, String PName, int quantity) throws SQLException {
        LogUtil.info("开始执行入库信息删除操作，Sid=" + sid);
        String queryStock = "DELETE FROM stock WHERE Stock_id = ?";
        String queryProduct = "UPDATE product SET Stock_left = Stock_left - ? WHERE Product_Name = ?";

        try (Connection connection = SQLConnection.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement stmt = connection.prepareStatement(queryStock);
                 PreparedStatement pstmt = connection.prepareStatement(queryProduct)) {

                stmt.setInt(1, sid);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    pstmt.setInt(1, quantity);
                    pstmt.setString(2, PName);
                    pstmt.executeUpdate();

                    connection.commit();
                    LogUtil.info("成功删除入库信息: Stock_id=" + sid);
                    return true;
                } else {
                    connection.rollback();
                    LogUtil.info("未能找到要删除的商品");
                    return false;
                }
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
        } catch (SQLException ex) {
            LogUtil.error(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }
}
