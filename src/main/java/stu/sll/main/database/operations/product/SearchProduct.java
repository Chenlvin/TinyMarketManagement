package stu.sll.main.database.operations.product;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.database.operations
 * @Author: ZhouChenyi
 * @Description: Search Product
 */

public class SearchProduct {
    public static List<Object[]> searchProduct(String searchType, String keyword) throws SQLException {
        List<Object[]> productList = new ArrayList<>();
        String query;

        if (searchType.equals("名称")) {
            query = "SELECT p.Pid, p.Product_Name, t.Type_Name, p.Price, p.Stock_Left " +
                    "FROM Product p " +
                    "LEFT JOIN Stock s ON p.Pid = s.Pid " +
                    "LEFT JOIN type t ON p.Type = t.Type_id " +
                    "WHERE p.Product_name LIKE ? " +
                    "GROUP BY p.Pid";
        } else { // "类别"
            query = "SELECT p.Pid, p.Product_name, t.Type_name, p.Price, p.Stock_Left " +
                    "FROM Product p " +
                    "LEFT JOIN Stock s ON p.Pid = s.Pid " +
                    "LEFT JOIN type t ON p.Type = t.Type_id " +
                    "WHERE t.Type_name LIKE ? " +
                    "GROUP BY p.Pid";
        }

        try (PreparedStatement stmt = SQLConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("Pid");
                String productName = rs.getString("Product_name");
                String typeName = rs.getString("Type_name");
                double price = rs.getDouble("Price");
                int stockLeft = rs.getInt("Stock_Left");
                productList.add(new Object[]{productId, productName, typeName, price, stockLeft});
            }
        } catch (SQLException ex) {
            LogUtil.error("Search 时出错：" + ex.getMessage());
            new DialogErr("查找时出错，错误信息：" + ex.getMessage());
        }
        return productList;
    }
}


