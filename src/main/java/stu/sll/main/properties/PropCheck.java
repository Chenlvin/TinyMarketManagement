package stu.sll.main.properties;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.properties
 * @Author: ZhouChenyi
 * @Description: 检查 settings.main.properties 是否存在
 */

import stu.sll.main.common.constants.Constant;
import stu.sll.main.common.util.LogUtil;

import java.io.File;

public class PropCheck {
    public static boolean PropCheck() {
        String fileName = Constant.getSettingsFileName();
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
