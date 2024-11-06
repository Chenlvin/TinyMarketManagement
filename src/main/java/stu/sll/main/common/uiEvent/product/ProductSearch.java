package stu.sll.main.common.uiEvent.product;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.function.Populate;
import stu.sll.main.database.operations.product.SearchProduct;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.uiEvent.product
 * @Author: ZhouChenyi
 * @CreateTime: 2024-11-04  17:04
 * @Description: TODO
 * @Version: 1.0
 */

public class ProductSearch {
    public ProductSearch(String Type, String Keyword, JTable ProductTable) {
        try {
            List<Object[]> results = SearchProduct.searchProduct(Type, Keyword);
            Populate.populateTable(results,ProductTable); // 将结果填充到 JTable 中
        } catch (SQLException ex) {
            new DialogErr(ex.getMessage());
        }
    }
}
