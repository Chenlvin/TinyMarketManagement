package stu.sll.main.common.constants;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.constants
 * @Author: ZhouChenyi
 * @Description: Constant for login / 登录系统常量
 * @Version: 1.0
 */

public class LoginConstant {
    private static String Username = "null";
    private static String Password = "null";

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String username) {
        Username = username;
    }
}
