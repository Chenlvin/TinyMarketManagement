package stu.sll.main.database.operations.stock;

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
 * @BelongsPackage: main.common.database.operations
 * @Author: ZhouChenyi
 * @Description: Search // 查找功能
 * @Version: 1.4
 */

public class SearchStock {
    public static List<Object[]> searchStock(String searchType, String keyword) throws SQLException {
        List<Object[]> stockList = new ArrayList<>();
        String query;

        // 根据商品名称或类别查询库存信息
        if (searchType.equals("商品名称")) {
            LogUtil.info("执行入库信息查询（按名称）, Keyword=" + keyword);
            query = "SELECT s.Stock_id, p.Product_name, t.Type_name, s.Stock_quantity, s.Stock_time " +
                    "FROM stock s " +
                    "LEFT JOIN product p ON s.Pid = p.Pid " +
                    "LEFT JOIN type t ON p.Type = t.Type_id " +
                    "WHERE p.Product_name LIKE ?";
        } else { // "商品类别"
            LogUtil.info("执行入库信息查询（按类别）, Keyword=" + keyword);
            query = "SELECT s.Stock_id, p.Product_name, t.Type_name, s.Stock_quantity, s.Stock_time " +
                    "FROM stock s " +
                    "LEFT JOIN product p ON s.Pid = p.Pid " +
                    "LEFT JOIN type t ON p.Type = t.Type_id " +
                    "WHERE t.Type_Name LIKE ?";
        }

        try (PreparedStatement stmt = SQLConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            // 处理查询结果
            while (rs.next()) {
                int stockId = rs.getInt("Stock_id");
                String productName = rs.getString("Product_name");
                String typeName = rs.getString("Type_name");
                int stockQuantity = rs.getInt("Stock_quantity");
                Timestamp stockTime = rs.getTimestamp("Stock_time");
                stockList.add(new Object[]{stockId, productName, typeName, stockQuantity, stockTime});
            }
        } catch (SQLException ex) {
            LogUtil.error("SearchStock 时出错：" + ex.getMessage());
            new DialogErr("查找时出错，错误信息：" + ex.getMessage());
        }
        return stockList;
    }
}



