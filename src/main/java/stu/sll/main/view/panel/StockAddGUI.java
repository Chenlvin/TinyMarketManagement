/*
 * Created by JFormDesigner on Tue Nov 05 17:53:34 CST 2024
 */

package stu.sll.main.view.panel;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.common.uiEvent.stock.StockSearch;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.operations.stock.AddStock;

import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * @author Zhou Chenlvin
 */
public class StockAddGUI extends JFrame {
    // 定义时间格式
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    JTable StockTable;

    public StockAddGUI(JTable StockTable) {
        initComponents();
        this.StockTable = StockTable;
        String currentTime = dateformat.format(new Timestamp(System.currentTimeMillis()));
        textfield_datetime.setText(currentTime);
    }

    private void AddButton(ActionEvent e) {
        if (textfield_pid.getText().trim().equals("") || textfield_quantity.getText().trim().equals("") || textfield_datetime.getText().trim().equals("")) {
            new DialogErr("\"入库商品编号\"、\"数量\"和\"\"入库时间\"\" 不能为空!");
            return;
        }
        try {
            int pid = Integer.parseInt(textfield_pid.getText());
            int quantity = Integer.parseInt(textfield_quantity.getText());
            Timestamp datetime = textfield_datetime.getText().trim().isEmpty() ? null : Timestamp.valueOf(textfield_datetime.getText().trim());
            LogUtil.info("添加入库信息：" + pid + "\t" + quantity + "\t" + datetime);
            boolean succ = false;
            succ = AddStock.addStock(pid, quantity, datetime);
            if (succ) {
                this.setVisible(false);
                this.removeAll();
                new StockSearch("名称", "", StockTable);
                new DialogMsg("提示", "添加成功");
            }
        } catch (Exception ex) {
            new DialogErr("添加入库信息时出错：" + ex.getMessage());
        }
    }

    private void GetTime(ActionEvent e) {
        // 获取当前时间，并填入对应 textfield
        String currentTime = dateformat.format(new Timestamp(System.currentTimeMillis()));
        textfield_datetime.setText(currentTime);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        AddLabel = new JLabel();
        nameLabel = new JLabel();
        typeidLabel = new JLabel();
        priceLabel = new JLabel();
        textfield_pid = new JTextField();
        textfield_quantity = new JTextField();
        textfield_datetime = new JTextField();
        AddButton = new JButton();
        GetTimeButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- AddLabel ----
        AddLabel.setText("\u589e\u52a0\u5165\u5e93\u4fe1\u606f");
        AddLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(AddLabel);
        AddLabel.setBounds(20, 10, 180, 40);

        //---- nameLabel ----
        nameLabel.setText("\u5165\u5e93\u5546\u54c1\u7f16\u53f7");
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(nameLabel);
        nameLabel.setBounds(35, 95, 191, nameLabel.getPreferredSize().height);

        //---- typeidLabel ----
        typeidLabel.setText("\u5165\u5e93\u6570\u91cf");
        typeidLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        typeidLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(typeidLabel);
        typeidLabel.setBounds(80, 145, 146, 24);

        //---- priceLabel ----
        priceLabel.setText("\u5165\u5e93\u65f6\u95f4");
        priceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(priceLabel);
        priceLabel.setBounds(80, 195, 146, 24);
        contentPane.add(textfield_pid);
        textfield_pid.setBounds(235, 90, 160, 35);
        contentPane.add(textfield_quantity);
        textfield_quantity.setBounds(235, 140, 160, 35);
        contentPane.add(textfield_datetime);
        textfield_datetime.setBounds(235, 190, 160, 35);

        //---- AddButton ----
        AddButton.setText("\u6dfb\u52a0");
        AddButton.addActionListener(e -> AddButton(e));
        contentPane.add(AddButton);
        AddButton.setBounds(250, 290, 93, 40);

        //---- GetTimeButton ----
        GetTimeButton.setText("\u83b7\u53d6\u5f53\u524d\u65f6\u95f4");
        GetTimeButton.addActionListener(e -> GetTime(e));
        contentPane.add(GetTimeButton);
        GetTimeButton.setBounds(395, 190, 155, 35);

        contentPane.setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel AddLabel;
    private JLabel nameLabel;
    private JLabel typeidLabel;
    private JLabel priceLabel;
    private JTextField textfield_pid;
    private JTextField textfield_quantity;
    private JTextField textfield_datetime;
    private JButton AddButton;
    private JButton GetTimeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
