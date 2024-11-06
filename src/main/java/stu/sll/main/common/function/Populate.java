package stu.sll.main.common.function;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.database.operations
 * @Author: ZhouChenyi
 * @Description: 将List信息添加到JList
 * @Version: 1.0
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
