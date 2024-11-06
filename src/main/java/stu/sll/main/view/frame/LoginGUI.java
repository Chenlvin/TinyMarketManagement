/*
 * Created by JFormDesigner on Fri Nov 01 11:41:50 CST 2024
 */

package stu.sll.main.view.frame;

import stu.sll.main.common.constants.LoginConstant;
import stu.sll.main.common.login.Login;
import stu.sll.main.database.operations.DBLogin;
import stu.sll.main.view.dialog.ErrorDialogGUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author ZhouChenyi
 */
public class LoginGUI extends JFrame {
    public LoginGUI() {
        initComponents();
    }

    // Login 按钮监听器
    private void Login(ActionEvent e) throws SQLException {
        System.out.println("登录按钮被点击，开始执行登录操作...");

        String username = usernamelabel.getText();
        String password = new String(passwordlabel.getPassword());
        try {
            if (DBLogin.dbLogin(username, password)) {
                // 登录成功
                LoginConstant.setUsername(username);
                LoginConstant.setPassword(password);
                Login.setIsLogged(true);
            } else {
                ErrorDialogGUI errorDialogGUI = new ErrorDialogGUI("登录失败：用户名或密码不正确。");
                errorDialogGUI.setVisible(true);
            }
        } catch (SQLException ex) {
            ErrorDialogGUI errorDialogGUI = new ErrorDialogGUI(ex.getMessage());
            errorDialogGUI.setVisible(true);
        }
    }

    private void initComponents() {
        setResizable(false);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        separator1 = new JSeparator();
        Username = new JLabel();
        Password = new JLabel();
        usernamelabel = new JTextField();
        passwordlabel = new JPasswordField();
        LoginButton = new JButton();

        //======== this ========
        setAutoRequestFocus(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u767b \u5f55");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(200, 5), label1.getPreferredSize()));

        //---- separator1 ----
        separator1.setBackground(Color.white);
        separator1.setForeground(Color.white);
        contentPane.add(separator1);
        separator1.setBounds(0, 40, 450, 10);

        //---- Username ----
        Username.setText("\u7528\u6237");
        Username.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(Username);
        Username.setBounds(new Rectangle(new Point(100, 90), Username.getPreferredSize()));

        //---- Password ----
        Password.setText("\u5bc6\u7801");
        Password.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(Password);
        Password.setBounds(new Rectangle(new Point(100, 145), Password.getPreferredSize()));
        contentPane.add(usernamelabel);
        usernamelabel.setBounds(180, 85, 190, 35);
        contentPane.add(passwordlabel);
        passwordlabel.setBounds(180, 140, 190, 35);

        //---- LoginButton ----
        LoginButton.setText("\u767b \u5f55");
        LoginButton.addActionListener(e -> {try {
Login(e);} catch (SQLException ex) {
    throw new RuntimeException(ex);
}});
        contentPane.add(LoginButton);
        LoginButton.setBounds(new Rectangle(new Point(185, 210), LoginButton.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(450, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JSeparator separator1;
    private JLabel Username;
    private JLabel Password;
    private JTextField usernamelabel;
    private JPasswordField passwordlabel;
    private JButton LoginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
