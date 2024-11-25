/*
 * Created by JFormDesigner on Sat Nov 16 12:25:07 CST 2024
 */

package stu.sll.main.view.panel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import javax.swing.*;

import static stu.sll.main.common.constants.Constant.dateFormat;

/**
 * @author Zhou Chenlvin
 */
public class SaleAddGUI extends JFrame {
    public SaleAddGUI(JTable SaleTable) {
        initComponents();
    }

    private void AddButton(ActionEvent e) {
        // TODO add your code here
    }

    private void GetTime(ActionEvent e) {
        String currentTime = dateFormat.format(new Timestamp(System.currentTimeMillis()));
        textfield_datetime.setText(currentTime);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        Label = new JLabel();
        pidLabel = new JLabel();
        priceLabel = new JLabel();
        textlabel_name = new JTextField();
        textlabel_price = new JTextField();
        button2 = new JButton();
        priceLabel2 = new JLabel();
        textfield_datetime = new JTextField();
        GetTimeButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Label ----
        Label.setText("\u589e\u52a0\u9500\u552e\u8ba2\u5355");
        Label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(Label);
        Label.setBounds(20, 10, 180, 40);

        //---- pidLabel ----
        pidLabel.setText("\u5546\u54c1\u7f16\u53f7");
        pidLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        pidLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(pidLabel);
        pidLabel.setBounds(80, 95, 146, pidLabel.getPreferredSize().height);

        //---- priceLabel ----
        priceLabel.setText("\u9500\u552e\u6570\u91cf");
        priceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(priceLabel);
        priceLabel.setBounds(80, 155, 146, 24);
        contentPane.add(textlabel_name);
        textlabel_name.setBounds(235, 90, 200, 35);
        contentPane.add(textlabel_price);
        textlabel_price.setBounds(235, 150, 100, 35);

        //---- button2 ----
        button2.setText("\u6dfb\u52a0");
        button2.addActionListener(e -> AddButton(e));
        contentPane.add(button2);
        button2.setBounds(250, 290, 93, 40);

        //---- priceLabel2 ----
        priceLabel2.setText("\u8ba2\u5355\u751f\u6210\u65f6\u95f4");
        priceLabel2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        priceLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(priceLabel2);
        priceLabel2.setBounds(80, 215, 146, 24);
        contentPane.add(textfield_datetime);
        textfield_datetime.setBounds(235, 210, 160, 35);

        //---- GetTimeButton ----
        GetTimeButton.setText("\u83b7\u53d6\u5f53\u524d\u65f6\u95f4");
        GetTimeButton.addActionListener(e -> GetTime(e));
        contentPane.add(GetTimeButton);
        GetTimeButton.setBounds(395, 210, 155, 35);

        contentPane.setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel Label;
    private JLabel pidLabel;
    private JLabel priceLabel;
    private JTextField textlabel_name;
    private JTextField textlabel_price;
    private JButton button2;
    private JLabel priceLabel2;
    private JTextField textfield_datetime;
    private JButton GetTimeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
