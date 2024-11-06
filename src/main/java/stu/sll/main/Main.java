package stu.sll.main;

import stu.sll.main.common.theme.SetTheme;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;
import stu.sll.main.properties.PropCheck;
import stu.sll.main.view.dialog.ErrorDialogGUI;
import stu.sll.main.view.frame.MainGUI;

/**
 *  [ Market - Reloaded ]
 *
 * @BelongsProject: Market
 * @Author: ZhouChenyi
 * @Description: Entry
 * @Version: 1.0
 */

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            boolean sqlconnection = false;
            boolean propcheck = PropCheck.PropCheck();
            sqlconnection = SQLConnection.databaseConnect();

            if(sqlconnection && propcheck) { // 成功读取配置文件和数据库连接，转到登录
//                // 登录
//                Login.StartLogin();
//
//                //等待登录
//                while(!Login.getIsLogged()) {
//                    Thread.sleep(100);
//                }
                // 主题设置
                new SetTheme(1);
                // 启动 MainGUI
                MainGUI mainGui = new MainGUI();
                mainGui.setVisible(true);
            }

        } catch (Exception ex) {
            LogUtil.error("Error Catched By Main -> " + ex.getMessage());
            ErrorDialogGUI errorDialogGUI = new ErrorDialogGUI(ex.getMessage());
            errorDialogGUI.setVisible(true);
        }
    }
}
