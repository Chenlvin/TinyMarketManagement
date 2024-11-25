package stu.sll.main;

import stu.sll.main.common.service.StartService;
import stu.sll.main.view.frame.MainGUI;

/**
 *
 * [ Tiny Market Management ]
 *
 * @Title: Main
 */

public class Main {
    public static void main(String[] args) throws Exception {
            if(StartService.startService()) {
                MainGUI mainGui = new MainGUI();
                mainGui.setVisible(true);
            }
        }
}
