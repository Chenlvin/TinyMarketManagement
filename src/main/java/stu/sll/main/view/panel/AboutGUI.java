/*
 * Created by JFormDesigner on Fri Nov 01 20:23:46 CST 2024
 */

package stu.sll.main.view.panel;

import stu.sll.main.sys.SysConstant;

import java.awt.*;
import javax.swing.*;

/**
 * @author Zhou Chenlvin
 */
public class AboutGUI extends JFrame {
    public AboutGUI() {
        initComponents();
        setResizable(false);
    }
    private final String VERSION = SysConstant.VERSION + "(" + SysConstant.VER_NUM + ")";
    private final String DESCRIPTION = SysConstant.DESCRIPTION;
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        separator1 = new JSeparator();
        version = new JLabel();
        description = new JLabel();

        //======== this ========
        setTitle("About");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5173 \u4e8e");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label1);
        label1.setBounds(215, 10, 95, 30);
        contentPane.add(separator1);
        separator1.setBounds(0, 50, 530, 10);

        //---- version ----
        version.setText("Version");
        version.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(version);
        version.setBounds(0, 70, 525, version.getPreferredSize().height);

        //---- description ----
        description.setText("text");
        description.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(description);
        description.setBounds(0, 100, 525, description.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(525, 310));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JSeparator separator1;
    private JLabel version;
    private JLabel description;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
