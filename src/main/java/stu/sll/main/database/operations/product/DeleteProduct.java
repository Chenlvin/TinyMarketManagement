package stu.sll.main.database.operations.product;

import stu.sll.main.common.util.DialogMsg;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: DeleteProduct
 * @Author: Chenlvin
 * @Package: stu.sll.main.database.operations.product
 * @Description: Delete product in database
 */

public class DeleteProduct {
    public static boolean deleteProduct(int pid) throws SQLException {
        LogUtil.info("开始执行删除操作，pid=" + pid);
        String query = "DELETE FROM Product WHERE Pid = ?";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pid);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LogUtil.info("商品删除成功");
                return true;
            } else {
                LogUtil.info("未能找到要删除的商品");
                return false;
            }
        } catch (SQLException ex) {
            LogUtil.error("删除失败：" + ex.getMessage());
            throw new SQLException("删除失败：" + ex.getMessage());
        }
    }

}
