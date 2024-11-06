package stu.sll.main.common.login;

import stu.sll.main.view.frame.LoginGUI;

/**
 * @BelongsProject: Market
 * @BelongsPackage: main.common.login
 * @Author: ZhouChenyi
 * @Description: Login / 登录功能
 * @Version: 1.1
 */

public class Login {
    private static boolean isLogged = false;

    // 登录（创建GUI）
    public static void StartLogin() {
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
    }

    // Getter & Setter
    public static boolean getIsLogged() {
        return isLogged;
    }

    public static void setIsLogged(boolean isLogged) {
        Login.isLogged = isLogged;
    }
}
