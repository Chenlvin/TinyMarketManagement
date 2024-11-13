package stu.sll.main.common.theme;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import stu.sll.main.common.util.LogUtil;

import javax.swing.*;

/**
 * @BelongsProject: Market
 * @BelongsPackage: stu.sll.main.common.theme
 * @Author: ZhouChenyi
 * @Description: Theme / 主题设置
 */

public class SetTheme {
    public SetTheme(int code) throws Exception {
        LogUtil.info("开始读取主题设置");
        InitTheme(code);
    }

    public void InitTheme(int code) throws Exception {
        try {
            switch(code) {
                case 0:
                    FlatIntelliJLaf.setup();
                    LogUtil.info("Setup theme - FlatIntelliJLaf");
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    break;
                case 1:
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
