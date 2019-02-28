package com.general.tools.gui.computer_principle_gui;

import com.general.tools.computer_principle.NumberToNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 进制进制转换GUI面板，主要负责前端展示与后台方法调取
 **/
public class BiBinaryGui extends JPanel {
    public BiBinaryGui() {
        //布局管理器也太好用了吧，尤其是gridLayout
        this.setLayout(new GridLayout(5, 1, 0, 10));
        JPanel jPanel1 = new JPanel();
        //jPanel1.setBackground(Color.PINK);
        JPanel jPanel2 = new JPanel();
        //jPanel2.setBackground(Color.PINK);
        JPanel jPanel3 = new JPanel();
        //jPanel3.setBackground(Color.PINK);
        JPanel jPanel4 = new JPanel();
        //jPanel4.setBackground(Color.PINK);
        //-------------------------网格第一块----------------------------------
        //最外层网格布局
        jPanel1.setLayout(new GridLayout(4, 1, 0, 0));
        //标题用默认布局
        JPanel jPanel11 = new JPanel();
        jPanel11.setLayout(new BorderLayout());
        JLabel jLabel1 = new JLabel("     二进制转换器");
        jPanel11.add(jLabel1, BorderLayout.WEST);
        //----------------二进制转八进制布局----------------
        //第二行到第四行用流布局
        JPanel jPanel12 = new JPanel();
        jPanel12.setLayout(new FlowLayout());
        JLabel jLabel121 = new JLabel("二进制转八进制");
        JTextField jTextField122 = new JTextField(20);
        JButton jButton123 = new JButton("转换");
        JTextField jTextField124 = new JTextField(20);
        jButton123.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField124.setText(NumberToNumber.binaryToOctal(jTextField122.getText()));
            }
        });
        jPanel12.add(jLabel121);
        jPanel12.add(jTextField122);
        jPanel12.add(jButton123);
        jPanel12.add(jTextField124);
        //三行
        JPanel jPanel13 = new JPanel();
        jPanel13.setLayout(new FlowLayout());
        JLabel jLabel131 = new JLabel("二进制转十进制");
        JTextField jTextField132 = new JTextField(20);
        JButton jButton133 = new JButton("转换");
        JTextField jTextField134 = new JTextField(20);
        jButton133.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField134.setText(NumberToNumber.binaryToDecimal(jTextField132.getText()));
            }
        });
        jPanel13.add(jLabel131);
        jPanel13.add(jTextField132);
        jPanel13.add(jButton133);
        jPanel13.add(jTextField134);
        //四行
        JPanel jPanel14 = new JPanel();
        jPanel14.setLayout(new FlowLayout());
        JLabel jLabel141 = new JLabel("二进制转十六进制");
        JTextField jTextField142 = new JTextField(20);
        JTextField jTextField144 = new JTextField(20);
        JButton jButton143 = new JButton("转换");
        jButton143.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField144.setText(NumberToNumber.binaryToHex(jTextField142.getText()));
            }
        });
        jPanel14.add(jLabel141);
        jPanel14.add(jTextField142);
        jPanel14.add(jButton143);
        jPanel14.add(jTextField144);
        //
        jPanel1.add(jPanel11);
        jPanel1.add(jPanel12);
        jPanel1.add(jPanel13);
        jPanel1.add(jPanel14);
        //-------------------------网格第二块----------------------------------
        //最外层网格布局
        jPanel2.setLayout(new GridLayout(4, 1, 0, 0));
        //标题用默认布局
        JPanel jPanel21 = new JPanel();
        jPanel21.setLayout(new BorderLayout());
        JLabel jLabel2 = new JLabel("     八进制转换器");
        jPanel21.add(jLabel2, BorderLayout.WEST);
        //----------------二进制转八进制布局----------------
        //第二行到第四行用流布局
        JPanel jPanel22 = new JPanel();
        jPanel22.setLayout(new FlowLayout());
        JLabel jLabel221 = new JLabel("八进制转二进制");
        JTextField jTextField222 = new JTextField(20);
        JTextField jTextField224 = new JTextField(20);
        JButton jButton223 = new JButton("转换");
        jButton223.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField224.setText(NumberToNumber.octalToBinary(jTextField222.getText()));
            }
        });
        jPanel22.add(jLabel221);
        jPanel22.add(jTextField222);
        jPanel22.add(jButton223);
        jPanel22.add(jTextField224);
        //三行
        JPanel jPanel23 = new JPanel();
        jPanel23.setLayout(new FlowLayout());
        JLabel jLabel231 = new JLabel("八进制转十进制");
        JTextField jTextField232 = new JTextField(20);
        JTextField jTextField234 = new JTextField(20);
        JButton jButton233 = new JButton("转换");
        jButton233.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField234.setText(NumberToNumber.octalToDecimal(jTextField232.getText()));
            }
        });
        jPanel23.add(jLabel231);
        jPanel23.add(jTextField232);
        jPanel23.add(jButton233);
        jPanel23.add(jTextField234);
        //四行
        JPanel jPanel24 = new JPanel();
        jPanel24.setLayout(new FlowLayout());
        JLabel jLabel241 = new JLabel("八进制转十六进制");
        JTextField jTextField242 = new JTextField(20);
        JTextField jTextField244 = new JTextField(20);
        JButton jButton243 = new JButton("转换");
        jButton243.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField244.setText(NumberToNumber.octalToHex(jTextField242.getText()));
            }
        });
        jPanel24.add(jLabel241);
        jPanel24.add(jTextField242);
        jPanel24.add(jButton243);
        jPanel24.add(jTextField244);
        //
        jPanel2.add(jPanel21);
        jPanel2.add(jPanel22);
        jPanel2.add(jPanel23);
        jPanel2.add(jPanel24);
        //-------------------------网格第三块----------------------------------
        //最外层网格布局
        jPanel3.setLayout(new GridLayout(4, 1, 0, 0));
        //标题用默认布局
        JPanel jPanel31 = new JPanel();
        jPanel31.setLayout(new BorderLayout());
        JLabel jLabel3 = new JLabel("     十进制转换器");
        jPanel31.add(jLabel3, BorderLayout.WEST);
        //----------------二进制转十进制布局----------------
        //第二行到第四行用流布局
        JPanel jPanel32 = new JPanel();
        jPanel32.setLayout(new FlowLayout());
        JLabel jLabel321 = new JLabel("十进制转二进制");
        JTextField jTextField322 = new JTextField(20);
        JTextField jTextField324 = new JTextField(20);
        JButton jButton323 = new JButton("转换");
        jButton323.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField324.setText(NumberToNumber.decimalToBinary(jTextField322.getText()));
            }
        });
        jPanel32.add(jLabel321);
        jPanel32.add(jTextField322);
        jPanel32.add(jButton323);
        jPanel32.add(jTextField324);
        //三行
        JPanel jPanel33 = new JPanel();
        jPanel33.setLayout(new FlowLayout());
        JLabel jLabel331 = new JLabel("十进制转八进制");
        JTextField jTextField332 = new JTextField(20);
        JTextField jTextField334 = new JTextField(20);
        JButton jButton333 = new JButton("转换");
        jButton333.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField334.setText(NumberToNumber.decimalToOctal(jTextField332.getText()));
            }
        });
        jPanel33.add(jLabel331);
        jPanel33.add(jTextField332);
        jPanel33.add(jButton333);
        jPanel33.add(jTextField334);
        //四行
        JPanel jPanel34 = new JPanel();
        jPanel34.setLayout(new FlowLayout());
        JLabel jLabel341 = new JLabel("十进制转十六进制");
        JTextField jTextField342 = new JTextField(20);
        JTextField jTextField344 = new JTextField(20);
        JButton jButton343 = new JButton("转换");
        jButton343.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField344.setText(NumberToNumber.decimalToHex(jTextField342.getText()));
            }
        });
        jPanel34.add(jLabel341);
        jPanel34.add(jTextField342);
        jPanel34.add(jButton343);
        jPanel34.add(jTextField344);
        //
        jPanel3.add(jPanel31);
        jPanel3.add(jPanel32);
        jPanel3.add(jPanel33);
        jPanel3.add(jPanel34);
        //-------------------------网格第四块----------------------------------
        //最外层网格布局
        jPanel4.setLayout(new GridLayout(4, 1, 0, 0));
        //标题用默认布局
        JPanel jPanel41 = new JPanel();
        jPanel41.setLayout(new BorderLayout());
        JLabel jLabel4 = new JLabel("     十六进制转换器");
        jPanel41.add(jLabel4, BorderLayout.WEST);
        //----------------二进制转十进制布局----------------
        //第二行到第四行用流布局
        JPanel jPanel42 = new JPanel();
        jPanel42.setLayout(new FlowLayout());
        JLabel jLabel421 = new JLabel("十六进制转二进制");
        JTextField jTextField422 = new JTextField(20);
        JTextField jTextField424 = new JTextField(20);
        JButton jButton423 = new JButton("转换");
        jButton423.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField424.setText(NumberToNumber.hexToBinary(jTextField422.getText()));
            }
        });
        jPanel42.add(jLabel421);
        jPanel42.add(jTextField422);
        jPanel42.add(jButton423);
        jPanel42.add(jTextField424);
        //三行
        JPanel jPanel43 = new JPanel();
        jPanel43.setLayout(new FlowLayout());
        JLabel jLabel431 = new JLabel("十六进制转八进制");
        JTextField jTextField432 = new JTextField(20);
        JButton jButton433 = new JButton("转换");
        JTextField jTextField434 = new JTextField(20);
        jButton433.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField434.setText(NumberToNumber.hexlToOctal(jTextField432.getText()));
            }
        });
        jPanel43.add(jLabel431);
        jPanel43.add(jTextField432);
        jPanel43.add(jButton433);
        jPanel43.add(jTextField434);
        //四行
        JPanel jPanel44 = new JPanel();
        jPanel44.setLayout(new FlowLayout());
        JLabel jLabel441 = new JLabel("十六进制转十进制");
        JTextField jTextField442 = new JTextField(20);
        JTextField jTextField444 = new JTextField(20);
        JButton jButton443 = new JButton("转换");
        jButton443.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField444.setText(NumberToNumber.hexToDecimal(jTextField442.getText()));
            }
        });
        jPanel44.add(jLabel441);
        jPanel44.add(jTextField442);
        jPanel44.add(jButton443);
        jPanel44.add(jTextField444);
        //
        jPanel4.add(jPanel41);
        jPanel4.add(jPanel42);
        jPanel4.add(jPanel43);
        jPanel4.add(jPanel44);
        //
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
    }
}
