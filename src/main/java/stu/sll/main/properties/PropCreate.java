package stu.sll.main.properties;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.properties
 * @Author: ZhouChenyi
 * @Description: 创建新的 settings.main.properties
 */

import stu.sll.main.common.util.LogUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class PropCreate {
    public static boolean createPropertiesFile(String fileName) {
        Properties properties = new Properties();

        // 使用 LinkedHashMap 保持顺序
        Map<String, String> defaultProperties = new LinkedHashMap<>();
        defaultProperties.put("sql_address", "localhost");
        defaultProperties.put("sql_port", "3306");
        defaultProperties.put("sql_database", "market");
        defaultProperties.put("login_username", "root");
        defaultProperties.put("login_password", "pwd");

        // 将 LinkedHashMap 的内容添加到 Properties
        for (Map.Entry<String, String> entry : defaultProperties.entrySet()) {
            properties.setProperty(entry.getKey(), entry.getValue());
        }

        try (FileOutputStream output = new FileOutputStream(fileName)) {
            properties.store(output, "Settings File");
            LogUtil.info("成功创建配置文件 " + fileName);
            return true;
        } catch (IOException e) {
            LogUtil.error("创建配置文件时出错：" + e.getMessage());
            return false;
        }
    }
}

