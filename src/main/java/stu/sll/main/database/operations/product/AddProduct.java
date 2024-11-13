package stu.sll.main.database.operations.product;

import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.database.operations
 * @Author: ZhouChenyi
 * @Description: Add Product to product
 */

public class AddProduct {

    public static boolean addProduct(String name, int typeId, double price) throws SQLException {
        String query0 = "ALTER TABLE product AUTO_INCREMENT=0";
        String query = "INSERT INTO Product (Product_name, Type, Price) VALUES (?, ?, ?)";

        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);PreparedStatement stmt2 = connection.prepareStatement(query0)) {

            stmt.setString(1, name);
            stmt.setInt(2, typeId);
            stmt.setDouble(3, price);
            stmt2.executeUpdate();
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                LogUtil.info("成功添加商品");
                return true;
            } else {
                throw new SQLException("0 条数据受影响");
            }
        } catch (SQLException ex) {
            LogUtil.error("添加商品时出错：" + ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }
}
