package com.company.bulider;

import com.company.snake.Snake;

/**
 * 蛇的生成器.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 17:55
 */
public abstract class SnakeBuilder {

    /**
     * 蛇.
     */
    protected Snake snake;

    /**
     * 设置蛇的长度.
     *
     * @param len 蛇的长度
     * @return 构造器本身
     */
    public abstract SnakeBuilder setLength(int len);

    /**
     * 设置蛇的运行方向.
     *
     * @param dir 蛇的运行方向
     * @return the dir
     */
    public abstract SnakeBuilder setDir(int dir);

    /**
     * 获得构造的蛇对象.
     *
     * @return 蛇
     */
    public abstract Snake getSnake();
}
