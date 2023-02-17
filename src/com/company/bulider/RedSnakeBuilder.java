package com.company.bulider;

import com.company.snake.RedSnake;
import com.company.snake.Snake;

/**
 * 身体为红色的蛇的生成器.
 *
 * @author bye
 * @version 1.0
 * @create 2023 -02-12 17:55
 */
public class RedSnakeBuilder extends SnakeBuilder {

    /**
     * 实例化.
     */
    public RedSnakeBuilder(){
        snake = new RedSnake();
    }

    @Override
    public SnakeBuilder setLength(int len) {
        snake.setLength(len);
        return this;
    }

    @Override
    public SnakeBuilder setDir(int dir) {
        snake.setDir(dir);
        return this;
    }

    @Override
    public Snake getSnake() {
        return snake;
    }
}
