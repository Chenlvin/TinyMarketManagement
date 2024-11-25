package stu.sll.main.common.uiEvent.product;

import stu.sll.main.view.panel.ProductAddGUI;

import javax.swing.*;

/**
 * @Title: ProductAdd
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.product
 * @Description: Add product
 */

public class ProductAdd {
    public ProductAdd(JTable productTable) {
        // ProductAddGUI 添加商品方法需要打开 ProductAddGUI GUI
        ProductAddGUI productAddGUI = new ProductAddGUI(productTable);
        productAddGUI.setVisible(true);
    }
}
