package stu.sll.main.common.uiEvent.stock;

import stu.sll.main.common.util.DialogErr;
import stu.sll.main.common.function.Populate;
import stu.sll.main.database.operations.stock.SearchStock;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @Title: StockSearch
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.uiEvent.stock
 * @Description: Search stock by keywords
 */

public class StockSearch {
    public StockSearch(String Type, String Keyword, JTable StockTable) {
        try {
            List<Object[]> results = SearchStock.searchStock(Type, Keyword);
            Populate.populateTable(results,StockTable); // 将结果填充到 JTable 中
        } catch (SQLException ex) {
            new DialogErr(ex.getMessage());
        }
    }
}
