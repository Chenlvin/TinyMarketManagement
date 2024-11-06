/*
 * Created by JFormDesigner on Fri Nov 01 10:57:28 CST 2024
 */

package stu.sll.main.view.frame;

import javax.swing.table.*;

import stu.sll.main.common.dialog.DialogMsg;
import stu.sll.main.common.service.StopService;
import stu.sll.main.common.uiEvent.product.*;
import stu.sll.main.common.uiEvent.stock.*;
import stu.sll.main.common.util.LogUtil;
import stu.sll.main.view.panel.AboutGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Zhou Chenlvin
 */
public class MainGUI extends JFrame {
    public MainGUI() {
        LogUtil.info("启动主界面 MainGUI");
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        ProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void ProductSearch(ActionEvent e) { new ProductSearch((String) ProductType.getSelectedItem(), ProductKeyword.getText(),ProductTable); }

    private void About(ActionEvent e) {
        AboutGUI aboutGUI = new AboutGUI();
        aboutGUI.setVisible(true);
    }

    private void ProductAdd(ActionEvent e) { new ProductAdd(); }

    private void SettingsMenu(ActionEvent e) {
        new DialogMsg("提示","Alpha 测试版本，该功能暂未开发！");
    }

    // 监听窗口关闭按钮
    private void thisWindowClosing(WindowEvent e) {
        int flag = JOptionPane.showConfirmDialog(new JFrame(), "是否退出程序？",
                "提示", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if(JOptionPane.YES_OPTION == flag){
            LogUtil.info("用户点击确认关闭按钮，执行关闭指令");
            MainGUI.this.dispose();
        }
    }

    private void thisWindowClosed(WindowEvent e) {
        new StopService();
    }

    private void ProductDelete(ActionEvent e) {
        new ProductDelete(ProductTable.getSelectedRow(), ProductTable);
    }

    private void StockSearch(ActionEvent e) {
        new StockSearch((String) StockType.getSelectedItem(), StockKeyword.getText(), StockTable);
    }

    private void StockAdd(ActionEvent e) { new StockAdd(); }

    private void SaleSearch(ActionEvent e) {
        // TODO add your code here
    }

    private void SaleAdd(ActionEvent e) {
        // TODO add your code here
    }

    private void StockDelete(ActionEvent e) {
        new StockDelete(StockTable.getSelectedRow(), StockTable);
    }

    private void SaleDelete(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu3 = new JMenu();
        Settings = new JMenuItem();
        About = new JMenuItem();
        tabbedPane1 = new JTabbedPane();
        HomePage = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        SalePage = new JPanel();
        SaleScrollPane = new JScrollPane();
        SaleTable = new JTable();
        SaleKeyword = new JTextField();
        SaleType = new JComboBox<>();
        SaleSearch = new JButton();
        SaleAdd = new JButton();
        SaleDelete = new JButton();
        ProductPage = new JPanel();
        ProductScrollPane = new JScrollPane();
        ProductTable = new JTable();
        ProductKeyword = new JTextField();
        ProductType = new JComboBox<>();
        ProductSearch = new JButton();
        ProductAdd = new JButton();
        ProductDelete = new JButton();
        StockPage = new JPanel();
        StockScrollPane = new JScrollPane();
        StockTable = new JTable();
        StockKeyword = new JTextField();
        StockType = new JComboBox<>();
        StockSearch = new JButton();
        StockAdd = new JButton();
        StockDelete = new JButton();

        //======== this ========
        setTitle("Market Management");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu3 ========
            {
                menu3.setText("\u83dc\u5355");

                //---- Settings ----
                Settings.setText("\u8bbe\u7f6e");
                Settings.addActionListener(e -> SettingsMenu(e));
                menu3.add(Settings);

                //---- About ----
                About.setText("\u5173\u4e8e");
                About.addActionListener(e -> About(e));
                menu3.add(About);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== tabbedPane1 ========
        {

            //======== HomePage ========
            {
                HomePage.setLayout(null);

                //---- label1 ----
                label1.setText("Market Management");
                label1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
                HomePage.add(label1);
                label1.setBounds(125, 155, 435, label1.getPreferredSize().height);

                //---- label2 ----
                label2.setText("\u8d85\u5e02\u7ba1\u7406\u7cfb\u7edf");
                label2.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 35));
                HomePage.add(label2);
                label2.setBounds(115, 115, 360, label2.getPreferredSize().height);
            }
            tabbedPane1.addTab("\u4e3b\u9875", HomePage);

            //======== SalePage ========
            {
                SalePage.setLayout(null);

                //======== SaleScrollPane ========
                {

                    //---- SaleTable ----
                    SaleTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\u5546\u54c1\u7f16\u53f7", "\u5546\u54c1\u540d\u79f0", "\u7c7b\u522b", "\u4ef7\u683c", "\u5e93\u5b58\u91cf"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    SaleTable.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
                    SaleTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    SaleTable.setAutoCreateRowSorter(true);
                    SaleTable.setBackground(Color.gray);
                    SaleTable.setFillsViewportHeight(true);
                    SaleTable.setMinimumSize(new Dimension(75, 20));
                    SaleTable.setRowHeight(30);
                    SaleTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    SaleTable.setGridColor(Color.white);
                    SaleScrollPane.setViewportView(SaleTable);
                }
                SalePage.add(SaleScrollPane);
                SaleScrollPane.setBounds(15, 90, 745, 405);
                SalePage.add(SaleKeyword);
                SaleKeyword.setBounds(395, 30, 180, 40);

                //---- SaleType ----
                SaleType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u540d\u79f0",
                    "\u7c7b\u522b"
                }));
                SalePage.add(SaleType);
                SaleType.setBounds(575, 30, 78, 40);

                //---- SaleSearch ----
                SaleSearch.setText("\u67e5\u8be2");
                SaleSearch.addActionListener(e -> SaleSearch(e));
                SalePage.add(SaleSearch);
                SaleSearch.setBounds(670, 30, 90, 40);

                //---- SaleAdd ----
                SaleAdd.setText("\u6dfb\u52a0");
                SaleAdd.addActionListener(e -> SaleAdd(e));
                SalePage.add(SaleAdd);
                SaleAdd.setBounds(785, 120, 90, 40);

                //---- SaleDelete ----
                SaleDelete.setText("\u5220\u9664\u6240\u9009");
                SaleDelete.addActionListener(e -> SaleDelete(e));
                SalePage.add(SaleDelete);
                SaleDelete.setBounds(785, 180, 90, 40);
            }
            tabbedPane1.addTab("\u9500\u552e", SalePage);

            //======== ProductPage ========
            {
                ProductPage.setLayout(null);

                //======== ProductScrollPane ========
                {

                    //---- ProductTable ----
                    ProductTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\u5546\u54c1\u7f16\u53f7", "\u5546\u54c1\u540d\u79f0", "\u7c7b\u522b", "\u4ef7\u683c", "\u5e93\u5b58\u91cf"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    ProductTable.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
                    ProductTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    ProductTable.setAutoCreateRowSorter(true);
                    ProductTable.setBackground(Color.gray);
                    ProductTable.setFillsViewportHeight(true);
                    ProductTable.setMinimumSize(new Dimension(75, 20));
                    ProductTable.setRowHeight(30);
                    ProductTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    ProductTable.setGridColor(Color.white);
                    ProductScrollPane.setViewportView(ProductTable);
                }
                ProductPage.add(ProductScrollPane);
                ProductScrollPane.setBounds(15, 90, 745, 405);
                ProductPage.add(ProductKeyword);
                ProductKeyword.setBounds(395, 30, 180, 40);

                //---- ProductType ----
                ProductType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u540d\u79f0",
                    "\u7c7b\u522b"
                }));
                ProductPage.add(ProductType);
                ProductType.setBounds(575, 30, ProductType.getPreferredSize().width, 40);

                //---- ProductSearch ----
                ProductSearch.setText("\u67e5\u8be2");
                ProductSearch.addActionListener(e -> ProductSearch(e));
                ProductPage.add(ProductSearch);
                ProductSearch.setBounds(670, 30, 90, 40);

                //---- ProductAdd ----
                ProductAdd.setText("\u6dfb\u52a0");
                ProductAdd.addActionListener(e -> ProductAdd(e));
                ProductPage.add(ProductAdd);
                ProductAdd.setBounds(785, 120, 90, 40);

                //---- ProductDelete ----
                ProductDelete.setText("\u5220\u9664\u6240\u9009");
                ProductDelete.addActionListener(e -> ProductDelete(e));
                ProductPage.add(ProductDelete);
                ProductDelete.setBounds(785, 180, 90, 40);
            }
            tabbedPane1.addTab("\u5546\u54c1\u7ba1\u7406", ProductPage);

            //======== StockPage ========
            {
                StockPage.setLayout(null);

                //======== StockScrollPane ========
                {

                    //---- StockTable ----
                    StockTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                        },
                        new String[] {
                            "\u5e93\u5b58\u7f16\u53f7", "\u5546\u54c1\u540d\u79f0", "\u7c7b\u522b", "\u5165\u5e93\u6570\u91cf", "\u5165\u5e93\u65f6\u95f4"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = StockTable.getColumnModel();
                        cm.getColumn(0).setMaxWidth(100);
                        cm.getColumn(3).setMaxWidth(100);
                        cm.getColumn(4).setMinWidth(200);
                    }
                    StockTable.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
                    StockTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    StockTable.setAutoCreateRowSorter(true);
                    StockTable.setBackground(Color.gray);
                    StockTable.setFillsViewportHeight(true);
                    StockTable.setMinimumSize(new Dimension(75, 20));
                    StockTable.setRowHeight(30);
                    StockTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                    StockTable.setGridColor(Color.white);
                    StockScrollPane.setViewportView(StockTable);
                }
                StockPage.add(StockScrollPane);
                StockScrollPane.setBounds(15, 90, 745, 405);
                StockPage.add(StockKeyword);
                StockKeyword.setBounds(365, 30, 180, 40);

                //---- StockType ----
                StockType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u5546\u54c1\u540d\u79f0",
                    "\u5206\u7c7b"
                }));
                StockPage.add(StockType);
                StockType.setBounds(545, 30, 108, 40);

                //---- StockSearch ----
                StockSearch.setText("\u67e5\u8be2");
                StockSearch.addActionListener(e -> StockSearch(e));
                StockPage.add(StockSearch);
                StockSearch.setBounds(670, 30, 90, 40);

                //---- StockAdd ----
                StockAdd.setText("\u6dfb\u52a0");
                StockAdd.addActionListener(e -> StockAdd(e));
                StockPage.add(StockAdd);
                StockAdd.setBounds(785, 120, 90, 40);

                //---- StockDelete ----
                StockDelete.setText("\u5220\u9664\u6240\u9009");
                StockDelete.addActionListener(e -> StockDelete(e));
                StockPage.add(StockDelete);
                StockDelete.setBounds(785, 180, 90, 40);
            }
            tabbedPane1.addTab("\u5e93\u5b58\u7ba1\u7406", StockPage);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 898, 547);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu3;
    private JMenuItem Settings;
    private JMenuItem About;
    private JTabbedPane tabbedPane1;
    private JPanel HomePage;
    private JLabel label1;
    private JLabel label2;
    private JPanel SalePage;
    private JScrollPane SaleScrollPane;
    private JTable SaleTable;
    private JTextField SaleKeyword;
    private JComboBox<String> SaleType;
    private JButton SaleSearch;
    private JButton SaleAdd;
    private JButton SaleDelete;
    private JPanel ProductPage;
    private JScrollPane ProductScrollPane;
    private JTable ProductTable;
    private JTextField ProductKeyword;
    private JComboBox<String> ProductType;
    private JButton ProductSearch;
    private JButton ProductAdd;
    private JButton ProductDelete;
    private JPanel StockPage;
    private JScrollPane StockScrollPane;
    private JTable StockTable;
    private JTextField StockKeyword;
    private JComboBox<String> StockType;
    private JButton StockSearch;
    private JButton StockAdd;
    private JButton StockDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
