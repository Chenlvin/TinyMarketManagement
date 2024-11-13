package stu.sll.main.common.uiEvent.stock;

import stu.sll.main.view.panel.StockAddGUI;

import javax.swing.*;

/**
 * @BelongsProject: MarketManagement
 * @BelongsPackage: stu.sll.main.common.uiEvent.stock
 * @Author: ZhouChenyi
 * @Description: Stock Add
 */

public class StockAdd {
    public StockAdd(JTable StockTable) {
        // 创建 StockAddGUI
        StockAddGUI stockAddGUI = new StockAddGUI(StockTable);
        stockAddGUI.setVisible(true);
    }
}
