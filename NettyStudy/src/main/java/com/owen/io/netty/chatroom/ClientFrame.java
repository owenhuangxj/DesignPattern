package com.owen.io.netty.chatroom;

import io.netty.util.internal.StringUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author OwenHuang
 * @since 2022/11/19 11:28
 */
public class ClientFrame extends Frame {
    private final TextArea textArea;

    private final TextField textField;

    private NettyClient client;
    private static final ClientFrame INSTANCE = new ClientFrame();

    private ClientFrame() {
        textArea = new TextArea();
        textArea.setEditable(false);
        this.add(textArea, BorderLayout.CENTER);
        textField = new TextField();
        this.add(textField, BorderLayout.SOUTH);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                client.sendMsg(textField.getText());
                String windowsText = textArea.getText();
                updateWindows((StringUtil.isNullOrEmpty(windowsText) ? "" :
                        windowsText + System.lineSeparator()) + "Me:" + textField.getText());
            }
        });
        this.setBounds(100, 100, 800, 600);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        // todo:这种方式调用无法连接服务器
        // connectToServer(8888);
    }

    public static ClientFrame getInstance() {
        return INSTANCE;
    }

    public void connectToServer(int port) {
        this.client = new NettyClient();
        this.client.connect(port);
    }

    public String getWindowsText() {
        return this.textArea.getText();
    }

    public void updateWindows(String msg) {
        textArea.setText(msg);
        this.textField.setText("");
    }
}
