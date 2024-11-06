/*
 * Created by JFormDesigner on Thu Oct 31 19:28:02 CST 2024
 */

package stu.sll.main.view.dialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author ZhouChenyi
 */
public class MessageDialogGUI extends JDialog {
    String Message = "null";
    String MsgTitle = "";
    public MessageDialogGUI(String title, String message) {
        this.Message = message;
        this.MsgTitle = title;
        initComponents();
    }

    private void ok(ActionEvent e) {
        MessageDialogGUI.this.dispose();
    }

    private void initComponents() {
        setResizable(false);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setTitle(MsgTitle);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new CardLayout(50, 0));

                //---- label1 ----
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                label1.setText(Message);
                contentPanel.add(label1, "card1");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new FlowLayout());

                //---- okButton ----
                okButton.setText("\u786e\u8ba4");
                okButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
