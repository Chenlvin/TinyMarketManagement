package stu.sll.main.properties;

/**
 * @Title: PropCheck
 * @Author: Chenlvin
 * @Package: stu.sll.main.properties
 * @Description: Check properties
 */

import stu.sll.main.common.util.LogUtil;

import java.io.File;

import static stu.sll.main.common.constants.Constant.SETTINGS_FILE_NAME;

public class PropCheck {
    public static boolean PropCheck() {
        String fileName = SETTINGS_FILE_NAME;
        File propertiesFile = new File(fileName);

        if (propertiesFile.exists()) {
            LogUtil.info("成功找到配置文件 " + fileName + " , 开始读取");
            return PropOp.readProperties(fileName);
        } else {
            LogUtil.info("未找到配置文件，尝试创建新的配置文件");
            return PropCreate.createPropertiesFile(fileName);
        }
    }
}
