package stu.sll.main;

import stu.sll.main.common.service.StartService;
import stu.sll.main.view.frame.MainGUI;

/**
 *  [ Market - Reloaded ]
 *
 *
 * @BelongsProject: Market
 * @Author: ZhouChenyi
 * @Description: Main Class
 */

public class Main {
    public static void main(String[] args) throws Exception {
            if(StartService.StartService() == true) {
                MainGUI mainGui = new MainGUI();
                mainGui.setVisible(true);
            }

        }
}
