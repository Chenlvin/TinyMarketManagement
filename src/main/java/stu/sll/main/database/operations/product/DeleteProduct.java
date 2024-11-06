package stu.sll.main.database.operations.product;

import com.mysql.cj.log.Log;
import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.database.operations
 * @Author: ZhouChenyi
 * @Description: Delete Product
 * @Version: 1.0
 */

public class DeleteProduct {
    public static void deleteProduct(int pid) throws SQLException {
        LogUtil.info("开始执行删除操作，pid=" + pid);
        String query = "DELETE FROM Product WHERE Pid = ?";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pid);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LogUtil.info("商品删除成功");
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
