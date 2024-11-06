package stu.sll.main.common.service;

import stu.sll.main.common.dialog.DialogErr;
import stu.sll.main.common.util.LogUtil;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.service
 * @Author: ZhouChenyi
 * @Description: 关闭程序
 * @Version: 1.0
 */

public class StopService {
    public StopService() {
        LogUtil.info("监听到 MainGUI 窗口关闭，正在停止服务");
        try {
            System.exit(0);
        } catch (Exception ex) {
            new DialogErr(ex.getMessage());
        }
    }
}
