package stu.sll.main.common.uiEvent.product;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.function.Populate;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.operations.product.SearchProduct;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.uiEvent.product
 * @Author: ZhouChenyi
 * @Description: Product Search
 */

public class ProductSearch {
    public ProductSearch(String Type, String Keyword, JTable ProductTable) {
        try {
            List<Object[]> results = SearchProduct.searchProduct(Type, Keyword);
            Populate.populateTable(results,ProductTable); // 将结果填充到 JTable 中
        } catch (SQLException ex) {
            LogUtil.error(ex.getMessage());
            new DialogErr(ex.getMessage());
        }
    }
}
