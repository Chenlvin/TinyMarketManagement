package stu.sll.main.common.uiEvent.product;

import stu.sll.main.common.util.DialogErr;
import stu.sll.main.common.util.DialogMsg;
import stu.sll.main.database.operations.product.DeleteProduct;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @Title: ProductDelete
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.product
 * @Description: Delete product
 */

public class ProductDelete {
    public ProductDelete(int row, JTable ProductTable) {
        if(row == -1) { // 未选择行
            new DialogMsg("提示","请先选择需要操作的对象");
        } else {
            int flag = JOptionPane.showConfirmDialog(new JFrame(), "确认删除商品 \"" + ProductTable.getValueAt(row, 1) + "\" 吗？",
                    "提示", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if(JOptionPane.YES_OPTION == flag){
                // 点击确认，执行删除操作
                int selectedPid = (int) ProductTable.getValueAt(row, 0);
                try {
                    boolean succ = DeleteProduct.deleteProduct(selectedPid);
                    if(succ) { new DialogMsg("提示","删除成功"); }
                    else { new DialogMsg("提示","未能找到该商品，请刷新商品列表。"); }
                    new ProductSearch("名称", "", ProductTable);
                } catch (SQLException ex) {
                    new DialogErr(ex.getMessage());
                }
            }
        }
    }
}
