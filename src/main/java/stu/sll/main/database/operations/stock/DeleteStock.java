package stu.sll.main.database.operations.stock;

import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @BelongsProject: MarketManagement
 * @BelongsPackage: stu.sll.main.database.operations.stock
 * @Author: ZhouChenyi
 * @CreateTime: 2024-11-06  10:49
 * @Description: TODO
 * @Version: 1.0
 */

public class DeleteStock {
    public static void deleteStock(int sid, String PName, int quantity) throws SQLException {
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
                    new DialogMsg("提示", "删除成功");
                } else {
                    connection.rollback();
                    LogUtil.info("未能找到要删除的商品");
                    new DialogMsg("提示", "未能找到该商品，请刷新商品列表。");
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
