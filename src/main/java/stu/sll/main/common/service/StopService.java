package stu.sll.main.common.service;

import stu.sll.main.common.util.DialogErr;
import stu.sll.main.common.util.LogUtil;

/**
 * @Title: StopService
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.service
 * @Description: Stop main service and exit
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
