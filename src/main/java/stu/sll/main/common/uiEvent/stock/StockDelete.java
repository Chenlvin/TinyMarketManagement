package stu.sll.main.common.uiEvent.stock;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.database.operations.stock.DeleteStock;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @BelongsProject: MarketManagement
 * @BelongsPackage: stu.sll.main.common.uiEvent.stock
 * @Author: ZhouChenyi
 * @CreateTime: 2024-11-06  10:49
 * @Description: TODO
 * @Version: 1.0
 */

public class StockDelete {
    public StockDelete(int row, JTable ProductTable) {
        if(row == -1) { // 未选择行
            new DialogMsg("提示","请先选择需要操作的对象");
        } else {
            // 删除操作
            int selectedSid = (int) ProductTable.getValueAt(row, 0);
            try {
                DeleteStock.deleteStock(selectedSid);
            } catch (SQLException ex) {
                new DialogErr(ex.getMessage());
            }
        }
    }
}
