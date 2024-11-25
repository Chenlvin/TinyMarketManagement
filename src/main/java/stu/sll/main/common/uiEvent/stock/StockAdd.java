package stu.sll.main.common.uiEvent.stock;

import stu.sll.main.view.panel.StockAddGUI;

import javax.swing.*;

/**
 * @Title: StockAdd
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.stock
 * @Description: Add stock
 */

public class StockAdd {
    public StockAdd(JTable StockTable) {
        // 创建 StockAddGUI
        StockAddGUI stockAddGUI = new StockAddGUI(StockTable);
        stockAddGUI.setVisible(true);
    }
}
