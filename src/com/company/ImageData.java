package com.company;

import javax.swing.*;

/**
 * 图像数据.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 16:46
 */
public class ImageData {
    /**
     * 向上运动蛇头部图片.
     */
    public static ImageIcon up = new ImageIcon("./src/image/head_up.png");
    /**
     * 向右运动蛇头部图片.
     */
    public static ImageIcon right = new ImageIcon("./src/image/head_right.png");
    /**
     * 向下运动蛇头部图片.
     */
    public static ImageIcon down = new ImageIcon("./src/image/head_down.png");
    /**
     * 向左运动蛇头部图片.
     */
    public static ImageIcon left = new ImageIcon("./src/image/head_left.png");
    /**
     * 蛇的身体（绿色）.
     */
    public static ImageIcon bodyGreen = new ImageIcon("./src/image/body.png");
    /**
     * 蛇的身体（红色）.
     */
    public static ImageIcon bodyRed = new ImageIcon("./src/image/body_red.png");
    /**
     * 蛇的身体（蓝色）.
     */
    public static ImageIcon bodyBlue = new ImageIcon("./src/image/body_blue.png");
    /**
     * 食物
     */
    public static ImageIcon food = new ImageIcon("./src/image/food.png");
}
