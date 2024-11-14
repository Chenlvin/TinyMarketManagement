package stu.sll.main.database.operations.sale;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: SearchSale
 * @Author Chenlvin
 * @Package stu.sll.main.database.operations.sale
 * @description: Search Sale
 */

public class SearchSale {
    public static List<Object[]> searchSale(String searchType, String keyword) throws SQLException {
        List<Object[]> saleList = new ArrayList<>();
        String query;

        if (searchType.equals("名称")) {
            LogUtil.info("执行销售订单查询（按名称）, Keyword=" + keyword);
            query = "SELECT s.Sale_id, p.Product_Name, t.Type_Name, p.price, s.Sale_quantity, s.Sale_time " +
                    "FROM sale s " +
                    "LEFT JOIN product p ON s.Pid = p.Pid " +
                    "LEFT JOIN type t ON p.Type = t.Type_id " +
                    "WHERE p.Product_Name LIKE ? " +
                    "GROUP BY p.Pid";

        } else { // "类别"
            LogUtil.info("执行销售订单查询（按类别）, Keyword=" + keyword);
            query = "SELECT s.Sale_id, p.Product_Name, t.Type_name, p.price, s.Sale_quantity, s.Sale_time " +
                    "FROM sale s " +
                    "LEFT JOIN product p ON s.Pid = p.Pid " +
                    "LEFT JOIN type t ON p.Type = t.Type_id " +
                    "WHERE t.Type_Name LIKE ? " +
                    "GROUP BY p.Pid";
        }

        try (PreparedStatement stmt = SQLConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int saleId = rs.getInt("Sale_id");
                String productName = rs.getString("Product_Name");
                String typeName = rs.getString("Type_name");
                double price = rs.getDouble("price");
                int saleQuantity = rs.getInt("Sale_quantity");
                Timestamp saleTime = rs.getTimestamp("Sale_time");
                saleList.add(new Object[]{saleId, productName, typeName, price, saleQuantity, saleTime});
            }
        } catch (SQLException ex) {
            LogUtil.error("查找出错：" + ex.getMessage());
            new DialogErr("查找时出错，错误信息：" + ex.getMessage());
        }
        return saleList;
    }
}
