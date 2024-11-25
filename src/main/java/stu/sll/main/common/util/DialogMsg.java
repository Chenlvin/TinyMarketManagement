package stu.sll.main.common.util;

import javax.swing.*;

/**
 * @Title: DialogMsg
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.util
 * @Description: Create message dialog
 */


public class DialogMsg {
    public DialogMsg(String title, String msg) { JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE); }
}
