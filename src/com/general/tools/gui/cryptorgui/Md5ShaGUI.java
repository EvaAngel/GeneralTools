package com.general.tools.gui.cryptorgui;

import javax.swing.*;
import java.awt.*;

public class Md5ShaGUI extends JPanel {
    public Md5ShaGUI()
    {
        this.setLayout(new GridLayout(2,1));
        JPanel jPanel1=new JPanel();
        GridBagLayout gradBayLayout=new GridBagLayout();
        jPanel1.setLayout(gradBayLayout);
        jPanel1.setBackground(Color.CYAN);
        JLabel jLabel1=new JLabel("MD5加解密");
        JTextArea jTextArea1=new JTextArea();
        jTextArea1.setLineWrap(true);
        jTextArea1.setFont(new Font("楷体",Font.BOLD,16));
        JTextArea jTextArea2=new JTextArea();
        jTextArea2.setLineWrap(true);
        jTextArea2.setFont(new Font("楷体",Font.BOLD,16));
        JButton jButton1=new JButton("加密");
        JButton jButton2=new JButton("解密");
        GridBagConstraints s= new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridwidth=1;
        s.weightx=1;
        s.weighty=0;
        gradBayLayout.setConstraints(jLabel1,s);
        gradBayLayout.setConstraints(jTextArea1,s);
        gradBayLayout.setConstraints(jTextArea2,s);
        gradBayLayout.setConstraints(jButton1,s);
        gradBayLayout.setConstraints(jButton2,s);



        JPanel jPanel2=new JPanel();

        this.add(jPanel1);
        this.add(jPanel2);

    }
}
