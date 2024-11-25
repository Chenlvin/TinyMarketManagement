package stu.sll.main.common.theme;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import stu.sll.main.common.util.LogUtil;

import javax.swing.*;

/**
 * @Title: SetTheme
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.theme
 * @Description: Set theme
 */

public class SetTheme {
    public SetTheme(int code) throws Exception {
        LogUtil.info("开始读取主题设置");
        InitTheme(code);
    }

    public void InitTheme(int code) throws Exception {
        try {
            switch(code) {
                case 0: // Light
                    FlatIntelliJLaf.setup();
                    LogUtil.info("Setup theme - FlatIntelliJLaf");
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    break;
                case 1: // Dark
                    FlatDarkLaf.setup();
                    LogUtil.info("Setup theme - FlatDarkLaf");
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    break;
            }
        } catch( Exception ex ) {
            LogUtil.error(ex.getMessage());
            throw new Exception("加载Theme失败：Failed to initialize LaF");
        }
    }
}
