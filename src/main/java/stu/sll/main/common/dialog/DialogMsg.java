package stu.sll.main.common.dialog;

import javax.swing.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.dialog
 * @Author: ZhouChenyi
 * @Description: Message dialog / 消息弹窗
 */

public class DialogMsg {
    public DialogMsg(String title, String msg) {
//        MessageDialogGUI messageDialog = new MessageDialogGUI(title,msg);
//        messageDialog.setVisible(true);
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
