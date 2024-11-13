package stu.sll.main.common.uiEvent.stock;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.common.uiEvent.product.ProductSearch;
import stu.sll.main.database.operations.stock.DeleteStock;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @BelongsProject: MarketManagement
 * @BelongsPackage: stu.sll.main.common.uiEvent.stock
 * @Author: ZhouChenyi
 * @Description: Stock Delete
 */

public class StockDelete {
    public StockDelete(int row, JTable StockTable) {
        if(row == -1) { // 未选择行
            new DialogMsg("提示","请先选择需要操作的对象");
        } else {
            // 删除操作
            int selectedSid = (int) StockTable.getValueAt(row, 0);
            try {
                DeleteStock.deleteStock(selectedSid);
                new StockSearch("名称", "", StockTable);
            } catch (SQLException ex) {
                new DialogErr(ex.getMessage());
            }
        }
    }
}
