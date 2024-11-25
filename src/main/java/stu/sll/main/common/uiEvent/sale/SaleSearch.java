package stu.sll.main.common.uiEvent.sale;

import stu.sll.main.common.util.DialogErr;
import stu.sll.main.common.function.Populate;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.operations.sale.SearchSale;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Title: SaleSearch
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.sale
 * @Description: Search sale by keywords
 */

public class SaleSearch {
    public SaleSearch(String Type, String Keyword, JTable SaleTable) {
        try {
            List<Object[]> results = SearchSale.searchSale(Type, Keyword);
            Populate.populateTable(results,SaleTable); // 将结果填充到 JTable 中
        } catch (SQLException ex) {
            LogUtil.error(ex.getMessage());
            new DialogErr(ex.getMessage());
        }
    }
}
