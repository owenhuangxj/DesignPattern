package com.owen;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author OwenHuang
 * @since 2022/11/2 20:53
 */
public class Tank1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setTitle("Tank War");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
