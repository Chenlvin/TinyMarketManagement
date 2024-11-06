package stu.sll.main.properties;

import stu.sll.main.common.constants.SqlConstant;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.properties
 * @Author: ZhouChenyi
 * @CreateTime: 2024-10-31  18:15
 * @Description: TODO
 * @Version: 1.0
 */

public class PropOp {
    public static boolean readProperties(String fileName) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);

            SqlConstant.setSqlUrl("jdbc:mysql://" + properties.getProperty("sql_address") + ":" + properties.getProperty("sql_port") + "/" + properties.getProperty("sql_database"));
            SqlConstant.setSqlUser(properties.getProperty("login_username"));
            SqlConstant.setSqlPwd(properties.getProperty("login_password"));

            System.out.println("settings.main.properties 读取完成");
            return true;
        } catch (IOException e) {
            System.err.println("读取配置文件失败：" + e.getMessage());
            System.out.println("--- 请查看 settings.main.properties 是否配置正确 ---");
            return false;
        }
    }
}

