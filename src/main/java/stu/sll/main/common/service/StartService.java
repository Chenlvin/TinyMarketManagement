package stu.sll.main.common.service;

import org.apache.log4j.PropertyConfigurator;
import stu.sll.main.common.login.Login;
import stu.sll.main.common.util.DialogErr;
import stu.sll.main.common.theme.SetTheme;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.database.connection.SQLConnection;
import stu.sll.main.properties.PropCheck;
import stu.sll.main.view.dialog.Loading;

/**
 * @Title: StartService
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.service
 * @Description: Start main service
 */

public class StartService {
    public static boolean startService() {
        PropertyConfigurator.configure("src/log4j.properties");
        LogUtil.info("正在启动项目...");

        try {
            Loading loadDialog = new Loading("正在连接数据库...");
            loadDialog.setVisible(true);
            // 主题设置
            new SetTheme(0);
            boolean propcheck = PropCheck.PropCheck();
            boolean sqlconnection = SQLConnection.databaseConnect();

            if(sqlconnection && propcheck) {
                loadDialog.setVisible(false);
                loadDialog.dispose();
                // 转到登录GUI
                Login.StartLogin();
                // 等待登录
                while(!Login.getIsLogged()) {
                    Thread.sleep(100);
                }
                LogUtil.info("登录成功，启动程序主界面");
                return true;
            }


        } catch (Exception ex) {
            LogUtil.error(ex.getMessage());
            new DialogErr("启动项目时出错: " + ex.getMessage());
            return false;
        }
        return false;
    }
}
