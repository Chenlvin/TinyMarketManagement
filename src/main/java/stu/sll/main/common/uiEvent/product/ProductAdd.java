package stu.sll.main.common.uiEvent.product;

import stu.sll.main.view.panel.ProductAddGUI;

/**
 * @BelongsProject: MarketManagement
 * @BelongsPackage: stu.sll.main.common.uiEvent.product
 * @Author: ZhouChenyi
 * @CreateTime: 2024-11-05  16:30
 * @Description: TODO
 * @Version: 1.0
 */

public class ProductAdd {
    public ProductAdd() {
        // ProductAddGUI 添加商品方法需要打开 ProductAddGUI GUI
        ProductAddGUI productAddGUI = new ProductAddGUI();
        productAddGUI.setVisible(true);
    }
}
