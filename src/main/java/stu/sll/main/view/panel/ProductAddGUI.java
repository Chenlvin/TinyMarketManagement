/*
 * Created by JFormDesigner on Sat Nov 02 12:40:37 CST 2024
 */

package stu.sll.main.view.panel;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.database.operations.product.AddProduct;
import stu.sll.main.view.dialog.ErrorDialogGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Zhou Chenlvin
 */
public class ProductAddGUI extends JFrame {
    public ProductAddGUI() {
        initComponents();
        setResizable(false);
    }

    private void AddButton(ActionEvent e) {
        if (textlabel_name.getText().trim().equals("") || textlabel_typeid.getText().trim().equals("") || textlabel_price.getText().trim().equals("")) {
            new DialogErr("名称、编号、价格不能为空!");
            return;
        }
        try {
            String pname = textlabel_name.getText();
            int typeid = Integer.parseInt(textlabel_typeid.getText());
            double price = Double.parseDouble(textlabel_price.getText());
            System.out.println("添加商品：" + pname + "\t" + typeid + "\t" + price);
            boolean succ = false;
            succ = AddProduct.addProduct(pname, typeid, price);
            if (succ) {
                this.setVisible(false);
                this.removeAll();
                new DialogMsg("提示", "添加成功");
            }
        } catch (Exception ex) {
            ErrorDialogGUI errorDialogGUI = new ErrorDialogGUI("添加商品时出错：" + ex.getMessage());
            errorDialogGUI.setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        AddLabel = new JLabel();
        nameLabel = new JLabel();
        typeidLabel = new JLabel();
        priceLabel = new JLabel();
        textlabel_name = new JTextField();
        textlabel_typeid = new JTextField();
        textlabel_price = new JTextField();
        label4 = new JLabel();
        label6 = new JLabel();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- AddLabel ----
        AddLabel.setText("\u6dfb\u52a0\u5546\u54c1");
        AddLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(AddLabel);
        AddLabel.setBounds(20, 10, 180, 40);

        //---- nameLabel ----
        nameLabel.setText("\u5546\u54c1\u540d\u79f0");
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(nameLabel);
        nameLabel.setBounds(80, 95, 146, nameLabel.getPreferredSize().height);

        //---- typeidLabel ----
        typeidLabel.setText("\u5206\u7c7b\u7f16\u53f7");
        typeidLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        typeidLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(typeidLabel);
        typeidLabel.setBounds(80, 145, 146, 24);

        //---- priceLabel ----
        priceLabel.setText("\u9500\u552e\u4ef7\u683c");
        priceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(priceLabel);
        priceLabel.setBounds(80, 195, 146, 24);
        contentPane.add(textlabel_name);
        textlabel_name.setBounds(235, 90, 200, 35);

        //---- textlabel_typeid ----
        textlabel_typeid.setText("1");
        contentPane.add(textlabel_typeid);
        textlabel_typeid.setBounds(235, 140, 60, 35);
        contentPane.add(textlabel_price);
        textlabel_price.setBounds(235, 190, 100, 35);

        //---- label4 ----
        label4.setText("\u5206\u7c7b1 \u4e3a \u201c\u672a\u5206\u7c7b\u201d ");
        contentPane.add(label4);
        label4.setBounds(310, 150, 210, label4.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u652f\u6301\u4e24\u4f4d\u5c0f\u6570");
        contentPane.add(label6);
        label6.setBounds(350, 200, 170, 17);

        //---- button2 ----
        button2.setText("\u6dfb\u52a0");
        button2.addActionListener(e -> AddButton(e));
        contentPane.add(button2);
        button2.setBounds(250, 290, 93, 40);

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
    private JTextField textlabel_name;
    private JTextField textlabel_typeid;
    private JTextField textlabel_price;
    private JLabel label4;
    private JLabel label6;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
