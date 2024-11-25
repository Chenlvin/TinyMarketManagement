package stu.sll.main.common.constants;

/**
 * @Title: LoginConstant
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.constants
 * @Description: Constants for login
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
