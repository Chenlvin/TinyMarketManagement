package stu.sll.main.common.dialog;

import javax.swing.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.dialog
 * @Author: ZhouChenyi
 * @Description: Error dialog / 错误提示框
 */

public class DialogErr {

    // 使用自定义GUI-ErrorDialogGUI
//    public DialogErr(String message) {
//        ErrorDialogGUI errorDialog = new ErrorDialogGUI(message);
//        errorDialog.setVisible(true);
//    }

    public DialogErr(String message) {
        JOptionPane.showMessageDialog(null, message, "错误", JOptionPane.ERROR_MESSAGE);
    }
}
