package com.general.tools.gui;

import com.general.tools.gui.computer_principle_gui.BiBinaryGui;
import com.general.tools.gui.codinggui.AsciiGui;
import com.general.tools.gui.codinggui.GB_2312Gui;
import com.general.tools.gui.codinggui.UnicodeGui;
import com.general.tools.gui.codinggui.Utf_8Gui;
import com.general.tools.gui.computer_principle_gui.OriginalCodeGui;
import com.general.tools.gui.cryptorgui.AesDesGUI;
import com.general.tools.gui.cryptorgui.Md5ShaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 图形化界面主入口
 * **/
public class TotalGui {
    public void totalGui() {
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jFrame = new JFrame("GeneralTool V1.0");
        //设置主窗体位置
        jFrame.setBounds(100, 20, 850, 700);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);// 设置关闭退出
        //定义菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu("windows");
        JMenuItem jMenuItem11 = new JMenuItem("new");
        JMenuItem jMenuItem12 = new JMenuItem("open");
        jMenu1.add(jMenuItem11);
        jMenu1.add(jMenuItem12);
        JMenu jMenu2 = new JMenu("help");
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        //定义选项卡：这里想把计算机组成原理放在后面
        // http://c.biancheng.net/view/1263.html
        JTabbedPane jTabbedPane = new JTabbedPane();
        //
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(1, 1));
        jTabbedPane.addTab("编码解码器", jPanel1);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        AsciiGui asciiGui=new AsciiGui();
        jTabbedPane1.addTab("ASCII编码", asciiGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_1);
        UnicodeGui unicodeGui=new UnicodeGui();
        jTabbedPane1.addTab("Unicode编码", unicodeGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_2);
        Utf_8Gui utf_8Gui=new Utf_8Gui();
        jTabbedPane1.addTab("utf-8编码", utf_8Gui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_3);
        GB_2312Gui gb_2312Gui=new GB_2312Gui();
        jTabbedPane1.addTab("GB-2312编码", gb_2312Gui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_4);
        GB_2312Gui gb_2312Gui2=new GB_2312Gui();
        jTabbedPane1.addTab("BASE64编码", gb_2312Gui2);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_4);
        jPanel1.add(jTabbedPane1);
        //
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(1, 1));
        jTabbedPane.addTab("加密解密器", jPanel2);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_3);
        JTabbedPane jTabbedPane2= new JTabbedPane();
        Md5ShaGUI md5ShaGUI=new Md5ShaGUI();
        jTabbedPane2.addTab("hash加解密", md5ShaGUI);
        jTabbedPane2.setMnemonicAt(0, KeyEvent.VK_1);
        AesDesGUI aesGUI=new AesDesGUI();
        jTabbedPane2.addTab("AES、DES对称加解密", aesGUI);
        jTabbedPane2.setMnemonicAt(0, KeyEvent.VK_2);
        Utf_8Gui utf_8Gui2=new Utf_8Gui();
        jTabbedPane2.addTab("RSA、DSA非对称加解密", utf_8Gui2);
        jTabbedPane2.setMnemonicAt(0, KeyEvent.VK_3);
        //GB_2312Gui gb_2312Gui2=new GB_2312Gui();
        jPanel2.add(jTabbedPane2);
        //
        JPanel jPanel3 = new JPanel();
        //比较好的讲解布局的文章：https://blog.csdn.net/jianggujin/article/details/50445093
        jPanel3.setLayout(new GridLayout(1, 1)); //这里可以完全解决布局问题
        jTabbedPane.addTab("计算机组成原理", jPanel3);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        //在panel1中添加子元素
        JTabbedPane jTabbedPane3 = new JTabbedPane();
        BiBinaryGui biBinaryGui=new BiBinaryGui();
        jTabbedPane3.addTab("进制进制转换", biBinaryGui);
        jTabbedPane3.setMnemonicAt(0, KeyEvent.VK_1);
        OriginalCodeGui originalCodeGui=new OriginalCodeGui();
        jTabbedPane3.addTab("原反补码", originalCodeGui);
        jTabbedPane3.setMnemonicAt(0, KeyEvent.VK_2);
        jPanel3.add(jTabbedPane3);
        //
        JPanel jPanel4 = new JPanel();
        jTabbedPane.addTab("功能待定器", jPanel4);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_4);
        //添加菜单
        jFrame.setJMenuBar(jMenuBar);
        //添加选项卡
        jFrame.add(jTabbedPane);
        jFrame.setVisible(true);
    }




    public static void main(String[] args) {
        new TotalGui().totalGui();
    }
}
