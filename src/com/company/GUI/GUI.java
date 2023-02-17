package com.company.GUI;

import com.company.snake.Snake;
import javax.swing.*;

/**
 * 显示界面.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 17:24
 */
public class GUI {
    /**
     * Show.
     *
     * @param snake 蛇
     */
    public static void  show(Snake snake){
        JFrame frame = new JFrame("贪吃蛇");
        frame.setSize(900, 800);

        // 设置窗体为居中格式
        frame.setLocationRelativeTo(null);

        GamePanel panel = new GamePanel(snake);

        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


