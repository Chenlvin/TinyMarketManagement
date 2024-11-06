package stu.sll.main.common.uiEvent.product;

import stu.sll.main.view.panel.ProductAddGUI;

import javax.swing.*;

/**
 * @BelongsProject: MarketManagement
 * @BelongsPackage: stu.sll.main.common.uiEvent.product
 * @Author: ZhouChenyi
 * @Description: TODO
 */

public class ProductAdd {
    public ProductAdd(JTable productTable) {
        // ProductAddGUI 添加商品方法需要打开 ProductAddGUI GUI
        ProductAddGUI productAddGUI = new ProductAddGUI(productTable);
        productAddGUI.setVisible(true);
    }
}
