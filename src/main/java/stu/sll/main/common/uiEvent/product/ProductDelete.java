package stu.sll.main.common.uiEvent.product;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.database.operations.product.DeleteProduct;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.uiEvent.product
 * @Author: ZhouChenyi
 * @Description: Product Deelete
 */

public class ProductDelete {
    public ProductDelete(int row, JTable ProductTable) {
        if(row == -1) { // 未选择行
            new DialogMsg("提示","请先选择需要操作的对象");
        } else {
            // 删除操作
            int selectedPid = (int) ProductTable.getValueAt(row, 0);
            try {
                DeleteProduct.deleteProduct(selectedPid);
                new ProductSearch("名称", "", ProductTable);
            } catch (SQLException ex) {
                new DialogErr(ex.getMessage());
            }
        }
    }
}
