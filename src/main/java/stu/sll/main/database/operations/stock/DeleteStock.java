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
    public static void deleteStock(int sid) throws SQLException {
        LogUtil.info("开始执行入库信息删除操作，Sid=" + sid);
        String query = "DELETE FROM stock WHERE Stock_id = ?";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, sid);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LogUtil.info("成功删除入库信息: Stock_id=" + sid);
                new DialogMsg("提示","删除成功");
            } else {
                LogUtil.info("未能找到要删除的商品");
                new DialogMsg("提示","未能找到该商品，请刷新商品列表。");
            }
        } catch (SQLException ex) {
            LogUtil.error("删除失败：" + ex.getMessage());
            throw new SQLException("删除失败：" + ex.getMessage());
        }
    }
}
