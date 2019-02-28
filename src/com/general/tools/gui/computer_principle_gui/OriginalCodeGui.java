package com.general.tools.gui.computer_principle_gui;

import com.general.tools.computer_principle.OriginalCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OriginalCodeGui extends JPanel {
    public OriginalCodeGui() {
        //这个实用网格布局，但仅实用原反补码的功能，仅占用第一个网格
        this.setLayout(new GridLayout(4,1));
        JPanel jPanel1=new JPanel();
        //jPanel1.setBackground(Color.CYAN);
        jPanel1.setLayout(new GridLayout(3,1,10,10));
        JPanel jPanel11=new JPanel();
        JLabel jLabel1=new JLabel("原码、反码、补码转换器（-127到127之间）");
        jPanel11.add(jLabel1);
        JPanel jPanel12=new JPanel();
        jPanel12.setLayout(new GridLayout(2,4));
        JTextField jTextField121 = new JTextField(20);
        JTextField jTextField122 = new JTextField(20);
        JButton jButton121 = new JButton("十进制->反码");
        jButton121.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField122.setText(OriginalCode.DecimalToInversecode(jTextField121.getText()));
            }
        });
        JButton jButton122 = new JButton("反码->十进制");
        jPanel12.add(jTextField121);
        jPanel12.add(jTextField122);
        jPanel12.add(jButton121);
        jPanel12.add(jButton122);
        //
        JPanel jPanel13=new JPanel();
        jPanel13.setLayout(new GridLayout(2,2));
        JTextField jTextField131 = new JTextField(20);
        JTextField jTextField132 = new JTextField(20);
        JButton jButton131 = new JButton("十进制->补码");
        JButton jButton132 = new JButton("补码->十进制");
        jPanel13.add(jTextField131);
        jPanel13.add(jTextField132);
        jPanel13.add(jButton131);
        jPanel13.add(jButton132);
        //
        jPanel1.add(jPanel11);
        jPanel1.add(jPanel12);
        jPanel1.add(jPanel13);

        this.add(jPanel1);
    }

}
