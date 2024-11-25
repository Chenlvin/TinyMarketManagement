package stu.sll.main.common.uiEvent.stock;

import stu.sll.main.common.util.DialogErr;
import stu.sll.main.common.util.DialogMsg;
import stu.sll.main.database.operations.stock.DeleteStock;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @Title: DeleteStock
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.stock
 * @Description: Delete Stock
 */

public class StockDelete {
    public StockDelete(int row, JTable StockTable) {
        if(row == -1) { // 未选择行
            new DialogMsg("提示","请先选择需要操作的对象");
        } else {
            int flag = JOptionPane.showConfirmDialog(new JFrame(), "确认删除编号为 \"" + (int)StockTable.getValueAt(row, 0) + "\" 的库存信息吗？",
                    "提示", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if(JOptionPane.YES_OPTION == flag) {
                // 删除操作
                int selectedSid = (int) StockTable.getValueAt(row, 0);
                String selectedPName = (String) StockTable.getValueAt(row, 1);
                int quantity = (int) StockTable.getValueAt(row, 3);
                try {
                    DeleteStock.deleteStock(selectedSid, selectedPName, quantity);
                    new StockSearch("名称", "", StockTable);
                } catch (SQLException ex) {
                    new DialogErr(ex.getMessage());
                }
            }
        }
    }
}
