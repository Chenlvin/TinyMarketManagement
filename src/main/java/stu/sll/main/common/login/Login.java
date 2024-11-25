package stu.sll.main.common.login;

import stu.sll.main.view.frame.LoginGUI;

/**
 * @Title: Login
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.login
 * @Description: Login Function
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
