/*
 * Created by JFormDesigner on Thu Nov 14 19:36:04 CST 2024
 */

package stu.sll.main.view.dialog;

import java.awt.*;
import javax.swing.*;

/**
 * @author Zhou Chenlvin
 */
public class Loading extends JDialog {
    public Loading(String message) {
        initComponents();
        this.Message.setText(message);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        Message = new JLabel();

        //======== this ========
        setAlwaysOnTop(true);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Message ----
        Message.setText("MESSAGE");
        Message.setHorizontalAlignment(SwingConstants.CENTER);
        Message.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(Message);
        Message.setBounds(0, 50, 400, 20);

        contentPane.setPreferredSize(new Dimension(400, 150));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel Message;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
