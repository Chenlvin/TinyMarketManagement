package stu.sll.main.common.util;

import javax.swing.*;

/**
 * @Title: DialogError
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.util
 * @Description: Create error dialog
 */

public class DialogErr {
    public DialogErr(String message) {
        JOptionPane.showMessageDialog(null, message, "错误", JOptionPane.ERROR_MESSAGE);
    }
}
