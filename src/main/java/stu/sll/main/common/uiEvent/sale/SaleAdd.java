package stu.sll.main.common.uiEvent.sale;

import stu.sll.main.view.panel.SaleAddGUI;

import javax.swing.*;

/**
 * @Title: SaleAdd
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.sale
 * @Description: Add sale
 */

public class SaleAdd {
    public SaleAdd(JTable SaleTable) {
        // Create SaleAddGUI
        SaleAddGUI saleAddGUI = new SaleAddGUI(SaleTable);
        saleAddGUI.setVisible(true);
    }
}
