package stu.sll.main.common.function;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @Title: Populate
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.function
 * @Description: Populate List object content to JTable
 */

public class Populate {
    public static void populateTable(List<Object[]> productList, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // 清空现有数据
        for (Object[] product : productList) {
            model.addRow(product); // 将每一行数据添加到表格中
        }
    }
}
