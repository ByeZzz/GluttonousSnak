package com.company.snake;

/**
 * 位置坐标.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 18:11
 */
public class  Position {
    /**
     * 横坐标.
     */
    int x;

    /**
     * 获取横坐标.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置横坐标.
     *
     * @param x 横坐标
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取纵坐标.
     *
     * @return 纵坐标
     */
    public int getY() {
        return y;
    }

    /**
     * 设置纵坐标.
     *
     * @param y 纵坐标
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 纵坐标.
     */
    int y;

    /**
     * 实例化.
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
